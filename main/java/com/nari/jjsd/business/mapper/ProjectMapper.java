package com.nari.jjsd.business.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.nari.jjsd.business.model.Project;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yb
 * @since 2018-12-17
 */
@Repository
public interface ProjectMapper extends BaseMapper<Project> {

    List<Project> selectProjecPage(Pagination page,Project project);
}
