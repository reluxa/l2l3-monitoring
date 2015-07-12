package com.l2l3monitoring.monitoring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.l2l3monitoring.monitoring.service.AsyncMonitoringService;
import com.l2l3monitoring.monitoring.service.MonitoringService;

@Configuration
@EnableAsync
public class MonitoringConfiguration {

    @Bean
    public MonitoringService monitoringService() {
	return new AsyncMonitoringService();
    }

}
