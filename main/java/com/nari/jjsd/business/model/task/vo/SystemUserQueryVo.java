package com.nari.jjsd.business.model.task.vo;

import com.nari.jjsd.business.model.TSBaseUser;
import com.nari.jjsd.business.model.TSRoleUser;
import com.nari.jjsd.business.model.TSUser;
import lombok.Data;

/**
 *
 * <p>Title: UserQueryVo</p>
 * <p>Description:包装类，用于页面向action传递参数，将数据传到mybatis </p>
 * <p>Company: www.itcast.com</p>
 */
//@Data
public class SystemUserQueryVo {
    private TSUser tsUser;
    private TSBaseUser baseuser;
    private TSRoleUser tsRoleUser;
    private SystemUserCustom systemUserCustom;

    public TSUser getTsUser() {
        return tsUser;
    }

    public void setTsUser(TSUser tsUser) {
        this.tsUser = tsUser;
    }

    public TSBaseUser getBaseuser() {
        return baseuser;
    }

    public void setBaseuser(TSBaseUser baseuser) {
        this.baseuser = baseuser;
    }

    public TSRoleUser getTsRoleUser() {
        return tsRoleUser;
    }

    public void setTsRoleUser(TSRoleUser tsRoleUser) {
        this.tsRoleUser = tsRoleUser;
    }

    public SystemUserCustom getSystemUserCustom() {
        return systemUserCustom;
    }

    public void setSystemUserCustom(SystemUserCustom systemUserCustom) {
        this.systemUserCustom = systemUserCustom;
    }
}
