package com.nari.jjsd.permission.mapper;

import com.nari.jjsd.permission.model.Role;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yb
 * @since 2018-11-28
 */
public interface RoleMapper extends BaseMapper<Role> {
    Set<String> findRoleByUserId(Long userId);
}
