package com.nari.jjsd.business.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.Businessfile;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.service.BusinessfileService;
import com.nari.jjsd.business.service.TypeService;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.APPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ssrs
 * @since 2019-01-17
 */
@Controller
@RequestMapping("/businessfile")
public class BusinessfileController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private BusinessfileService businessfileService;

    /**
     * 跳转到工程资料
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("business/businessfile/index");
        List<TSType> type= typeService.findType("8a10e4b557f5554f0157f583a5e00001");

        List<TSType> schedule= typeService.findType("4028b8815707ab510157086967910010");
        modelAndView.addObject("type",type);
        modelAndView.addObject("schedule",schedule);
        return modelAndView;
    }

    @RequestMapping(value = "getProjectPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getProjectPage(Integer page, Integer limit ,Businessfile businessfile) {
        Page<Businessfile> rolePage =businessfileService.selectBusinessfilecPage(page,limit,businessfile);
               // selectProjecPage(page,limit,project);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;

    }


    @RequestMapping(value = "onlineDetails", method = RequestMethod.GET)
    @ResponseBody
    public Object onlineDetails(Integer page, Integer limit ,String id) {
        ModelAndView modelAndView = new ModelAndView("business/businessfile/details");
        List<TSType> type= typeService.findType("8a10e4b557f5554f0157f583a5e00001");
        Businessfile role=businessfileService.selectById(id);
        modelAndView.addObject("role", role);
        modelAndView.addObject("type", type);

        return modelAndView;

    }



    /**
     * 查询
     */

    @RequestMapping(value = "querybusinessfile",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> querybusinessfile(
            @RequestParam(value="name") String bfname,
            @RequestParam(value="type")String bftype,
            @RequestParam(value="datetime") String uploadtime,
            Integer page, Integer limit){
        EntityWrapper<Businessfile> entityWrapper = new EntityWrapper<>();
        if(bfname!=null&&bfname!=""){
            entityWrapper.like("BF_NAME", bfname);
        }
        if(bftype!=null&&bftype!=""){
            entityWrapper.eq("BF_TYPE",bftype);
        }
        Page<Businessfile> rolePage =businessfileService.selectPage(new Page<>(page, limit), entityWrapper);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }

    /**
     * 跳转到添加工程资料
     *
     * @return
     */
    @RequestMapping(value = "goAdd", method = RequestMethod.GET)
    public ModelAndView goAdd() {
        ModelAndView modelAndView = new ModelAndView("business/businessfile/add");
        List<Businessfile> businessfiles = businessfileService.selectList(null);
        modelAndView.addObject("businessfiles",businessfiles);

        List<TSType> type= typeService.findType("8a10e4b557f5554f0157f583a5e00001");
        modelAndView.addObject("type",type);
        return modelAndView;
    }

    /**
     * 角色添加方法
     *
     * @param businessfiles

     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Businessfile businessfiles) {
        int count = businessfileService.insertBusinessfile(businessfiles);
        return count > 0 ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
    }

    /**
     * 角色删除
     * @param id
     * @return
     */
    @RequestMapping(value = "del",method = RequestMethod.POST)
    @ResponseBody
    public Object del(String id){
        boolean b = businessfileService.deleteById(id);
        return b? APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE):APPUtil.resultMapType(APPUtil.DELEATE_ERROR_TYPE);
    }

    /**
     * 跳转到角色编辑页面
     *
     * @param id 角色id
     * @return
     */
    @RequestMapping(value = "goUpdate", method = RequestMethod.GET)
    public ModelAndView goUpdate(String id) {
        ModelAndView modelAndView = new ModelAndView("business/businessfile/update");
        //查询角色信息
        Businessfile role=businessfileService.selectById(id);
        modelAndView.addObject("role", role);
        List<TSType> type= typeService.findType("8a10e4b557f5554f0157f583a5e00001");
        modelAndView.addObject("type",type);
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(Businessfile businessfiles) {
        int count = businessfileService.updaateById(businessfiles);
        return count > 0 ? APPUtil.resultMapType(APPUtil.UPDATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.UPDATE_ERROR_TYPE);
    }

}

