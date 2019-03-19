package com.nari.jjsd.permission.service.impl;

import com.nari.jjsd.permission.model.Permission;
import com.nari.jjsd.permission.mapper.PermissionMapper;
import com.nari.jjsd.permission.model.RolePermission;
import com.nari.jjsd.permission.service.PermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.permission.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2018-11-27
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Autowired
    private RolePermissionService rolepermissionService;
    @Override
    public Set<String> findPermissionByUserId(Long userId) {
        return baseMapper.findPermissionByUserId(userId);
    }

    @Override
    public List<Permission> getPermissionTree() {
        return baseMapper.getPermissionTree();
    }

    @Override
    public List<String> findPermissionByRoleId(Long id) {
        return baseMapper.findPermissionByRoleId(id);
    }

    @Override
    public Long getParentIdByMenuParentId(Integer parentId) {
        return  baseMapper.getParentIdByMenuParentId(parentId);
    }

    @Override
    public int insert2(Permission permission) {
        Integer count = baseMapper.insert(permission);
        //给admin角色添加这个权限
        RolePermission rp = new RolePermission();
        rp.setPid(permission.getId());
        rp.setRid(1L);
        rolepermissionService.insert(rp);
        return count;

    }
}
