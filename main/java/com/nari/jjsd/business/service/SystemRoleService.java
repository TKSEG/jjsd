package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.TSRole;
import com.baomidou.mybatisplus.service.IService;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
public interface SystemRoleService extends IService<TSRole> {
    /**
     * 查询用户权限名称
     * @return
     * @throws Exception
     */
    List<TSRole> selectrolename(String roleuserid) throws Exception;
}
