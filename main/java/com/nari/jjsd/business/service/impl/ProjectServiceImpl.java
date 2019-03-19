package com.nari.jjsd.business.service.impl;



import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.business.mapper.ProjectMapper;
import com.nari.jjsd.business.model.Project;
import com.nari.jjsd.permission.service.PermissionService;
import com.nari.jjsd.business.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2018-12-17
 */
@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
   @Autowired
   private ProjectMapper projectMapper;


    @Override
    public Page<Project> selectProjecPage(int pageNo, int pageSize,Project project) {
        Page<Project> page = new Page<Project>(pageNo, pageSize);
      //  List<Project> list = projectMapper.selectModelPage(page,project);

       // return projectMapper.selectModelPage(page,project);
        return page.setRecords(projectMapper.selectProjecPage(page,project));
    }



    @Override
    public int insertProject(Project project) {

        Integer count = baseMapper.insert(project);
        return count;
    }

    @Override
    public int updaateById(Project project) {
        Integer count = baseMapper.updateById(project);
        return count;
    }
}