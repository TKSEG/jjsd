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
 * @since 2019-01-12
 */

@Data
@TableName("t_s_type")
public class TSType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.UUID)
    private String id;
    private String typecode;
    private String typename;
    private String typepid;
    private String typegroupid;

}
