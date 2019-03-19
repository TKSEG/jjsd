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
 * @author yb
 * @since 2019-03-15
 */
@Data
@TableName("p_s_uteam")
public class Uteam implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "UT_ID", type = IdType.UUID)
    private String utId;
    private String tId;
    private String uId;
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
    private String leadFlag;


    public String getUtId() {
        return utId;
    }

    public void setUtId(String utId) {
        this.utId = utId;
    }

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCreatedbyId() {
        return createdbyId;
    }

    public void setCreatedbyId(String createdbyId) {
        this.createdbyId = createdbyId;
    }

    public String getCreatedbyName() {
        return createdbyName;
    }

    public void setCreatedbyName(String createdbyName) {
        this.createdbyName = createdbyName;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedbyId() {
        return updatedbyId;
    }

    public void setUpdatedbyId(String updatedbyId) {
        this.updatedbyId = updatedbyId;
    }

    public String getUpdatedbyName() {
        return updatedbyName;
    }

    public void setUpdatedbyName(String updatedbyName) {
        this.updatedbyName = updatedbyName;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(String deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public String getDeletedbyId() {
        return deletedbyId;
    }

    public void setDeletedbyId(String deletedbyId) {
        this.deletedbyId = deletedbyId;
    }

    public String getDeletedbyName() {
        return deletedbyName;
    }

    public void setDeletedbyName(String deletedbyName) {
        this.deletedbyName = deletedbyName;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getLeadFlag() {
        return leadFlag;
    }

    public void setLeadFlag(String leadFlag) {
        this.leadFlag = leadFlag;
    }

    @Override
    public String toString() {
        return "PSUteam{" +
        ", utId=" + utId +
        ", tId=" + tId +
        ", uId=" + uId +
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
        ", leadFlag=" + leadFlag +
        "}";
    }
}
