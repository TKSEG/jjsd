package com.nari.jjsd.business.model;

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
@TableName("p_taskuser")
public class Taskuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BPNCU_ID", type = IdType.AUTO)
    private String bpncuId;
    private String tsId;
    private String tId;
    private String typeCode;
    private String bpncId;
    private String exameTime;
    private String groupId;
    private String puserId;
    private String lscore;
    private String frStatus;
    private String bpncTypeId;
    private String weight;
    private String taskFlag;
    private String remarks;
    private String tempFlag;
    private Integer plus;
    private String createdbyName;
    private String createdAt;
    private String updatedbyId;
    private String updatedbyName;
    private String updatedAt;
    private String deletedFlag;
    private String deletedbyId;
    private String deletedbyName;
    private String deletedAt;
    private String createdbyId;



}
