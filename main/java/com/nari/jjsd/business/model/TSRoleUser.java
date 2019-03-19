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
 * @author ssrs
 * @since 2019-02-26
 */
@Data
@TableName("t_s_role_user")
public class TSRoleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "ID", type = IdType.UUID)
    private String id;
    private String roleid;
    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "TSRoleUser{" +
                ", id=" + id +
                ", roleid=" + roleid +
                ", userid=" + userid +
                "}";
    }
}
