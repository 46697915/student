package com.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.logging.log4j2.SpringBootConfigurationFactory;

/**
 * Hello world!
 *
 */
@SpringBootApplication
//扫描Mybatis接口包(有@Mapper注解不用增加)
@MapperScan("com.project.business.**.mapper")
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
