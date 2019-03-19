package com.nari.jjsd.business.service.impl;


import com.nari.jjsd.business.model.Workflow;
import com.nari.jjsd.business.mapper.WorkflowMapper;
import com.nari.jjsd.business.service.WorkflowService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.nari.jjsd.permission.model.User;
import com.nari.jjsd.util.commom.CommonUtil;
import com.nari.jjsd.util.commom.ConstUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-02-25
 */
@Service
public class WorkflowServiceImpl extends ServiceImpl<WorkflowMapper, Workflow> implements WorkflowService {

    @Override
    public int insertWorkflow(Workflow workflow) {
        Integer count = baseMapper.insert(workflow);
        return count;
    }

    @Override
    public String queryObjId(String objId) {
        return baseMapper.queryObjId(objId);
    }

    @Override
    public int updaateById(Workflow workflow) {
        Integer count = baseMapper.updateById(workflow);
        return count;
    }

    @Override
    public boolean approveWorkFlowItem(String wf_id, String approveResult, String approveDes) {
        Workflow wfp = baseMapper.selectById(wf_id);
        wfp.setWfStatus(ConstUtil.APPROVE_STATUS);

        // wfp.setWfStatus(ConstUtil.APPROVE_STATUS);
        //    String time = CommonUtil.getCurrentDate();
        //   wfp.setApproveu_id(user.getId());
        //  wfp.setApprove_time(time);
        wfp.setApproveResult(approveResult);
        wfp.setApproveDes(approveDes);

        Integer count = baseMapper.updateById(wfp);


        // int row = commonService.updPojo(wfp, "wf_id");
        if (count > 0) {
            return true;
        } else {
            // throw new GlobalRuntimeException("审批流程异常！");
        }

        return false;
    }

    /**
     * 创建流程
     *
     * @param obj_id   上报绩效任务ID，加班申请ID等
     * @param typeCode 流程种类，为了区分是加班申请，任务储备，任务派发等流程的类型
     * @param user     登陆用户信息
     * @return 返回对应的流程ID
     * @throws Exception
     */
    @Override
    public String createWorkFlowItem(String obj_id, String typeCode, String approveu_id, User user) throws Exception {
        Workflow workflow = new Workflow();
        workflow.setObjId(obj_id);
        workflow.setWfStatus(ConstUtil.APPLY_STATUS);
        workflow.setWfName(CommonUtil.getFlowTypeName(typeCode));
        String time = CommonUtil.getCurrentDate();
        workflow.setApplyTime(time);
        workflow.setApplyuId("8a8ab0b246dc81120146dc8181950052");
        workflow.setApproveuId(approveu_id);
        workflow.setTypeCode(typeCode);
        workflow.setCreatedbyId("8a8ab0b246dc81120146dc8181950052");
        workflow.setCreatedbyName("admin");
        Integer row = insertWorkflow(workflow);
        String wfid = baseMapper.queryObjId(obj_id);
        if (row > 0) {
            return wfid;
        } else {
            throw new Exception();
            // throw new GlobalRuntimeException("创建流程异常");
        }
    }

}
