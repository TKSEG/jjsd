package com.nari.jjsd.business.model;

import java.util.Date;
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
 * @author yb
 * @since 2019-03-07
 */
@Data
@TableName("t_s_user")
public class TSUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    private String email;
    @TableField("mobilePhone")
    private String mobilePhone;
    @TableField("officePhone")
    private String officePhone;
    @TableField("signatureFile")
    private String signatureFile;
    /**
     * 修改人
     */
    private String updateName;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人id
     */
    private String updateBy;
    /**
     * 创建人
     */
    private String createName;
    /**
     * 创建时间
     */
    private Date createDate;
    private String remarks;
    /**
     * 创建人id
     */
    private String createBy;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getSignatureFile() {
        return signatureFile;
    }

    public void setSignatureFile(String signatureFile) {
        this.signatureFile = signatureFile;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "TSUser{" +
        ", id=" + id +
        ", email=" + email +
        ", mobilePhone=" + mobilePhone +
        ", officePhone=" + officePhone +
        ", signatureFile=" + signatureFile +
        ", updateName=" + updateName +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        ", createName=" + createName +
        ", createDate=" + createDate +
        ", remarks=" + remarks +
        ", createBy=" + createBy +
        "}";
    }
}
