package com.nari.jjsd.permission.service;

import com.nari.jjsd.permission.model.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */

public interface UserService extends IService<User> {
    User login(String username, String pswd);

    void updateByPrimaryKeySelective(User user);

    int insertUserAndRole(User user, String rids);

    int updateById(User user, String rids);

    void initQuellaData();
}
