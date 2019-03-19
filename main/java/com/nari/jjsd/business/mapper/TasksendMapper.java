package com.nari.jjsd.business.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.nari.jjsd.business.model.Tasksend;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
public interface TasksendMapper extends BaseMapper<Tasksend> {
    List<Tasksend> querytasksendList(Pagination page, Tasksend tasksend);

    /**
     * 根据任务id查询
     * @param tsId
     * @return
     */
    Tasksend querytasksend( @Param("tsId")String tsId);

   // Tasksend querytasksend( @Param("tsId")String tsId,@Param("taskId")String taskId);

    /**
     * 根据任务id查询
     * @param taskId
     * @return
     */
   Tasksend querytasksendtaskid( @Param("taskId")String taskId);


}
