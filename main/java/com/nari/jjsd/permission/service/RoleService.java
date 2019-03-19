package com.nari.jjsd.permission.service;

import com.nari.jjsd.permission.model.Role;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2018-11-28
 */

public interface RoleService extends IService<Role> {
    Set<String> findRoleByUserId(Long userId);

    int insertRoleAndPermission(Role role, String pids);

    int updateById(Role role, String pids);

}
