package com.priceshoes.rest.applications.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractService {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	public void logInfo(String message) {
		this.logger.info(message);
	}

	public void logDebug(String message) {
		this.logger.debug(message);
	}

	public void logWarn(String message) {
		this.logger.warn(message);
	}

	public void logError(String message) {
		this.logger.error(message);
	}
}