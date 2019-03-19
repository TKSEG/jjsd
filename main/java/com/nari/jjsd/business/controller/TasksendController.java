package com.nari.jjsd.business.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.BerformancePojo;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.model.Task;
import com.nari.jjsd.business.model.Tasksend;
import com.nari.jjsd.business.service.*;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.util.commom.APPUtil;
import com.nari.jjsd.util.commom.ConstUtil;
import com.nari.jjsd.util.commom.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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
@RequestMapping("/tasksend")
public class TasksendController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private TaskService taskService;

    @Autowired
    private TasksendService tasksendService;
    @Autowired
    private BperformanceService bperformanceService;

    @Autowired
    private SystemBaseUserService baseUserService;


    @Autowired
    private WorkflowService workflowService;

    /**
     * 跳转到任务储备列表
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView store() {
        ModelAndView modelAndView = new ModelAndView("business/tasksend/index");
        List<BerformancePojo> type = bperformanceService.findType("performance", null);

        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        //  List<TSType> schedule= typeService.findType("4028b8815707ab510157086967910010");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }


    /**
     * AJAX请求查询数据
     *
     * @param page
     * @param limit
     * @param
     * @return
     */
    @RequestMapping(value = "getProjectPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getProjectPage(Integer page, Integer limit, Tasksend tasksend, String approveType) {
        tasksend = tasksend != null ? tasksend : new Tasksend();

        Page<Tasksend> rolePage = tasksendService.querytasksendList(page, limit, tasksend);
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
        ModelAndView modelAndView = new ModelAndView("business/tasksend/add");
        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }

    /**
     * 角色添加方法
     *
     * @param tasksend
     * @return
     */
    //添加实例
    //   @RequestMapping(value="", method= RequestMethod.POST)
    //   @ResponseBody
//    private CustomResult insert(@Valid Bjrkd bjrkd, BindingResult bindingResult) throws Exception {
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Tasksend tasksend) throws Exception {
        // @RequestMapping(value = "", method = RequestMethod.POST)
        //  @ResponseBody
        //  public Object add(@Valid Tasksend tasksend) throws Exception {

        tasksend = tasksend != null ? tasksend : new Tasksend();
        //创建任务
        String taskName = tasksend.getTaskName();
        String bpncId = tasksend.getBpncId();
        String levelCode = tasksend.getLevelCode();
        Task task = new Task();
        task.setTaskName(taskName);
        task.setBpncId(bpncId);
        task.setLevelCode(levelCode);
        String self = "Y";
        String taskid = taskService.createTaskItem(task, self);
        tasksend.setTaskId(taskid);
        String tsid = tasksendService.createTaskSendItem(tasksend, self);
        if (StringUtil.isEmpty(tsid)) {
            return APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
        } else {
            return APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE);
        }
    }

    /**
     * 查询任务储备归档
     *
     * @return
     */
    @RequestMapping(value = "taskSelect", method = RequestMethod.GET)
    public ModelAndView taskSelect() {
        ModelAndView modelAndView = new ModelAndView("business/taskstore/storeSelect");
        return modelAndView;
    }

    /**
     * @param tasksend
     * @return
     */

    @RequestMapping(value = "addorupdate", method = RequestMethod.POST)
    @ResponseBody
    public Object addorupdate(Tasksend tasksend) {
        boolean insert = tasksendService.insert(tasksend);
        return insert ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
    }

    /**
     * 根据名称查询页面
     *
     * @param page
     * @param limit
     * @param tsId
     * @return
     */
    @RequestMapping(value = "onlineDetails", method = RequestMethod.GET)
    @ResponseBody
    public Object onlineDetails(Integer page, Integer limit, String tsId) {
        ModelAndView modelAndView = new ModelAndView("business/tasksend/details");
        Tasksend tasksend = tasksendService.querytasksend(tsId);
        modelAndView.addObject("tasksend", tasksend);
        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }


    /**
     * 任务自提删除
     *
     * @param id
     * @return
     */
    // @RequestMapping(value = "del", method = RequestMethod.POST)
    // @RequestMapping(value ="{id}", method = RequestMethod.DELETE )
    @RequestMapping(value = "del", method = RequestMethod.POST)
    @ResponseBody
    public Object del(@PathVariable("id") String id) {
        boolean b = tasksendService.deleteById(id);
        return b ? APPUtil.resultMapType(APPUtil.DELEATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.DELEATE_ERROR_TYPE);
    }

    /**
     * 跳转到角色编辑页面
     *
     * @param id 角色id
     * @return
     */
    @RequestMapping(value = "goUpdate", method = RequestMethod.GET)
    public ModelAndView goUpdate(String id) {
        ModelAndView modelAndView = new ModelAndView("business/tasksend/update");
        //查询角色信息
        //   Task task = taskService.selectById(id);
        Tasksend tasksend = tasksendService.querytasksend(id);

        modelAndView.addObject("tasksend", tasksend);

        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }

    @RequestMapping(value ="update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(Tasksend tasksend) {
        tasksend = tasksend != null ? tasksend : new Tasksend();
        Task task = new Task();
        task.setTaskId(tasksend.getTaskId());
        task.setTaskName(tasksend.getTaskName());
        task.setBpncId(tasksend.getBpncId());
        task.setLevelCode(task.getLevelCode());
        taskService.updateById(task);
        int count = 0;
        count = tasksendService.updaateById(tasksend);
        return count > 0 ? APPUtil.resultMapType(APPUtil.UPDATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.UPDATE_ERROR_TYPE);
    }


}

