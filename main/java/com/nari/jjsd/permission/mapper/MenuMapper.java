package com.nari.jjsd.permission.mapper;

import com.nari.jjsd.permission.model.Menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */
public interface MenuMapper extends BaseMapper<Menu> {
    //查询所有菜单
    List<Menu> getRootMenu();

    int insert2(Menu menu);

    Menu selectById2(Long id);

    int updateById2(Menu menu);

//    List<Menu> getChildernMenu(@Param("parentId") Integer parentId);
}
