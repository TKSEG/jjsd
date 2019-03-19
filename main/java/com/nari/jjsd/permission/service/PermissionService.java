package com.nari.jjsd.permission.service;

import com.nari.jjsd.permission.model.Permission;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2018-11-27
 */

public interface PermissionService extends IService<Permission> {
    Set<String> findPermissionByUserId(Long userId);

    List<Permission> getPermissionTree();

    List<String> findPermissionByRoleId(Long id);

    Long getParentIdByMenuParentId(Integer parentId);

    int insert2(Permission permission);
}
