package com.l2l3.monitoring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.l2l3.monitoring.model.MonitoringData;

public class AsyncMonitoringService implements MonitoringService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncMonitoringService.class);

    @Override
    @Async
    public void processMonitoringData(MonitoringData data) {
	LOGGER.info("Process monitoring data asynchronously: {}", data);
    }

}
