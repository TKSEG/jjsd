package com.nari.jjsd.business.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yb
 * @since 2019-03-17
 */
@Data
@TableName("p_extrawork")
public class Extrawork implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "EW_ID", type = IdType.UUID)
    private String ewId;
    private String auserId;
    private String applyType;
    private String ewType;
    private String ewContent;
    private String intohour;
    private String acontent;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private String startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private String endTime;
    private String hours;
    private String wfId;
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
    private String tempFlag;



}
