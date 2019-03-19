package com.nari.jjsd.permission.mapper;

import com.nari.jjsd.permission.model.Permission;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yb
 * @since 2018-11-27
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    Set<String> findPermissionByUserId(Long userId);

    List<Permission> getPermissionTree();

    List<String> findPermissionByRoleId(Long id);

    Long getParentIdByMenuParentId(Integer menuParentId);
}
