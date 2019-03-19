package com.nari.jjsd.business.controller.sysem.user;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.*;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;
import com.nari.jjsd.business.model.task.vo.SystemUserQueryVo;
import com.nari.jjsd.business.service.*;
import com.nari.jjsd.core.manager.EUDataGridResult;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.APPUtil;
import com.nari.jjsd.util.commom.StringUtil;
import com.nari.jjsd.util.commom.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangbo on 2019/3/8.
 */
@Controller
@RequestMapping("/systemuser")
public class SystemUserController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BusinessfileService businessfileService;
    @Autowired
    private SystemUserCustomService systemUserCustomService;
    @Autowired
    private SystemUserService systemUserService;
    @Autowired
    private SystemRoleUserService systemRoleUserService;

    @Autowired
    private SystemRoleService systemRoleService;
    @Autowired
    private SystemBaseUserService systemBaseUserService;


    /**
     * 跳转到用户管理
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("system/user/index");
        List<TSType> type = typeService.findType("8a10e4b557f5554f0157f583a5e00001");
        List<TSType> schedule = typeService.findType("4028b8815707ab510157086967910010");
        modelAndView.addObject("type", type);
        modelAndView.addObject("schedule", schedule);
        return modelAndView;
    }

    /**
     * 查询用户管理List
     *
     * @param page
     * @param limit
     * @param systemUserQueryVo
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getSystemUserPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getSystemUserPage(Integer page, Integer limit, SystemUserQueryVo systemUserQueryVo, String userName, String realName) throws Exception {

        TSBaseUser baseUser = new TSBaseUser();
        baseUser.setRealname(realName);
        baseUser.setUsername(userName);
        systemUserQueryVo.setBaseuser(baseUser);

        Page<SystemUserCustom> rolePage = systemUserCustomService.getList(page, limit, systemUserQueryVo);
        for (int i = 0; i < rolePage.getRecords().size(); i++) {
            List<TSRole> roleUser = systemRoleService.selectrolename(rolePage.getRecords().get(i).getId());
            if (roleUser.size() > 0) {
                String roleName = "";
                for (TSRole ru : roleUser) {
                    roleName += ru.getRolename() + ",";
                }
                roleName = roleName.substring(0, roleName.length() - 1);
                rolePage.getRecords().get(i).setRolename(roleName);
            }
        }

        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;

    }



    /**
     * 用户添加更新列表
     *
     * @return
     */

    @RequestMapping(value = "appoorupdate", method = RequestMethod.GET)
    public ModelAndView appoorupdate(Integer page, Integer limit, SystemUserQueryVo systemUserQueryVo, String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("system/user/addupdate");
        //查询角色信息如果前台传值为空
        if (id != null) {
             modelAndView = new ModelAndView("system/user/update");
            SystemUserCustom system = systemUserCustomService.getListiid(id);
            List<TSRoleUser> rids = systemRoleUserService.queryroleuserid(id);
            String s = StringUtils.join(rids, ",");
            modelAndView.addObject("system", system);
            modelAndView.addObject("selectvalue", s);
        }else{
             modelAndView = new ModelAndView("system/user/add");
        }
        return modelAndView;
    }


    /**
     * 用户添加方法
     *
     * @param systemUserCustom
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(SystemUserCustom systemUserCustom, String rids) {
        //添加
        if (systemUserCustom.getId() == "") {
            int i = systemUserService.selectCount(new EntityWrapper<TSUser>().eq("email", systemUserCustom.getEmail()));
            //检查该邮箱是否已经注册
            if (i > 0) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("status", 101);
                map.put("message", "该邮箱已经注册！");
                return map;
            }
            String id = systemUserCustomService.createSystemuser(systemUserCustom);
            int count = systemRoleUserService.insertUserAndRole(id, rids);
        } else {
            String id = systemUserCustomService.updateSystemuser(systemUserCustom);
            int count = systemRoleUserService.updateUserAndRole(id, rids);

        }

        return APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE);
    }

    /**
     * 用户添加方法
     *
     * @param systemUserCustom
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(SystemUserCustom systemUserCustom, String rids) {
        //添加
        if (systemUserCustom.getId() == "") {
            int i = systemUserService.selectCount(new EntityWrapper<TSUser>().eq("email", systemUserCustom.getEmail()));
            //检查该邮箱是否已经注册
            if (i > 0) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("status", 101);
                map.put("message", "该邮箱已经注册！");
                return map;
            }
            String id = systemUserCustomService.createSystemuser(systemUserCustom);
            int count = systemRoleUserService.insertUserAndRole(id, rids);
        } else {
            String id = systemUserCustomService.updateSystemuser(systemUserCustom);
            int count = systemRoleUserService.updateUserAndRole(id, rids);

        }

        return APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE);
    }


    /**
     * 用户添加方法
     *
     * @param systemUserCustom
     * @return
     */
    /*
    @RequestMapping(value = "addupdate", method = RequestMethod.POST)
    @ResponseBody
    public Object add(SystemUserCustom systemUserCustom, String rids) {
        //添加
        if (systemUserCustom.getId() == "") {
            int i = systemUserService.selectCount(new EntityWrapper<TSUser>().eq("email", systemUserCustom.getEmail()));
            //检查该邮箱是否已经注册
            if (i > 0) {
                Map<String, Object> map = new HashMap<>(16);
                map.put("status", 101);
                map.put("message", "该邮箱已经注册！");
                return map;
            }
            String id = systemUserCustomService.createSystemuser(systemUserCustom);
            int count = systemRoleUserService.insertUserAndRole(id, rids);
        } else {
            String id = systemUserCustomService.updateSystemuser(systemUserCustom);
            int count = systemRoleUserService.updateUserAndRole(id, rids);

        }

        return APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE);
    }
*/
    /**
     * 角色删除
     * @param id
     * @return
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(String id){
        boolean b=  systemRoleUserService.delete(new EntityWrapper<TSRoleUser>().eq("userid",id));
        boolean s=   systemUserService.deleteById(id);
        boolean c = systemRoleUserService.deleteById(id);
        return b? APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE):APPUtil.resultMapType(APPUtil.DELEATE_ERROR_TYPE);
    }



    /**
     * 查询用户管理List
     *
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "selectUser", method = RequestMethod.POST)
    @ResponseBody
    public Object selectUser(Integer page, Integer limit,SystemUserQueryVo systemUserQueryVo) throws Exception {

        Page<SystemUserCustom> rolePage = systemUserCustomService.getList(page, limit, systemUserQueryVo);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }

}
