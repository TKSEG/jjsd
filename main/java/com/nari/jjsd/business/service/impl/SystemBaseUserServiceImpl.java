package com.nari.jjsd.business.service.impl;

import com.nari.jjsd.business.model.TSBaseUser;
import com.nari.jjsd.business.mapper.TSBaseUserMapper;
import com.nari.jjsd.business.service.SystemBaseUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
@Service
public class SystemBaseUserServiceImpl extends ServiceImpl<TSBaseUserMapper, TSBaseUser> implements SystemBaseUserService {
    // @Override
    // public List<TSBaseUser> queryIduserName() {
    //    return null;
    // }

    @Override
    public List<TSBaseUser> queryIduserName() {
        return baseMapper.queryIduserName();
    }
}
