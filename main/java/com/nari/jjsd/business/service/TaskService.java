package com.nari.jjsd.business.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Project;
import com.nari.jjsd.business.model.Task;
import com.baomidou.mybatisplus.service.IService;
import com.nari.jjsd.business.model.Workflow;
import com.nari.jjsd.permission.model.User;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
public interface TaskService extends IService<Task> {
    int updaateById(Task task);

    List<Task> inquireWfstatus(String wfStatus);

    List<Task> inquireWfstatusAPPROVE();

    //分页
    Page<Task> selectTaskPage(int pageNo, int pageSize);


    /**
     * 创建任务
     *
     * @param task 任务ID
     * @return 返回对应的任务ID
     * @throws Exception
     */
    public String createTaskItem(Task task, String self) throws Exception;

}
