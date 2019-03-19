package com.nari.jjsd.business.mapper;

import com.nari.jjsd.business.model.Workflow;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-02-25
 */
public interface WorkflowMapper extends BaseMapper<Workflow> {
   public String queryObjId(@Param(value="objId")String objId);

}
