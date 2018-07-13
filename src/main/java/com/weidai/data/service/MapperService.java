package com.weidai.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weidai.data.datasource.MultipleDataSource;
import com.weidai.data.mapper.TExampleMapper;
import com.weidai.data.model.TExample;


/**
 * @描述
 * @author nic 
 * @time：2018年7月13日 下午3:08:01
 */
@Service
public class MapperService {

	@Autowired TExampleMapper mapper;
	
	public void insert(TExample record) {
//		MultipleDataSource.setThreadLocalDatasource("dsone");
		mapper.insert(record);
	}
	
	public TExample select(int id) {
//		MultipleDataSource.setThreadLocalDatasource("dstwo");
		return mapper.selectByPrimaryKey(id);
	}
	
}
