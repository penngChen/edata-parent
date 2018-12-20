package com.tzsw.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
@ImportResource("classpath:config/dubbo-consumer.xml")
public class EdataConsumerApplication extends SpringBootServletInitializer {

	/**
	 * 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式
	 */
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//		this.setRegisterErrorPageFilter(false);
//		return builder.sources(EdataConsumerApplication.class);
//	}

	public static void main(String[] args) {
		SpringApplication.run(EdataConsumerApplication.class, args);
	}


	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 允许跨域访问的域名
		corsConfiguration.addAllowedOrigin("*");
		// 请求头
		corsConfiguration.addAllowedHeader("*");
		// 请求方法
		corsConfiguration.addAllowedMethod("*");

		return corsConfiguration;
	}

	/**
	 * 跨域过滤器
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}
}
