package com.nari.jjsd.business.controller;


import com.nari.jjsd.business.model.TSRole;
import com.nari.jjsd.business.service.SystemRoleService;
import com.nari.jjsd.core.manager.RoleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ssrs
 * @since 2019-02-26
 */
@Controller
@RequestMapping("/systemrole")
public class SystemRoleController {
    @Autowired
    private SystemRoleService systemRoleService;

    @RequestMapping(value = "getAllRole",method = RequestMethod.GET)
    @ResponseBody
    public Object getAllRole(){
        List<TSRole> roles = systemRoleService.selectList(null);
        List<Map<String, Object>> mapList = RoleManager.buildTSRoleTree(roles);
        return mapList;
    }

}

