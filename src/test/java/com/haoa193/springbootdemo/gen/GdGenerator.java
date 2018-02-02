package com.haoa193.springbootdemo.gen;

import io.gd.generator.Config;
import io.gd.generator.Generator;
import io.gd.generator.handler.*;

import java.nio.file.Paths;

/**
 * @author chenyongqdu@foxmail.com
 */
public class GdGenerator {


    public static void main(String[] args) throws Exception {
        Config config = new Config();
        config.setGenLogFile(Paths.get(System.getProperty("user.home") , "springbootdemo.log").toString());
        config.setUrl("jdbc:mysql://127.0.0.1:3306/springbootdemo");
        config.setEntityPackage("com.haoa193.springbootdemo.entity");
        config.setMybatisMapperPackage("com.haoa193.springbootdemo.dao");

        //D:\\Work\\Workspace\\xx-parent
        //Users/freeman/IdeaProjects/xxx-parent
       String projectPath = System.getProperties().get("user.dir") +"";

        System.out.println("projectPath: " + projectPath);
        //xxx-service-impl\\src\\main\\java\\com\\xx\\mapper & windows
        //xxx-service-impl/src/main/java/com/xx/mapper & mac or linux
        config.setMybatisMapperPath(projectPath + "/src/main/java/com/haoa193/springbootdemo/dao");

        //\\xx-service-impl\\src\\main\\resources\\com\\xx\\mapping & windows
        //\\xx-service-impl/src/main/resources/com/xx/mapping & mac or linux
        config.setMybatisXmlPath(projectPath + "/src/main/resources/mapper");
        config.setUsername("root");
        config.setPassword("123456");

        // is use lombok default : true
        config.setUseLombok(true);
        //com.xx.model.query
        config.setQueryModelPackage("com.haoa193.springbootdemo.model.query");
        //\\xx-service\\src\\main\\java\\com\\xx\\model\\query & windows
        //\\xx-service/src/main/java/com/xx/model/query & mac or linux
        config.setQueryModelPath(projectPath + "/src/main/java/com/haoa193/springbootdemo/model/query");

        Generator.generate(config,
                new VoHandler("com.haoa193.springbootdemo.vo", projectPath + "/src/main/java/com/haoa193/springbootdemo/vo", true),
                new QueryModelHandler(),
                new MybatisMapperHandler(),
                new MybatisXmlHandler(false),
                new MysqlHandler(false)
        );
    }


}
