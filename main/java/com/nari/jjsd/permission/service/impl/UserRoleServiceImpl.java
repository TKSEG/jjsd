package com.nari.jjsd.permission.service.impl;

import com.nari.jjsd.permission.model.UserRole;
import com.nari.jjsd.permission.mapper.UserRoleMapper;
import com.nari.jjsd.permission.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

    @Override
    public List<String> findRoleIdByUserId(Long id) {
        return baseMapper.findRoleIdByUserId(id);
    }
}
