package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.Uteam;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2019-03-15
 */
public interface UteamService extends IService<Uteam> {
    int insertUteam(Uteam team);
}
