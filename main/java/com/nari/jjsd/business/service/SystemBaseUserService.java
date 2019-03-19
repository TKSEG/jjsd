package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.TSBaseUser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
public interface SystemBaseUserService extends IService<TSBaseUser> {
    List<TSBaseUser> queryIduserName();
}
