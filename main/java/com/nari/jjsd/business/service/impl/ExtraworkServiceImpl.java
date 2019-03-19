package com.nari.jjsd.business.service.impl;

import com.nari.jjsd.business.model.Extrawork;
import com.nari.jjsd.business.mapper.ExtraworkMapper;
import com.nari.jjsd.business.service.IExtraworkService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2019-03-17
 */
@Service
public class ExtraworkServiceImpl extends ServiceImpl<ExtraworkMapper, Extrawork> implements IExtraworkService {

    @Override
    public int insertExtrawork(Extrawork extrawork) {
        int count=baseMapper.insert(extrawork);
        return count;
    }
}
