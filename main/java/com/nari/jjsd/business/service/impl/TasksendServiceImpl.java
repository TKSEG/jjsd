package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Project;
import com.nari.jjsd.business.model.Tasksend;
import com.nari.jjsd.business.mapper.TasksendMapper;
import com.nari.jjsd.business.service.TasksendService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.core.shiro.token.manger.TokenManager;
import com.nari.jjsd.permission.model.User;
import com.nari.jjsd.util.commom.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TasksendServiceImpl extends ServiceImpl<TasksendMapper, Tasksend> implements TasksendService {

    @Override
    public int updaateById(Tasksend tasksend) {
        Integer count = baseMapper.updateById(tasksend);
        return count;
    }

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @param tasksend
     * @return
     */
    @Override
    public Page<Tasksend> querytasksendList(int pageNo, int pageSize, Tasksend tasksend) {
        Page<Tasksend> page = new Page<Tasksend>(pageNo, pageSize);
        return page.setRecords(baseMapper.querytasksendList(page,tasksend));
    }

    /**
     * 创建任务自提
     *
     * @param tasksend 任务ID
     * @return 返回对应的任务ID
     * @throws Exception
     */
    @Override
    public String createTaskSendItem(Tasksend tasksend, String self) throws Exception {
        //登录人信息
        User token = TokenManager.getToken();

        tasksend.setCreatedbyName(token.getNickname());
        tasksend.setCreatedbyId(token.getId().toString());
        //   task.setCreatedAt(new Date());
        tasksend.setSrcFlag(ConstUtil.SRC_SELF_FLAG);
        baseMapper.insert(tasksend);
        return tasksend.getTsId();

    }
 /*
    @Override
    public Tasksend querytasksend(String tsid, String taskId) {
        return baseMapper.querytasksend(tsid,taskId);
}

  */
    @Override
    public Tasksend querytasksend(String taskId) {
        return baseMapper.querytasksend(taskId);
    }

    @Override
    public Tasksend querytasksendtaskid(String taskId) {
        return baseMapper.querytasksendtaskid(taskId);
    }


}
