package com.nari.jjsd.business.mapper;

import com.nari.jjsd.business.model.TSRole;
import com.nari.jjsd.business.model.TSRoleUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
public interface TSRoleUserMapper extends BaseMapper<TSRoleUser> {
    public List<TSRoleUser> queryroleuserid(String id) throws Exception;


}
