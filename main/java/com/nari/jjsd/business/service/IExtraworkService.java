package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.Extrawork;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2019-03-17
 */
public interface IExtraworkService extends IService<Extrawork> {
  public int   insertExtrawork(Extrawork extrawork);
}
