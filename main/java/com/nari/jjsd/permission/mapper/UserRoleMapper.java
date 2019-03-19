package com.nari.jjsd.permission.mapper;

import com.nari.jjsd.permission.model.UserRole;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    List<String> findRoleIdByUserId(Long id);

}
