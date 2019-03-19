package com.nari.jjsd.business.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ssrs
 * @since 2019-02-21
 */
@Data
@TableName("p_tasksend")
public class Tasksend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "TS_ID", type = IdType.UUID)
    private String tsId;
    private String taskId;
    private String planTime;
    private String standard;
    private String dutyuId;
    private String fstatus;
    private String tsstatus;
    private String wfId;
    private String bfscore;
    private String srcFlag;
    private String createdbyId;
    private String createdbyName;
    private String createdAt;
    private String updatedbyId;
    private String updatedbyName;
    private String updatedAt;
    private String deletedFlag;
    private String deletedbyId;
    private String deletedbyName;
    private String deletedAt;

    @TableField(exist = false)
    private String taskName;
    @TableField(exist = false)
    private String bpncId;
    @TableField(exist = false)
    private String levelCode;
}
