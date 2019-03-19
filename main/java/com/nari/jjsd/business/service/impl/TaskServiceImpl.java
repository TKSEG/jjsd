package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Task;
import com.nari.jjsd.business.mapper.TaskMapper;
import com.nari.jjsd.business.service.TaskService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.core.shiro.token.manger.TokenManager;
import com.nari.jjsd.permission.model.User;
import com.nari.jjsd.util.commom.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {
    @Autowired
    private TaskMapper taskMapper;

    @Override
    public int updaateById(Task task) {
        Integer count = baseMapper.updateById(task);
        return count;
    }

    @Override
    public List<Task> inquireWfstatus(String wfStatus) {
        return baseMapper.inquireWfstatus(wfStatus);
    }

    @Override
    public List<Task> inquireWfstatusAPPROVE() {
        return baseMapper.inquireWfstatusAPPROVE();
    }

    @Override
    public Page<Task> selectTaskPage(int pageNo, int pageSize) {
        Page<Task> page = new Page<Task>(pageNo, pageSize);
        return page.setRecords(taskMapper.selectTaskPage(page));
    }

    /**
     * 创建任务
     *
     * @param task 任务ID
     * @return 返回是否创建成功
     * @throws Exception
     */
    @Override
    public String createTaskItem(Task task, String self) throws Exception {
        //登录人信息
        User token = TokenManager.getToken();

        int count;
        //任务自提
        if (self.equals(ConstUtil.SEND_FLAG_Y)) {
            task.setCreatedbyName(token.getNickname());
            task.setCreatedbyId(token.getId().toString());
         //   task.setCreatedAt(new Date());
            task.setSendFlag(ConstUtil.SEND_FLAG_Y);
            count = baseMapper.insert(task);
            if(count>0){
               // taskid=task.getTaskId();
            }

        } else {
            task.setCreatedbyName(token.getNickname());
            task.setCreatedbyId(token.getId().toString());
       //     task.setCreatedAt(new Date().toString());
            task.setSendFlag(ConstUtil.N_FLAG);
            count = baseMapper.insert(task);
            if(count>0){
            //   taskid=task.getTaskId();
            }
        }
        return task.getTaskId();
    }


}
