package com.tzsw.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ImportResource("classpath:META-INF/dubbo/dubbo-provider.xml")
@MapperScan("com.tzsw.provider.dao")
@EnableCaching
public class EdataProviderApplication extends SpringBootServletInitializer {

    /**
     * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
     */
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		this.setRegisterErrorPageFilter(false);
//		return builder.sources(EdataProviderApplication.class);
//	}
    public static void main(String[] args) {
        SpringApplication.run(EdataProviderApplication.class, args);
    }
}
