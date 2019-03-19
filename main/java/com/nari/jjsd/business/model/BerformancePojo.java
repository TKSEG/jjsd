package com.nari.jjsd.business.model;

import java.math.BigDecimal;

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
 * @author ssrs
 * @since 2019-02-23
 */
@Data
@TableName("p_bperformance")
public class BerformancePojo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BPNC_ID", type = IdType.AUTO)
    private String bpncId;
    private String bpncName;
    private String bpncCode;
    private String btypeId;
    private String bpncPid;
    private BigDecimal score;
    private Integer ordernum;
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

}
