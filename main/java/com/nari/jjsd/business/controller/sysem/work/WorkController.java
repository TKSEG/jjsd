package com.nari.jjsd.business.controller.sysem.work;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.*;
import com.nari.jjsd.business.service.WorkpostService;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.APPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by yangbo on 2019/3/13.
 */
@Controller
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkpostService workpostService;

    /**
     * 跳转到岗位管理
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("system/work/index");
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
    @RequestMapping(value = "getWorkPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getWorkPage(Integer page, Integer limit, Work work) throws Exception {
        EntityWrapper<Work> entityWrapper = new EntityWrapper<>();
        if (work.getWpName() != null && work.getWpName() != "") {
            entityWrapper.like("WP_NAME", work.getWpName());
        }
        Page<Work> rolePage = workpostService.selectPage(new Page<>(page, limit), entityWrapper);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }

    /**
     * 用岗位管理跳转
     *
     * @return
     */
    @RequestMapping(value = "getadd", method = RequestMethod.GET)
    public ModelAndView getadd(Integer page, Integer limit, String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("system/work/add");
        //查询角色信息如果前台传值为空

        return modelAndView;
    }

    /**
     * 用户添加更新方法
     *
     * @param work
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Work work) {
        int count = workpostService.insertWork(work);
        return count > 0 ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
    }


    /**
     * 用岗位管理跳转
     *
     * @return
     */
    @RequestMapping(value = "getupdate", method = RequestMethod.GET)
    public ModelAndView getupdate(Integer page, Integer limit, String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView("system/work/update");
        //查询角色信息如果前台传值为空
        Work work = workpostService.selectById(id);
        modelAndView.addObject("work", work);
        return modelAndView;
    }

    /**
     * 用户添加更新方法
     *
     * @param work
     * @return
     */
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(Work work) {
        int count = workpostService.updaateWork(work);
        return count > 0 ? APPUtil.resultMapType(APPUtil.UPDATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.UPDATE_ERROR_TYPE);
    }

    /**
     * 角色删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public Object del(String id) {
        boolean b = workpostService.deleteById(id);
        return b ? APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.DELEATE_ERROR_TYPE);
    }

}
