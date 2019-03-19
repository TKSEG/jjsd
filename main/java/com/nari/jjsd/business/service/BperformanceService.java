package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.BerformancePojo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-23
 */
public interface BperformanceService extends IService<BerformancePojo> {
    /**
     * 查询绩效任务类型
     * @param btypeId
     * @param ordernum
     * @return
     */
    public List findType(String btypeId,String ordernum) ;
}
