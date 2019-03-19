package com.nari.jjsd.business.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.nari.jjsd.business.model.Task;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nari.jjsd.business.model.Workflow;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
public interface TaskMapper extends BaseMapper<Task> {
    public List<Task> inquireWfstatus(String wfStatus);
    public List<Task> inquireWfstatusAPPROVE();
    //分页
    List<Task> selectTaskPage(Pagination page);


}




