package com.nari.jjsd.business.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Project;
import com.nari.jjsd.business.model.Task;
import com.nari.jjsd.business.model.Tasksend;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
public interface TasksendService extends IService<Tasksend> {
    int updaateById(Tasksend tasksend);
    /**
     *  分页查询
     * @param pageNo
     * @param pageSize
     * @param tasksend
     * @return
     */
    Page<Tasksend> querytasksendList(int pageNo, int pageSize, Tasksend tasksend);

    /**
     * 创建任务自提
     *
     * @param taskSend 任务ID
     * @return 返回对应的任务ID
     * @throws Exception
     */
    public String createTaskSendItem(Tasksend taskSend, String self) throws Exception;


    /**
     *  id查询
     * @param taskId
     * @return
     */
    Tasksend querytasksend(String taskId);

    /**
     *  id查询
     * @param taskId
     * @return
     */
    Tasksend querytasksendtaskid(String taskId);
  //  Tasksend querytasksend(String tsid,String taskId);

}
