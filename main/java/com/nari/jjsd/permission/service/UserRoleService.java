package com.nari.jjsd.permission.service;

import com.nari.jjsd.permission.model.UserRole;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */

public interface UserRoleService extends IService<UserRole> {
    List<String> findRoleIdByUserId(Long id);
}
