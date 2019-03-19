package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Businessfile;
import com.nari.jjsd.business.mapper.BusinessfileMapper;
import com.nari.jjsd.business.service.BusinessfileService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-01-17
 */
@Service
public class BusinessfileServiceImpl extends ServiceImpl<BusinessfileMapper, Businessfile> implements BusinessfileService {
        @Autowired
        private BusinessfileMapper businessfileMapper;

    @Override
    public Page<Businessfile> selectBusinessfilecPage(int pageNo, int pageSize, Businessfile businessfile) {
        Page<Businessfile> page = new Page<Businessfile>(pageNo, pageSize);
        return page.setRecords(businessfileMapper.selectBusinessfilecPage(page,businessfile));
    }

    @Override
    public int insertBusinessfile(Businessfile businessfile) {
        Integer count = baseMapper.insert(businessfile);
        return count;
    }

    @Override
    public int updaateById(Businessfile businessfile) {
        Integer count = baseMapper.updateById(businessfile);
        return count;
    }
}
