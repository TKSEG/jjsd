package com.nari.jjsd.business.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.nari.jjsd.business.model.Project;
import com.nari.jjsd.business.model.TSType;
import com.nari.jjsd.business.mapper.TSTypeMapper;
import com.nari.jjsd.business.service.TypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ssrs
 * @since 2019-01-12
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TSTypeMapper, TSType> implements TypeService {
@Autowired private TSTypeMapper typeMapper;
    @Override
    public List findType(String typecode) //throws Exception
    {
        EntityWrapper<TSType> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("typegroupid",typecode);
       // try{
            return typeMapper.selectList(entityWrapper);
     //   }catch (Exception e){
     //       e.printStackTrace();
     //   }
    }
}
