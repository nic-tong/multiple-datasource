package com.weidai.data.aspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.weidai.data.datasource.MultipleDataSource;


/**
 * @描述
 * @author nic 
 * @time：2018年7月13日 下午2:30:34
 */
@Component
@Aspect
public class MultipleDataSourceAspect {

	@Pointcut("execution(* com.weidai.data.mapper.*.insert(..))")
	public void insertPointcut(){}
	
	@Pointcut("execution(* com.weidai.data.mapper.*.selectByPrimaryKey(..))")
	public void queryPointcut(){}
	
	
	@Before("insertPointcut()")
	public void beforInsert() {
		System.out.println("使用数据库1 进行插入");
		MultipleDataSource.setThreadLocalDatasource("dsone");
	}
	
	@Before("queryPointcut()")
	public void beforQuery() {
		System.out.println("使用数据库2 进行查询");
		MultipleDataSource.setThreadLocalDatasource("dstwo");
	}
}
