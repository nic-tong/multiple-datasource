package com.weidai.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.weidai.data.mapper.TExampleMapper;
import com.weidai.data.model.TExample;
import com.weidai.data.service.MapperService;


/**
 * @描述
 * @author nic 
 * @time：2018年7月13日 下午2:40:52
 */
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TExampleTest {

	@Autowired MapperService service;

	@Test
	public void testMutilpeDataSource() {
		TExample tx = new TExample();
		tx.setAge(10);
		tx.setName("asdasd");
		service.insert(tx);
		TExample tx2 =  service.select(10);
		System.out.println(JSON.toJSONString(tx2));
	}
}
