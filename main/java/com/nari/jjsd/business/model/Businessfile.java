package com.nari.jjsd.business.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author ssrs
 * @since 2019-01-17
 */
@Data
@TableName("p_b_businessfile")
public class Businessfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BF_ID", type = IdType.UUID)
    private String bfId;
    private String bfName;
    private String bfType;
    private String authorId;
    private String authorName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date uploadTime;
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
    private String type;

}
