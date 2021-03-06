package com.thd;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//囊括@SpringBootConfiguration @EnableAutoConfiguration  @ComponentScan   三个注释
@SpringBootApplication(scanBasePackages = "com.thd")

// 开启自动配置功能 以前我们需要配置的东西,Spring Boot帮我们自动配置
// 如果有@SpringBootApplication 则下面注释可不写
// @EnableAutoConfiguration

// 开启扫描@Component,@Controller,@Service,@Repository
// 如果有@SpringBootApplication(scanBasePackages = "com.thd") 下面的注释可不写
// 是以前的<context:component-scan>
// @ComponentScan(basePackages = {"com.thd"})

// 注明这个类是个配置文件 继承自@Configuration，二者功能也一致 和以前的xml配置是等效的
// 如果有@SpringBootApplication 则下面注释可不写
// @SpringBootConfiguration

// ------------------ hibernate -----------------//
@EnableJpaRepositories
// 扫描hibernate实体
@EntityScan(basePackages = "com.thd")
// 开启扫描@Transactional 数据库事务
@EnableTransactionManagement

// ------------------ 加载配置文件 -----------------//
@PropertySource(value = { "classpath:config/application.properties",
		"classpath:config/db.properties" }, encoding = "utf-8")

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	

}
