package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nari.jjsd.business.mapper.TSTypeMapper;
import com.nari.jjsd.business.model.BerformancePojo;
import com.nari.jjsd.business.mapper.PBperformanceMapper;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.service.BperformanceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.util.commom.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-23
 */
@Service
public class BperformanceServiceImpl extends ServiceImpl<PBperformanceMapper, BerformancePojo> implements BperformanceService {
    @Autowired
    private PBperformanceMapper performanceMapper;

    /**
     * 查询绩效任务类型
     * @param btypeId
     * @param ordernum
     * @return
     */
    @Override
    public List findType(String btypeId,String ordernum) {
        EntityWrapper<BerformancePojo> entityWrapper = new EntityWrapper<>();
        if(StringUtil.isNotEmpty(ordernum)){
            entityWrapper.eq("ORDERNUM",ordernum);
        }
        entityWrapper.eq("BTYPE_ID",btypeId);
        // try{
        return performanceMapper.selectList(entityWrapper);
    }
}
