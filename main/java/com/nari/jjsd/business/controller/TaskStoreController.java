package com.nari.jjsd.business.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nari.jjsd.business.model.*;
import com.nari.jjsd.business.model.Task;
import com.nari.jjsd.business.service.*;
import com.nari.jjsd.core.manager.PageManager;
import com.nari.jjsd.permission.model.User;
import com.nari.jjsd.util.commom.APPUtil;
import com.nari.jjsd.util.commom.CommonUtil;
import com.nari.jjsd.util.commom.ConstUtil;
import com.nari.jjsd.util.commom.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 * 任务储备
 *
 * @author yb
 * @since 2019-02-21
 */
@Controller
@RequestMapping("/taskstore")
public class TaskStoreController {
    @Autowired
    private TypeService typeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private BperformanceService bperformanceService;

    @Autowired
    private SystemBaseUserService baseUserService;

    @Autowired
    private TasksendService tasksendService;
    @Autowired
    private WorkflowService workflowService;

    /**
     * 跳转到任务储备列表
     *
     * @return
     */
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView store() {
        ModelAndView modelAndView = new ModelAndView("business/taskstore/index1");
        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }

    /**
     * AJAX请求查询数据
     *
     * @param page
     * @param limit
     * @param task
     * @return
     */
    @RequestMapping(value = "getProjectPage", method = RequestMethod.POST)
    @ResponseBody
    public Object getProjectPage(Integer page, Integer limit, Task task, String approveType) {
        task = task != null ? task : new Task();
        EntityWrapper<Task> entityWrapper = new EntityWrapper<>();
        if (task.getTaskName() != null && task.getTaskName() != "") {
            entityWrapper.like("TASK_NAME", task.getTaskName());
        }
        if (task.getBpncId() != null && task.getBpncId() != "") {
            entityWrapper.eq("BPNC_ID", task.getBpncId());
        }
        if (task.getLevelCode() != null && task.getLevelCode() != "") {
            entityWrapper.eq("LEVEL_CODE", task.getLevelCode());
        }
        if (task.getCreatedbyName() != null && task.getCreatedbyName() != "") {
            entityWrapper.eq("CREATEDBY_NAME", task.getCreatedbyName());
        }

        if (StringUtil.isNotEmpty(approveType)) {
            if (approveType.equals("0")) {
                List<Task> t = taskService.inquireWfstatus(ConstUtil.APPLY_STATUS);
                ArrayList arrat = new ArrayList();
                for (int i = 0; i < t.size(); i++) {
                    arrat.add(t.get(i).getTaskId());
                }
                entityWrapper.in("TASK_ID", arrat);
                entityWrapper.eq("WF_STATUS", "APPLY");
            } else if (approveType.equals("1")) {
                List<Task> t = taskService.inquireWfstatus(ConstUtil.APPROVE_STATUS);
                ArrayList arrat = new ArrayList();
                for (int i = 0; i < t.size(); i++) {
                    arrat.add(t.get(i).getTaskId());
                }
                entityWrapper.in("TASK_ID", arrat);
                entityWrapper.eq("WF_STATUS", "APPROVE");

            }
        }
        entityWrapper.eq("SEND_FLAG", ConstUtil.N_FLAG);
        Page<Task> rolePage = taskService.selectPage(new Page<>(page, limit), entityWrapper);
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
        ModelAndView modelAndView = new ModelAndView("business/taskstore/add");
        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }

    /**
     * 角色添加方法
     *
     * @param task
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Object add(Task task) {
        boolean insert = taskService.insert(task);
        return insert ? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
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
        boolean b = taskService.deleteById(id);
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
        ModelAndView modelAndView = new ModelAndView("business/taskstore/update");
        //查询角色信息
        Task task = taskService.selectById(id);
        modelAndView.addObject("task", task);
        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");


        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Object update(Task task) {
        int count = 0;
        task = task != null ? task : new Task();
        if (!StringUtil.isEmpty(task.getApproveu_id())) {
            count = saveFlow(task.getTaskId(), task.getApproveu_id(), ConstUtil.TYPE_CODE_STORE_CODE);
        } else {
            count = taskService.updaateById(task);

        }

        return count > 0 ? APPUtil.resultMapType(APPUtil.UPDATE_SUCCESS_TYPE) : APPUtil.resultMapType(APPUtil.UPDATE_ERROR_TYPE);
    }


    /**
     * @return
     */
    @RequestMapping(value = "approveDetail", method = RequestMethod.GET)
    public ModelAndView approveDetail(Workflow workflow, HttpServletRequest request) {
        workflow = workflow != null ? workflow : new Workflow();

        String wf_id = workflow.getWfId();
        if (wf_id.equals("null")) {
            //   if(StringUtil.isEmpty(wf_id)){
            // 创建流程
            return list(workflow);

        } else {
            // 审批
            return approve(workflow);

        }
    }


