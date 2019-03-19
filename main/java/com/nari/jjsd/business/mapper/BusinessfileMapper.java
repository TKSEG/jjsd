package com.nari.jjsd.business.mapper;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.nari.jjsd.business.model.Businessfile;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ssrs
 * @since 2019-01-17
 */
public interface BusinessfileMapper extends BaseMapper<Businessfile> {
    List<Businessfile> selectBusinessfilecPage(Pagination page, Businessfile businessfile);

}
