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
 * @author ssrs
 * @since 2019-02-26
 */
@Data
@TableName("t_s_role")
public class TSRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private String id;
    private String rolecode;
    private String rolename;
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
    /**
     * 创建人id
     */
    private String createBy;


    @TableField(exist = false)
    private String userid;


    @Override
    public String toString() {
        return "TSRole{" +
        ", id=" + id +
        ", rolecode=" + rolecode +
        ", rolename=" + rolename +
        ", updateName=" + updateName +
        ", updateDate=" + updateDate +
        ", updateBy=" + updateBy +
        ", createName=" + createName +
        ", createDate=" + createDate +
        ", createBy=" + createBy +
        "}";
    }
}
