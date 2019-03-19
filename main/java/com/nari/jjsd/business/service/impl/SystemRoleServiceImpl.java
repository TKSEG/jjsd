package com.nari.jjsd.business.service.impl;

import com.nari.jjsd.business.model.TSRole;
import com.nari.jjsd.business.mapper.TSRoleMapper;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;
import com.nari.jjsd.business.service.SystemRoleService;
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
public class SystemRoleServiceImpl extends ServiceImpl<TSRoleMapper, TSRole> implements SystemRoleService {
    @Override
    public List<TSRole> selectrolename(String roleuserid) throws Exception {
        return baseMapper.selectrolename(roleuserid);
    }
}
