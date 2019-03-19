package com.nari.jjsd.business.service.impl;

import com.nari.jjsd.business.mapper.UteamMapper;
import com.nari.jjsd.business.model.Uteam;
import com.nari.jjsd.business.service.UteamService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2019-03-15
*/
@Service
public class UteamServiceImpl extends ServiceImpl<UteamMapper, Uteam> implements UteamService {

    @Override
    public int insertUteam(Uteam team) {
        Integer count = baseMapper.insert(team);
        return count;
    }
}
