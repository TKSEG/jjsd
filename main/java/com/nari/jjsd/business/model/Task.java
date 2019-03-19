package com.nari.jjsd.business.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
@Data
@TableName("p_b_task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TASK_ID", type = IdType.UUID)
    private String taskId;
    private String taskName;
    private String bpncId;
    private String levelCode;
    private String remarks;
    private String wfId;
    private String createdbyId;
    private String createdbyName;
    private Date createdAt;
    private String updatedbyId;
    private String updatedbyName;
    private String updatedAt;
    private String deletedFlag;
    private String deletedbyId;
    private String deletedbyName;
    private String deletedAt;
    /**
     * 是否为派发和自提生成的任务
     */
    private String sendFlag;



    @TableField(exist = false)
    private String approveu_id;

    private String wfStatus;
}
