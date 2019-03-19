package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.TSRoleUser;
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
public interface SystemRoleUserService extends IService<TSRoleUser> {
   int  insertUserAndRole(String  id, String rids);
   int  updateUserAndRole(String  id, String rids);

   List<TSRoleUser> queryroleuserid(String id) throws Exception;
}
