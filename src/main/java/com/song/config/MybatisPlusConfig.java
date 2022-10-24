package com.song.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 最新版


//分页拦截器，拦截sql语句，并在语句后使用数据原生字段limit 进行分页
@Configuration
@MapperScan("com.song.mapper")
public class MybatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
//        创建拦截容器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
//        指定拦截规则，：对select语句拦截并分页
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
        return interceptor;
    }
}