package com.nari.jjsd.business.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yb
 * @since 2018-12-17
 */
@Data
@TableName("p_project")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PJ_ID", type = IdType.UUID)
    private String pjId;
    private String pjNo;
    private String pjName;
    private String pjStatus;
    private String curPsId;
    private String functionary;
    private String summary;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date startTime;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endTime;
    private String remarks;
    private String createdbyId;
    private String createdbyName;
    private String createdAt;
    private String updatedbyId;
    private String updatedbyName;
    private String updatedAt;
    private String deletedFlag;
    private String deletedbyId;
    private String deletedbyName;
    private String deletedAt;
   // @TableField(exist = false)
    //private String Ids;
    @TableField(exist = false)
    private String status;
    @TableField(exist = false)
      private String cur;


    @Override
    public String toString() {
        return "Project{" +
                "pjId='" + pjId + '\'' +
                ", pjNo='" + pjNo + '\'' +
                ", pjName='" + pjName + '\'' +
                ", pjStatus='" + pjStatus + '\'' +
                ", curPsId='" + curPsId + '\'' +
                ", functionary='" + functionary + '\'' +
                ", summary='" + summary + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", remarks='" + remarks + '\'' +
                ", createdbyId='" + createdbyId + '\'' +
                ", createdbyName='" + createdbyName + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedbyId='" + updatedbyId + '\'' +
                ", updatedbyName='" + updatedbyName + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", deletedFlag='" + deletedFlag + '\'' +
                ", deletedbyId='" + deletedbyId + '\'' +
                ", deletedbyName='" + deletedbyName + '\'' +
                ", deletedAt='" + deletedAt + '\'' +
                ", status='" + status + '\'' +
                ", cur='" + cur + '\'' +
                '}';
    }
}
