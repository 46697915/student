package com.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *作者：LCG
 *创建时间：2018/10/18 10:20
 *描述：主要用来解决VUE的跨域调用问题
 */
@Configuration
public class CrosConfig extends WebMvcConfigurerAdapter {

    public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .maxAge(3600);

    }

}
