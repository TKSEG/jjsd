package com.nari.jjsd.permission.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
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
@TableName("system_log")
public class SystemLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String clientIp;
    private String uri;
    private String type;
    private String method;
    private String paramDara;
    private String sessionId;
    private Date time;
    private Date returnTime;
    private String returnData;
    private String httpStatusCode;
    private Integer timeConsuming;

}
