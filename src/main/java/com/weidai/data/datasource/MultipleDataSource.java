package com.weidai.data.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * @描述
 * @author nic 
 * @time：2018年7月13日 下午2:23:28
 */
public class MultipleDataSource extends AbstractRoutingDataSource {

	private static ThreadLocal<String> threadLocalDataSource = new ThreadLocal<String>(){
		
		@Override
		protected String initialValue() {return null;}
	};
	
	@Override
	protected Object determineCurrentLookupKey() {
		return threadLocalDataSource.get();
	}
	
	public static void setThreadLocalDatasource(String dsName) {
		threadLocalDataSource.set(dsName);
	}

}
