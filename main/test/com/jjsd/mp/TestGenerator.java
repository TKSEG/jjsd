package com.jjsd.mp;


import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.toolkit.GlobalConfigUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:    代码生成
 * @Author:         ssrs
 * @CreateDate:     2018/8/3 17:20
 * @UpdateUser:     ssrs
 * @UpdateDate:     2018/8/3 17:20
 * @Version:        1.0
 */

public class TestGenerator {

    /**
     * 代码生成    示例代码
     */
    @Test
    public void  testGenerator() {
        //1. 全局配置

        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false) // 是否支持AR模式
                .setAuthor("yb") // 作者
                .setEnableCache(false)// XML 二级缓存

                 .setOutputDir("D:\\IdeaProjects\\quella\\src\\main\\java") // 生成路径
                .setFileOverride(true)  // 文件覆盖
                .setIdType(IdType.AUTO) // 主键策略
//                .setServiceName("%sService")  // 设置生成的service接口的名字的首字母是否为I
                // IEmployeeService
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        //2. 数据源配置
        DataSourceConfig dsConfig  = new DataSourceConfig();
        dsConfig.setDbType(DbType.MYSQL)  // 设置数据库类型
                .setDriverName("com.mysql.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/quella")
                .setUsername("root")
                .setPassword("root123456");

        //3. 策略配置
        StrategyConfig stConfig = new StrategyConfig();
        stConfig.setCapitalMode(true) //全局大写命名
                .setDbColumnUnderline(true)  // 指定表名 字段名是否使用下划线
                .setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                .setTablePrefix("p_")
                .setInclude("p_extrawork") ; // 需要生成的表名



        //4. 包名策略配置
        PackageConfig pkConfig = new PackageConfig();
        pkConfig.setParent(null)
                .setMapper("com.nari.jjsd.business.mapper")
                .setService("com.nari.jjsd.business.service")
                .setServiceImpl("com.nari.jjsd.business.service.impl")
                .setController("com.nari.jjsd.business.controller")
                .setEntity("com.nari.jjsd.business.model")
                .setXml("com.nari.jjsd.business.mapper.xml");

        //5. 整合配置
        AutoGenerator ag = new AutoGenerator();

        ag.setGlobalConfig(config)
                .setDataSource(dsConfig)
                .setStrategy(stConfig)
                .setPackageInfo(pkConfig);

        //6. 执行
        ag.execute();
    }



}
