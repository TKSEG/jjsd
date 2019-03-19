package com.nari.jjsd.business.service;

import com.nari.jjsd.business.model.Businessfile;
import com.nari.jjsd.business.model.Workflow;
import com.baomidou.mybatisplus.service.IService;
import com.nari.jjsd.permission.model.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-25
 */
public interface WorkflowService extends IService<Workflow> {
    int insertWorkflow(Workflow workflow);
    public String queryObjId(String objId);
    int updaateById(Workflow workflow);

    /***
     * 审批流程
     * @param user 审批用户信息
     * @param approveResult 审批结果
     * @param approveDes 审批描述
     * @param wf_id 流程ID
     * @return
     * @throws Exception
     */
    public boolean approveWorkFlowItem(String wf_id,String approveResult,String approveDes) throws Exception;


    /**
     * 创建流程
     * @param obj_id 上报绩效任务ID，加班申请ID等
     * @param typeCode 流程种类，为了区分是加班申请，任务储备，任务派发等流程的类型
     * @param user 登陆用户信息
     * @return 返回对应的流程ID
     * @throws Exception
     */
    public String createWorkFlowItem(String obj_id ,String typeCode,String approveu_id,User user) throws Exception;
}
