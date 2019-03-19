package com.nari.jjsd.util.commom;

/**
 * Created by yangbo on 2019/2/25.
 */
public class ConstUtil {
    public static final String SQL_JOIN_MARK ="&&";

    public static final String TABLE_ALIAS_MARK= "##";

    public static final String DELETE_FLAG_Y = "Y";

    public static final String DELETE_FLAG_N = "N";

    public static final String SEND_FLAG_Y="Y";

    public static final String N_FLAG = "N";

    public static final String Y_FLAG="Y";
    //工程资料的类型
    public static final String P_TYPE_CODE="P";

    // 任务来源
    public static final String  SRC_SEND_FLAG="SEND";
    public static final String  SRC_SELF_FLAG="SELF";

    public static final String LEVEL_A="A";

    public static final String LEVEL_B="B";

    public static final String LEVEL_C="C";

    //绩效任务类型
    public static final String PERFORMANCE = "performance";
    //纪律考核项
    public static final String DISCIPLINE = "discipline";
    //贡献嘉奖项
    public static final String DEVOTE = "devote";
    // 岗位
    public static final String WORKPOST="workpost";

    ////////////////////////////////////////work flow start/////////////////////////////

    // 流程状态：待审批
    public static final String APPLY_STATUS = "APPLY";
    // 流程状态：已审批
    public static final String APPROVE_STATUS = "APPROVE";
    // 流程状态：申请(中心主任)
    public static final String APPLY_STATUS_HL = "APPLYHL";
    // 流程状态：已审批(中心主任)
    public static final String APPROVE_STATUS_HL = "APPROVEHL";
    // 流程状态：流程结束
    public static final String FINISH_STATUS = "FINISH";


    // 审批结果：审批同意
    public static final String APPROVE_RESULT_Y = "Y";
    // 审批结果：审批不同意
    public static final String APPROVE_RESULT_N = "N";

    // 需要中心主任审批
    public static final String HL_FLAG_Y = "Y";
    // 不需要中心主任审批
    public static final String HL_FLAG_N = "N";

    //流程类型
    public static final String TYPE_CODE_STORE = "绩效任务储备";
    public static final String TYPE_CODE_STORE_CODE = "STORE";

    public static final String TYPE_CODE_SELF = "绩效任务自提";
    public static final String TYPE_CODE_SELF_CODE = "SELF";

    public static final String TYPE_CODE_EXTRA = "加班管理";
    public static final String TYPE_CODE_EXTRA_CODE = "EXTRA";

    ////////////////////////////////////////work flow end/////////////////////////////
}
