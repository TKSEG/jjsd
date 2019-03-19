package com.nari.jjsd.business.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;
import com.nari.jjsd.business.model.task.vo.SystemUserQueryVo;
import com.nari.jjsd.core.manager.EUDataGridResult;

import java.util.List;

/**
 * Created by yangbo on 2019/3/8.
 */
public interface SystemUserCustomService {
    //分页
    Page<SystemUserCustom> getList(int pageNo, int pageSize, SystemUserQueryVo userQueryVo) throws Exception;

    /**
     * 创建用户列表
     */

    public String createSystemuser(SystemUserCustom systemUserCustom);



    /**
     * 根据id查询用户数据
     * @param id
     * @return
     * @throws Exception
     */
    public SystemUserCustom getListiid (String id) throws Exception;

    /**
     * 更新用户
     * @param systemUserCustom
     * @return
     */
    public String updateSystemuser(SystemUserCustom systemUserCustom);


}
