package com.nari.jjsd.business.service.impl;

import com.nari.jjsd.business.model.Work;
import com.nari.jjsd.business.mapper.WorkpostMapper;
import com.nari.jjsd.business.service.WorkpostService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yb
 * @since 2019-03-07
 */
@Service
public class WorkpostServiceImpl extends ServiceImpl<WorkpostMapper, Work> implements WorkpostService {

    @Override
    public int insertWork(Work work) {
        int count=baseMapper.insert(work);
        return count;
    }

    @Override
    public int updaateWork(Work work) {
        int count=baseMapper.updateById(work);
        return count;
    }
}
