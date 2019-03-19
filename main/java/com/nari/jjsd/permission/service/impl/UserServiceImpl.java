package com.nari.jjsd.permission.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nari.jjsd.permission.model.User;
import com.nari.jjsd.permission.mapper.UserMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.permission.model.UserRole;
import com.nari.jjsd.permission.service.UserRoleService;
import com.nari.jjsd.permission.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserRoleService userRoleService;

    @Override
    public User login(String username, String pswd) {
        User user = new User();
        user.setEmail(username);
        user.setPswd(pswd);
        User user1 = baseMapper.selectOne(user);
        return user1;
    }

    @Override
    public void updateByPrimaryKeySelective(User user) {
        baseMapper.updateById(user);
    }

    @Override
    public int insertUserAndRole(User user, String rids) {
        int count = baseMapper.insert(user);
        Long uid = user.getId();
        String[] ids = rids.split(",");
        for (int i=0;i<ids.length;i++){
            UserRole ur = new UserRole();
            ur.setUid(uid);
            ur.setRid(Long.parseLong(ids[i]));
            userRoleService.insert(ur);
        }
        return count;
    }

    /**
     * 修改用户角色信息
     * @param user
     * @param rids
     * @return
     */
    @Override
    public int updateById(User user, String rids) {
        int count = baseMapper.updateById(user);
        Long uid = user.getId();
        String[] ids = rids.split(",");
        userRoleService.delete(new EntityWrapper<UserRole>().eq("uid",uid));
        for (int i=0;i<ids.length;i++){
            UserRole ur = new UserRole();
            ur.setUid(uid);
            ur.setRid(Long.parseLong(ids[i]));
            userRoleService.insert(ur);
        }
        return count;
    }

    @Override
    public void initQuellaData() {
        baseMapper.initQuellaData();
    }
}
