package com.nari.jjsd.permission.model;

import com.baomidou.mybatisplus.annotations

        .TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author yb
 * @since 2018-11-27
 */
@Data
@TableName("permission")
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * url地址
     */
    private String url;
    /**
     * url描述
     */
    private String name;
    private Long parentId;

    @TableField(exist = false)
    private List<Permission> children = new ArrayList<>();
}
