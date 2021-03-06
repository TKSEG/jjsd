package com.nari.jjsd.permission.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yb
 * @since 2018-11-26
 */
@Data
@TableName("user")
public class User implements Serializable {
    //0:禁止登录
    public static final Long _0 = new Long(0);
    //1:有效
    public static final Long _1 = new Long(1);
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 邮箱|登录帐号
     */
    private String email;
    /**
     * 密码
     */
    private String pswd;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    /**
     * 最后登录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")

    private Date lastLoginTime;
    /**
     * 1:有效，0:禁止登录
     */
    private Long status;

    public User(){};
    public User(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.pswd = user.getPswd();
        this.createTime = user.getCreateTime();
        this.lastLoginTime = user.getLastLoginTime();
    }


}
