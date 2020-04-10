package com.priceshoes.rest.applications.config;

public class DataSourceConfig {
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	public String getDriverClassName() {
		return this.driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "DataSourceConfig [driverClassName=" + this.driverClassName + ", url=" + this.url + ", username="
				+ this.username + ", password=" + this.password + "]";
	}
}