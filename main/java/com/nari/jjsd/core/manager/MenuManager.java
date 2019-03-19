package com.nari.jjsd.core.manager;



import com.nari.jjsd.permission.model.Menu;
import com.nari.jjsd.util.commom.LoggerUtils;
import com.nari.jjsd.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description:    菜单Manager
 * @Author:         ssrs
 * @CreateDate:     2018/8/9 10:22
 * @UpdateUser:     ssrs
 * @UpdateDate:     2018/8/9 10:22
 * @Version:        1.0
 */
public class MenuManager {

    /**
     * 构建前端路由所需数据
     * @param menuList 所有子菜单
     * @return
     */
    public static List<MenuVo> buildMenuUrl(List<Menu> menuList) {
        LoggerUtils.debug(MenuManager.class,"进行菜单tree构建");
        List<MenuVo> menuVoList = new ArrayList<>();
        for (Menu menu: menuList) {
            MenuVo menuVo = new MenuVo();
            menuVo.setPath(menu.getUrl());
            menuVo.setComponent(menu.getUrl());
            menuVo.setName(menu.getTitle());
            menuVoList.add(menuVo);
        }
        return menuVoList;
    }
}
