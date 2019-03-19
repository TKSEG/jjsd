package com.nari.jjsd.business.model.task.vo;

import com.nari.jjsd.business.model.TSUser;
import lombok.Data;

/**
 *
 * <p>Title: UserQueryVo</p>
 * <p>Description:扩类，用于页面向action传递参数，将数据传到mybatis </p>
 * <p>Company: www.itcast.com</p>
 */
@Data
public class SystemUserCustom extends TSUser {


    private String create_name;
    private String create_date;
    private String create_by;

    private String username;
    private String realname;
    private String password;
    private String teamid;
    private String rid;
    private String rolenames;
    private String tname;
    private  String tid;


    private String roleid;
    private String rolename;
    private String roleuserid;
}
