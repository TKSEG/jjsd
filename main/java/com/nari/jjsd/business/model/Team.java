package com.nari.jjsd.business.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author yb
 * @since 2019-03-07
 */
@Data
@TableName("p_s_team")
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "T_ID", type = IdType.UUID)
    private String tId;
    private String tName;
    private String tLead;
    private String tLeadId;
    private String remarks;
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
    private String teams;
    @TableField(exist = false)
    private String teamsid;
}
