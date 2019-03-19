package com.nari.jjsd.business.model;

import java.math.BigDecimal;
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
 * @author yb
 * @since 2019-03-07
 */
@Data
@TableName("p_s_workpost")
public class Work implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "WP_ID", type = IdType.UUID)
    private String wpId;
    private String wpCode;
    private String wpName;
    private String leve1Id;
    private BigDecimal leve1Score;
    private String leve2Id;
    private BigDecimal leve2Score;
    private String leve3Id;
    private BigDecimal leve3Score;
    private String leve4Id;
    private BigDecimal leve4Score;
    private String leve5Id;
    private BigDecimal leve5Score;
    private String leve6Id;
    private BigDecimal leve6Score;
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


    @Override
    public String toString() {
        return "PSWorkpost{" +
        ", wpId=" + wpId +
        ", wpCode=" + wpCode +
        ", wpName=" + wpName +
        ", leve1Id=" + leve1Id +
        ", leve1Score=" + leve1Score +
        ", leve2Id=" + leve2Id +
        ", leve2Score=" + leve2Score +
        ", leve3Id=" + leve3Id +
        ", leve3Score=" + leve3Score +
        ", leve4Id=" + leve4Id +
        ", leve4Score=" + leve4Score +
        ", leve5Id=" + leve5Id +
        ", leve5Score=" + leve5Score +
        ", leve6Id=" + leve6Id +
        ", leve6Score=" + leve6Score +
        ", remarks=" + remarks +
        ", createdbyId=" + createdbyId +
        ", createdbyName=" + createdbyName +
        ", createdAt=" + createdAt +
        ", updatedbyId=" + updatedbyId +
        ", updatedbyName=" + updatedbyName +
        ", updatedAt=" + updatedAt +
        ", deletedFlag=" + deletedFlag +
        ", deletedbyId=" + deletedbyId +
        ", deletedbyName=" + deletedbyName +
        ", deletedAt=" + deletedAt +
        "}";
    }
}
