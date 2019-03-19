package com.nari.jjsd.permission.service;

import com.nari.jjsd.permission.model.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */

public interface MenuService extends IService<Menu> {
    List<Menu> getRootMenu();

    int insert2(Menu menu);

    Menu selectById2(Long id);

    int updateById2(Menu menu);

    int deleteById2(Integer id,Long permissionId);
}
