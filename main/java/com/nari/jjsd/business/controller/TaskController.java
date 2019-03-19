package com.nari.jjsd.business.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.model.Task;
import com.nari.jjsd.business.model.Tasksend;
import com.nari.jjsd.business.service.TypeService;
import com.nari.jjsd.business.service.TaskService;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.ConstUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private TaskService taskService;

    /**
     * 跳转到工程资料
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("business/task/index");
        List<TSType> type = typeService.findType("4028b8815707ab5101570863aea50006");
        List<TSType> schedule = typeService.findType("4028b8815707ab510157086967910010");
        modelAndView.addObject("type", type);
        modelAndView.addObject("schedule", schedule);
        return modelAndView;
    }


    /**

     */
    @RequestMapping(value = "datagridstore", method = RequestMethod.POST)
    @ResponseBody
    public Object datagridstore(Integer page, Integer limit, Task task) {
        Page<Task> rolePage = taskService.selectTaskPage(page, limit);
        Map<String, Object> map = PageManager.buildPage(rolePage);
        return map;
    }
}

