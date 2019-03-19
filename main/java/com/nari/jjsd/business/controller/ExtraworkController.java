package com.nari.jjsd.business.controller;


import com.nari.jjsd.business.model.Extrawork;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.service.IExtraworkService;
import com.nari.jjsd.business.service.TypeService;
import com.nari.jjsd.business.service.impl.ExtraworkServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Team;
import com.nari.jjsd.business.model.Uteam;
import com.nari.jjsd.business.service.UteamService;
import com.nari.jjsd.business.service.TeamService;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.APPUtil;
import com.nari.jjsd.util.commom.ConstUtil;
import com.nari.jjsd.util.commom.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author yb
 * @since 2019-03-17
 */
@Controller
@RequestMapping("/extrawork")
public class ExtraworkController {

    @Autowired
    private IExtraworkService extraworkService;
    @Autowired
    private TypeService typeService;
    /**
     * 跳转到岗位管理
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("extrawork/application/index");
        return modelAndView;
    }

    /**
     * 查询岗位管理List
     *
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "getExtraworkPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getTeamPage(Integer page, Integer limit, Extrawork extrawork) throws Exception {
        EntityWrapper<Extrawork> entityWrapper = new EntityWrapper<>();
        if (extrawork.getApplyType() != null && extrawork.getApplyType() != "") {
            entityWrapper.like("APPLY_TYPE", extrawork.getApplyType());
        }
           Page<Extrawork> rolePage = extraworkService.selectPage(new Page<>(page, limit), entityWrapper);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }

    /**
     * 用岗位管理跳转
     *
     * @return
     */
    @RequestMapping(value = "getad", method = RequestMethod.GET)
    public ModelAndView getad(Integer page, Integer limit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("extrawork/application/add");
        List<TSType> type= typeService.findType("8a10e4875822e6aa015822f6431e0001");

        modelAndView.addObject("type",type);

        //查询角色信息如果前台传值为空
        return modelAndView;
    }

    /**
     * 用户添加更新方法
     *
     * @param extrawork
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Extrawork extrawork) {
        int count = extraworkService.insertExtrawork(extrawork);
        return count > 0 ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
    }


    /**
     * 用岗位管理跳转
     *
     * @return
     */
    @RequestMapping(value = "getupdate", method = RequestMethod.GET)
    public ModelAndView getupdate(Integer page, Integer limit) throws Exception {
        ModelAndView modelAndView = new ModelAndView("extrawork/application/update");
        //查询角色信息如果前台传值为空
        return modelAndView;
    }

}

