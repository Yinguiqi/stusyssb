package com.mht.stueaxm.config;

import com.mht.stueaxm.lnterceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Kirtico
 * @date 2023/7/2&10:11
 */
@Configuration
public class MyConfigurer implements WebMvcConfigurer {
    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/**")                         // 拦截全部路径
                .excludePathPatterns("/LoginController");    // 放行部分路径

    }
}

