package com.nari.jjsd.business.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Project;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2018-12-17
 */
public interface ProjectService extends IService<Project> {

    //分页
    Page<Project> selectProjecPage(int pageNo, int pageSize,Project project);


    int insertProject(Project project);

   // int updateById(Project project);
    int updaateById(Project project);
}
