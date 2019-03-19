package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nari.jjsd.business.model.TSRoleUser;
import com.nari.jjsd.business.mapper.TSRoleUserMapper;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;
import com.nari.jjsd.business.service.SystemRoleUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
@Service
public class SystemRoleUserServiceImpl extends ServiceImpl<TSRoleUserMapper, TSRoleUser> implements SystemRoleUserService {
    /**
     * 添加权限
     *
     * @param id
     * @param rids
     * @return
     */
    @Override
    public int insertUserAndRole(String id, String rids) {
        String[] ids = rids.split(",");
        for (int i = 0; i < ids.length; i++) {
            TSRoleUser ur = new TSRoleUser();
            ur.setRoleid(ids[i]);
            ur.setUserid(id);
            baseMapper.insert(ur);
        }

        return 0;
    }

    /**
     * 更新权限先删除所以权限再添加
     *
     * @param id
     * @param rids
     * @return
     */
    @Override
    public int updateUserAndRole(String id, String rids) {
        baseMapper.delete(new EntityWrapper<TSRoleUser>().eq("userid", id));
        String[] ids = rids.split(",");
        for (int i = 0; i < ids.length; i++) {
            TSRoleUser ur = new TSRoleUser();
            ur.setRoleid(ids[i]);
            ur.setUserid(id);
            baseMapper.insert(ur);
        }

        return 0;
    }

    /**
     * 根据权限id查询
     *
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public List<TSRoleUser> queryroleuserid(String id) throws Exception {
        return baseMapper.queryroleuserid(id);
    }
}
