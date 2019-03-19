package com.nari.jjsd.business.mapper;

import com.nari.jjsd.business.model.TSRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
public interface TSRoleMapper extends BaseMapper<TSRole> {
    public List<TSRole> selectrolename(String id) throws Exception;

}
