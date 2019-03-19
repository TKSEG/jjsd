package com.nari.jjsd.core.manager;



import com.nari.jjsd.business.model.TSRole;
import com.nari.jjsd.permission.model.Role;
import com.nari.jjsd.util.commom.LoggerUtils;

import java.util.*;

public class RoleManager {


    public static List<Map<String, Object>> buildTSRoleTree(List<TSRole> roles) {
        LoggerUtils.debug(RoleManager.class,"进行角色tree构建");
        List<Map<String,Object>> maps = new LinkedList<>();
        for (TSRole role:roles) {
            if (role!=null){
                Map<String,Object> map = new HashMap<>(16);
                map.put("id",role.getId());
                map.put("name",role.getRolename());
                maps.add(map);
            }
        }
        return maps;
    }

    public static List<Map<String, Object>> buildRoleTree(List<Role> roles) {
        LoggerUtils.debug(RoleManager.class,"进行角色tree构建");
        List<Map<String,Object>> maps = new LinkedList<>();
        for (Role role:roles) {
            if (role!=null){
                Map<String,Object> map = new HashMap<>(16);
                map.put("id",role.getId());
                map.put("name",role.getName());
                maps.add(map);
            }
        }
        return maps;
    }
}
