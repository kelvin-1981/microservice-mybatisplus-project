package com.yykj.mybatis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class AutoCodeMain {

    /**
     * 构建代码生成器
     * @param args
     */
    public static void main(String[] args) {
        // TODO: 1.构建代码生成器对象
        AutoGenerator mpg = new AutoGenerator();

        // TODO: 2.配置策略
        // TODO: 2.1 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projPath = System.getProperty("user.dir");
        //gc.setOutputDir(projPath + "/src/main/java");
        gc.setOutputDir(projPath + "/mybatisplus-02-autocode/src/main/java");
        gc.setAuthor("kelvin");
        gc.setOpen(false);//是否打开资源管理器
        gc.setFileOverride(false);
        //gc.setServiceName("%sService"); //去Service的I前缀
        gc.setIdType(IdType.ID_WORKER);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);//swagger文档
        mpg.setGlobalConfig(gc);

        // TODO: 2.2 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        mpg.setDataSource(dsc);

        // TODO: 2.3 配置生成的包
        PackageConfig pc = new PackageConfig();
        //pc.setModuleName("plus");
        pc.setParent("com.yykj.mybatis");
        pc.setEntity("pojo");
        pc.setMapper("dao");
        pc.setService("service");
        pc.setController("controller");
        mpg.setPackageInfo(pc);

        // TODO: 2.4 配置策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("user");    //设置要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);    //自动lombok
        strategy.setLogicDeleteFieldName("deleted");

        // TODO: 2.5 A.自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);
        // TODO: 2.6 B.乐观锁
        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // TODO: 3.执行构建
        mpg.execute();
    }
}
