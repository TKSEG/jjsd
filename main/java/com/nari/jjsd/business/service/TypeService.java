package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.TSType;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 *  系统级别service
 * </p>
 *
 * @author ssrs
 * @since 2019-01-12
 */
public interface TypeService extends IService<TSType> {
    /**
     * 根据typecode获取数据字典的信息
     */
    public List findType(String typecode) ;
           // throws Exception;
}
