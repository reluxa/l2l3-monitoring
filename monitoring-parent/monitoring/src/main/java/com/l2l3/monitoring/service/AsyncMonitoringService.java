package com.l2l3.monitoring.service;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.l2l3.monitoring.model.MonitoringData;
import com.l2l3.monitoring.repository.MonitoringRepository;

public class AsyncMonitoringService implements MonitoringService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncMonitoringService.class);

    private final MonitoringRepository repository;

    public AsyncMonitoringService(MonitoringRepository repository) {
	this.repository = repository;
    }

    @Override
    @Async
    public void processMonitoringData(MonitoringData data) {
	LOGGER.debug("Process monitoring data asynchronously: {}", data);
	Validate.notNull(data, "Data cannot be null");
	repository.save(data);
    }

}
