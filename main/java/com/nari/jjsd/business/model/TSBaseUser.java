package com.nari.jjsd.business.model;

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
@TableName("t_s_base_user")
public class TSBaseUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.UUID)
    private String id;
    @TableField("activitiSync")
    private Integer activitiSync;
    private String browser;
    private String password;
    private String realname;
    private String signature;
    private Integer status;
    private String userkey;
    private String username;
    private String teamid;
    private String departid;

}
