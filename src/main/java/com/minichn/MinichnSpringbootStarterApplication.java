package com.minichn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.minichn.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.minichn", "org.n3r.idworker"})
//开启定时任务，自动扫描
@EnableScheduling
//开启异步调用方法
@EnableAsync
public class MinichnSpringbootStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinichnSpringbootStarterApplication.class, args);
	}

}
