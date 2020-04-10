package com.priceshoes.rest.applications.order;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/connections" })
public class ConnectionPoolingMonitor {
	private DataSource datasource;

	@RequestMapping({ "/getInfo" })
	public ResponseEntity<String> getConnectionInfos() {
		ResponseEntity response = null;
		StringBuilder sb = null;

		try {
			sb = new StringBuilder();
			sb.append("Max-Active: " + this.datasource.getMaxActive() + "\n");
			sb.append("Active: " + this.datasource.getNumActive() + "\n");
			sb.append("Max-Idle: " + this.datasource.getMaxIdle() + "\n");
			sb.append("Idle: " + this.datasource.getNumIdle() + "\n");
			sb.append("MinEvictableIdleTimeMillis: " + this.datasource.getMinEvictableIdleTimeMillis() + "\n");
			sb.append(
					"time-between-eviction-runs-millis: " + this.datasource.getTimeBetweenEvictionRunsMillis() + "\n");
			sb.append("Max-Age: " + this.datasource.getMaxAge() + "\n");
			sb.append("Max-Wait: " + this.datasource.getMaxWait() + "\n");
			sb.append("Created Count: " + this.datasource.getCreatedCount() + "\n");
			sb.append("Released Count: " + this.datasource.getReleasedCount() + "\n");
			sb.append("Size: " + this.datasource.getSize() + "\n");
			sb.append("Pool Size: " + this.datasource.getPoolSize() + "\n");
			response = new ResponseEntity(sb.toString(), HttpStatus.OK);
		} catch (Exception arg3) {
			arg3.printStackTrace();
		}

		return response;
	}
}