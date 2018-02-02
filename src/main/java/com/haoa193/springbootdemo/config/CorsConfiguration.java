package com.haoa193.springbootdemo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new CorsFilter());
        bean.addUrlPatterns("/*");
        bean.setName("corsFilter");
        return bean;
    }
}
