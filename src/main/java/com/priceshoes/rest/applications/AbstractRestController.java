package com.priceshoes.rest.applications;

import com.priceshoes.rest.applications.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractRestController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	AppConfig appConfig;

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