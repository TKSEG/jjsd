package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.baomidou.mybatisplus.service.IService;
import com.nari.jjsd.business.mapper.TSBaseUserMapper;
import com.nari.jjsd.business.mapper.TSRoleUserMapper;
import com.nari.jjsd.business.mapper.TSUserMapper;
import com.nari.jjsd.business.mapper.UserlMapperCustom;
import com.nari.jjsd.business.model.TSBaseUser;
import com.nari.jjsd.business.model.TSRoleUser;
import com.nari.jjsd.business.model.TSUser;

import com.nari.jjsd.business.model.task.vo.SystemUserCustom;
import com.nari.jjsd.business.model.task.vo.SystemUserQueryVo;
import com.nari.jjsd.business.service.SystemUserCustomService;
import com.nari.jjsd.core.manager.EUDataGridResult;
import com.nari.jjsd.core.shiro.token.manger.TokenManager;
import com.nari.jjsd.permission.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


/**
 * Created by yangbo on 2019/3/8.
 */
@Service
public class SystemUserCustomServiceImpl implements SystemUserCustomService {

    @Autowired
    private UserlMapperCustom userlMapperCustom;

    @Autowired
    private TSUserMapper tsUserMapper;

    @Autowired
    private TSBaseUserMapper tsBaseUserMapper;

    @Autowired
    private TSRoleUserMapper tsRoleUserMapper;


    @Override
    public Page<SystemUserCustom> getList(int pageNo, int pageSize, SystemUserQueryVo userQueryVo) throws Exception {
        Page<SystemUserCustom> page = new Page<SystemUserCustom>(pageNo, pageSize);

        return page.setRecords(userlMapperCustom.getList(page, userQueryVo));
    }

    @Override
    public String createSystemuser(SystemUserCustom systemUserCustom) {
        systemUserCustom = systemUserCustom != null ? systemUserCustom : new SystemUserCustom();
        //登录人信息
        User token = TokenManager.getToken();
        TSBaseUser tsBaseUser = new TSBaseUser();
        tsBaseUser.setPassword(systemUserCustom.getPassword());
        tsBaseUser.setRealname(systemUserCustom.getRealname());
        tsBaseUser.setTeamid(systemUserCustom.getTeamid());
        tsBaseUser.setUsername(systemUserCustom.getUsername());
        tsBaseUser.setDepartid("297e2f105621152d0156212bfc550031");
        //  tsBaseUser.setUserkey(systemUserCustom.get);
        tsBaseUserMapper.insert(tsBaseUser);

        String tsBaseUserId = tsBaseUser.getId();


        TSUser tuser = new TSUser();
        tuser.setId(tsBaseUserId);
        tuser.setCreateDate(new Date());
        tuser.setCreateName("yangbo");
        //  tuser.getId(tsBaseUserId);
        tuser.setEmail(systemUserCustom.getEmail());
        tuser.setMobilePhone(systemUserCustom.getMobilePhone());
        tuser.setRemarks(systemUserCustom.getRemarks());

        //    tuser.setCreateName(token.getNickname());
        //  tuser.setCreateName(token.getId().toString());
        // tuser.setCreatedbyName(token.getNickname());
        //tuser.setCreatedbyId(token.getId().toString());

        int t = tsUserMapper.insert(tuser);

        return tuser.getId();
    }


    @Override
    public SystemUserCustom getListiid(String id) throws Exception {
        return userlMapperCustom.getUserid(id);
    }

    /**
     * 还要更新
     * @param systemUserCustom
     * @return
     */
    @Override
    public String updateSystemuser(SystemUserCustom systemUserCustom) {
        systemUserCustom = systemUserCustom != null ? systemUserCustom : new SystemUserCustom();
        TSBaseUser tsBaseUser = new TSBaseUser();
        tsBaseUser.setId(systemUserCustom.getId());
        // tsBaseUser.setPassword(systemUserCustom.getPassword());
        tsBaseUser.setRealname(systemUserCustom.getRealname());
        tsBaseUser.setTeamid(systemUserCustom.getTeamid());
        tsBaseUser.setUsername(systemUserCustom.getUsername());
        tsBaseUser.setDepartid("297e2f105621152d0156212bfc550031");
        tsBaseUserMapper.updateById(tsBaseUser);


        TSUser tuser = new TSUser();
        tuser.setId(systemUserCustom.getId());

        tuser.setEmail(systemUserCustom.getEmail());
        tuser.setMobilePhone(systemUserCustom.getMobilePhone());
        tuser.setRemarks(systemUserCustom.getRemarks());
        tsUserMapper.updateById(tuser);
        return tuser.getId();
    }


}
