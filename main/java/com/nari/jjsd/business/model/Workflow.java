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
 * @since 2019-02-25
 */
@Data
@TableName("p_project")
public class Workflow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "WF_ID", type = IdType.UUID)
    private String wfId;
    private String wfName;
    private String typeCode;
    private String objId;
    private String wfStatus;
    private String applyuId;
    private String applyTime;
    private String approveuId;
    private String approveTime;
    private String approveResult;
    private String approveDes;
    private String hlapprove;
    private String hlapplyuId;
    private String hlapplyuTime;
    private String papproveuId;
    private String papproveTime;
    private String papproveResult;
    private String papproveDes;
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


    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(String wfStatus) {
        this.wfStatus = wfStatus;
    }

    public String getApplyuId() {
        return applyuId;
    }

    public void setApplyuId(String applyuId) {
        this.applyuId = applyuId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getApproveuId() {
        return approveuId;
    }

    public void setApproveuId(String approveuId) {
        this.approveuId = approveuId;
    }

    public String getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(String approveTime) {
        this.approveTime = approveTime;
    }

    public String getApproveResult() {
        return approveResult;
    }

    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    public String getApproveDes() {
        return approveDes;
    }

    public void setApproveDes(String approveDes) {
        this.approveDes = approveDes;
    }

    public String getHlapprove() {
        return hlapprove;
    }

    public void setHlapprove(String hlapprove) {
        this.hlapprove = hlapprove;
    }

    public String getHlapplyuId() {
        return hlapplyuId;
    }

    public void setHlapplyuId(String hlapplyuId) {
        this.hlapplyuId = hlapplyuId;
    }

    public String getHlapplyuTime() {
        return hlapplyuTime;
    }

    public void setHlapplyuTime(String hlapplyuTime) {
        this.hlapplyuTime = hlapplyuTime;
    }

    public String getPapproveuId() {
        return papproveuId;
    }

    public void setPapproveuId(String papproveuId) {
        this.papproveuId = papproveuId;
    }

    public String getPapproveTime() {
        return papproveTime;
    }

    public void setPapproveTime(String papproveTime) {
        this.papproveTime = papproveTime;
    }

    public String getPapproveResult() {
        return papproveResult;
    }

    public void setPapproveResult(String papproveResult) {
        this.papproveResult = papproveResult;
    }

    public String getPapproveDes() {
        return papproveDes;
    }

    public void setPapproveDes(String papproveDes) {
        this.papproveDes = papproveDes;
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

    @Override
    public String toString() {
        return "Workflow{" +
        ", wfId=" + wfId +
        ", wfName=" + wfName +
        ", typeCode=" + typeCode +
        ", objId=" + objId +
        ", wfStatus=" + wfStatus +
        ", applyuId=" + applyuId +
        ", applyTime=" + applyTime +
        ", approveuId=" + approveuId +
        ", approveTime=" + approveTime +
        ", approveResult=" + approveResult +
        ", approveDes=" + approveDes +
        ", hlapprove=" + hlapprove +
        ", hlapplyuId=" + hlapplyuId +
        ", hlapplyuTime=" + hlapplyuTime +
        ", papproveuId=" + papproveuId +
        ", papproveTime=" + papproveTime +
        ", papproveResult=" + papproveResult +
        ", papproveDes=" + papproveDes +
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
