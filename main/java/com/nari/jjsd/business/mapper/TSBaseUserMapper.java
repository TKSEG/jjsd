package com.nari.jjsd.business.mapper;

import com.nari.jjsd.business.model.TSBaseUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
public interface TSBaseUserMapper extends BaseMapper<TSBaseUser> {
   public List<TSBaseUser> queryIduserName();
}
