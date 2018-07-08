package com.thd.util.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thd.Application;

//获取启动类，加载配置，确定装载 Spring 程序的装载方法，它会去寻找 主配置启动类(默认是@SpringBootApplication 注解的类)
//如果不配置@SpringBootTest的classes属性则自动寻找被 @SpringBootApplication 注解的）
@SpringBootTest(classes=Application.class)
//让 JUnit 运行 Spring 的测试环境， 获得 Spring 环境的上下文的支持
@RunWith(SpringRunner.class)
public class EntityDaoImplTest {
	@Autowired
	private EntityDao entityDaoImpl;
	@Before
    public void setUp() throws Exception {
		System.out.println(" ------------------------ junit @setUp() ---------------------- ");
    }

    @After
    public void tearDown() throws Exception {
    	System.out.println(" ------------------------ junit @After() ---------------------- ");
    }
    
	@Test

	public void testsave() {
		System.out.println(entityDaoImpl);
		
		System.out.println("success");
	}
}
