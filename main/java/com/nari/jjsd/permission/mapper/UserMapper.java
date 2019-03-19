package com.nari.jjsd.permission.mapper;

import com.nari.jjsd.permission.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */
public interface UserMapper extends BaseMapper<User> {
    void initQuellaData();
}
