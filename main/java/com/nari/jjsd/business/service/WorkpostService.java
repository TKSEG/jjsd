package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.Work;
import com.baomidou.mybatisplus.service.IService;
import com.nari.jjsd.business.model.Work;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2019-03-07
 */
public interface WorkpostService extends IService<Work> {
    int insertWork(Work work);

    int updaateWork(Work work);
}
