package com.embryoai.acloud.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParamConfig {
	
	@Value("${linux.ip}")
	private String linuxIp;
	
	@Value("${linux.username}")
	private String linuxUsername;
	
	@Value("${linux.password}")
	private String linuxPassword;
	
	@Value("${minio.alias}")
	private String minioAlias;

	public String getLinuxIp() {
		return linuxIp;
	}

	public void setLinuxIp(String linuxIp) {
		this.linuxIp = linuxIp;
	}

	public String getLinuxUsername() {
		return linuxUsername;
	}

	public void setLinuxUsername(String linuxUsername) {
		this.linuxUsername = linuxUsername;
	}

	public String getLinuxPassword() {
		return linuxPassword;
	}

	public void setLinuxPassword(String linuxPassword) {
		this.linuxPassword = linuxPassword;
	}

	public String getMinioAlias() {
		return minioAlias;
	}

	public void setMinioAlias(String minioAlias) {
		this.minioAlias = minioAlias;
	}
	
	
}
