package com.nari.jjsd.business.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.nari.jjsd.business.model.task.vo.SystemUserCustom;
import com.nari.jjsd.business.model.task.vo.SystemUserQueryVo;

import java.util.List;

/**
 * Created by yangbo on 2019/3/8.
 */
public interface UserlMapperCustom {
    public List<SystemUserCustom> getList(Pagination page, SystemUserQueryVo userQueryVo) throws Exception;

    public SystemUserCustom getUserid(String id) throws Exception;



}