    //  @RequestMapping(params = "approve")
    public ModelAndView approve(Workflow wf) {
        ModelAndView modelAndView = new ModelAndView("business/flow/flowApprove");
        if (ConstUtil.TYPE_CODE_EXTRA_CODE.equals(wf.getTypeCode())) {
            modelAndView.addObject("flowItem", wf);

            // 是否有中心主任,在组长审批画面显示中心主任显示项
            //   if(StringUtil.isNotEmpty(request.getParameter("higher"))){
            //      request.setAttribute("higher", "higher");
            //       request.setAttribute("actionName", "approveFlow");
            //   }else{
            //       request.setAttribute("actionName", "approveHigherFlow");
            //   }
        } else {
            modelAndView.addObject("flowItem", wf);

            //   request.setAttribute("actionName", "approveFlow");
        }
        // return "flow/flowApprove";
        return modelAndView;

    }

    /**
     * maneger 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "apply")
    public ModelAndView list(Workflow workflow) {
        ModelAndView modelAndView = new ModelAndView("business/taskstore/update");

        if (ConstUtil.TYPE_CODE_STORE_CODE.equals(workflow.getTypeCode())) {
            modelAndView = new ModelAndView("business/taskstore/update");
            List<BerformancePojo> type = bperformanceService.findType("performance", null);
            List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
            List<TSBaseUser> baseuser = baseUserService.queryIduserName();
            modelAndView.addObject("baseuser", baseuser);
            modelAndView.addObject("type", type);
            modelAndView.addObject("level", level);
            modelAndView.addObject("flowItem", workflow);
            modelAndView.addObject("task", taskService.selectById(workflow.getObjId()));
            modelAndView.addObject("display", "none");
            modelAndView.addObject("readonly", "disabled='disabled'");
        } else if (ConstUtil.TYPE_CODE_SELF_CODE.equals(workflow.getTypeCode())) {
            modelAndView = new ModelAndView("business/tasksend/update");
            List<BerformancePojo> type = bperformanceService.findType("performance", null);
            List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
            List<TSBaseUser> baseuser = baseUserService.queryIduserName();
            modelAndView.addObject("baseuser", baseuser);
            modelAndView.addObject("type", type);
            modelAndView.addObject("level", level);
            modelAndView.addObject("flowItem", workflow);
            //   querytasksendtaskid
            // modelAndView.addObject("task",taskService.selectById(workflow.getObjId()));
            modelAndView.addObject("tasksend", tasksendService.querytasksendtaskid(workflow.getObjId()));
            modelAndView.addObject("display", "none");
            modelAndView.addObject("readonly", "disabled='disabled'");
        }


        /**
         WorkFlowPojo wf = new WorkFlowPojo();
         wf.setObj_id(request.getParameter("obj_id"));
         wf.setType_code(request.getParameter("type_code"));
         request.setAttribute("flowItem", wf);
         String url = null;
         if(ConstUtil.TYPE_CODE_STORE_CODE.equals(wf.getType_code())){
         // 任务储备
         //			url = "task.do?addorupdatestore&task_id="+wf.getObj_id();
         request.setAttribute("taskItem", commonService.getEntityByID("task_id",wf.getObj_id(),BaseTaskPojo.class));
         request.setAttribute("display","none");
         request.setAttribute("readonly","disabled='disabled'");
         return "task/storeinfo";
         }else if(ConstUtil.TYPE_CODE_SELF_CODE.equals(wf.getType_code())){
         // 任务自提
         TaskSendPojo sendItem = commonService.getEntityByID("ts_id",wf.getObj_id(),TaskSendPojo.class);
         request.setAttribute("sendItem", sendItem);
         BaseTaskPojo taskItem = commonService.getEntityByID("task_id",sendItem.getTask_id(),BaseTaskPojo.class);
         TSBaseUser user = commonService.getEntity(TSBaseUser.class, sendItem.getDutyu_id());
         if(user != null){
         sendItem.setDutyu_name(user.getUserName());
         }
         request.setAttribute("taskItem", taskItem);
         request.setAttribute("display","none");
         request.setAttribute("readonly","disabled");
         request.setAttribute("sendreadonly","disabled");
         request.setAttribute("type","self");

         return "task/selfinfo";
         }else if(ConstUtil.TYPE_CODE_EXTRA_CODE.equals(wf.getType_code())){
         // 加班
         ExtraWorkPojo extraItem = commonService.getEntityByID("ew_id",wf.getObj_id(),ExtraWorkPojo.class);
         request.setAttribute("extraItem", extraItem);
         request.setAttribute("display","none");
         request.setAttribute("readonly","disabled");
         return "extra/extrainfo";
         }else{
         request.setAttribute("url", url);
         return "flow/flowApply";
         }
         **/
        return modelAndView;
    }


    @SuppressWarnings("unchecked")
    public Integer saveFlow(String obj_id, String approveu_id, String type_code) {
        int count = 0;
        User user = new User();
        try {
            String wf_id = workflowService.createWorkFlowItem(obj_id, type_code, approveu_id, user);
            // Workflow workflow=new Workflow();
            // workflow.setObjId(obj_id);
            // workflow.setWfStatus(ConstUtil.APPLY_STATUS);
            //  workflow.setWfName(CommonUtil.getFlowTypeName(type_code));
            // String time = CommonUtil.getCurrentDate();
            //  workflow.setApplyTime(time);
            // workflow.setApplyuId("8a8ab0b246dc81120146dc8181950052");
            //  workflow.setApproveuId(approveu_id);
            //  workflow.setTypeCode(type_code);
            //  workflow.setCreatedbyId("8a8ab0b246dc81120146dc8181950052");
            //  workflow.setCreatedbyName("admin");
            //  workflowService.insertWorkflow(workflow);
            //  String wf_id=workflowService.queryObjId(obj_id);
            if (StringUtil.isNotEmpty(wf_id)) {
                if (ConstUtil.TYPE_CODE_STORE_CODE.equals(type_code)) {
                    // 任务储备
                    Task task = new Task();
                    task.setWfStatus(ConstUtil.APPLY_STATUS);
                    task.setWfId(wf_id);
                    task.setTaskId(obj_id);
                    count = taskService.updaateById(task);
                } else if (ConstUtil.TYPE_CODE_SELF_CODE.equals(type_code)) {
                    //任务自提
                    //      valMap.put("wf_id", wf_id);
                    //     whereMap.put("ts_id", new String[]{obj_id});
                    //     type = TaskSendPojo.class;
                } else if (ConstUtil.TYPE_CODE_EXTRA_CODE.equals(type_code)) {
                    //加班管理
                    //   valMap.put("wf_id", wf_id);
                    //   whereMap.put("ew_id", new String[]{obj_id});
                    //   type = ExtraWorkPojo.class;
                }
            }

        } catch (Exception e) {
            //    addLog(e.getMessage(), Globals.Log_Type_INSERT,Globals.Log_Leavel_INFO);
            //    j.setMsg(e.getMessage());
            //    j.setSuccess(false);
            //    logger.error(e.getMessage());
            // return j;

        }
        return count;
    }


    /**
     * 角色添加方法
     *
     * @param workflow
     * @return
     */
    @RequestMapping(value = "approveFlow", method = RequestMethod.POST)
    @ResponseBody
    public Object approveFlow(Workflow workflow) throws Exception {
        boolean isSucess = workflowService.approveWorkFlowItem(workflow.getWfId(), workflow.getApproveResult(), workflow.getApproveDes());
        if (isSucess) {
            if (ConstUtil.Y_FLAG.equals(workflow.getApproveResult())) {
                if (ConstUtil.TYPE_CODE_STORE_CODE.equals(workflow.getTypeCode())) {
                    // 任务储备
                    Task task = new Task();
                    task.setWfStatus(ConstUtil.APPROVE_STATUS);
                    task.setTaskId(workflow.getObjId());
                    taskService.updaateById(task);

                }

            }

        } else {
            String type_code = workflow.getTypeCode();
            if (ConstUtil.TYPE_CODE_STORE_CODE.equals(type_code)) {
                taskService.deleteById(workflow.getObjId());
            }
        }

        //    return insert? APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE):APPUtil.resultMapType(APPUtil.INSERT_ERROR_TYPE);
        return APPUtil.resultMapType(APPUtil.INSERT_SUCCESS_TYPE);
    }


    @RequestMapping(value = "onlineDetails", method = RequestMethod.GET)
    @ResponseBody
    public Object onlineDetails(Integer page, Integer limit, String id) {
        ModelAndView modelAndView = new ModelAndView("business/taskstore/details");
        Task task = taskService.selectById(id);
        modelAndView.addObject("task", task);
        List<BerformancePojo> type = bperformanceService.findType("performance", null);
        List<TSType> level = typeService.findType("8a10e48757ac83680157ac85dcdc0001");
        modelAndView.addObject("type", type);
        modelAndView.addObject("level", level);
        return modelAndView;

    }


}
