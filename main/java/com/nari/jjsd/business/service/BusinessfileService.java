package com.nari.jjsd.business.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Businessfile;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-01-17
 */
public interface BusinessfileService extends IService<Businessfile> {
    //分页
    Page<Businessfile> selectBusinessfilecPage(int pageNo, int pageSize, Businessfile businessfile);

    int insertBusinessfile(Businessfile businessfile);

    int updaateById(Businessfile businessfile);
}
