package com.l2l3.monitoring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.l2l3.monitoring.service.AsyncMonitoringService;
import com.l2l3.monitoring.service.MonitoringService;

@Configuration
@EnableAsync
public class MonitoringConfiguration {

    @Bean
    public MonitoringService monitoringService() {
	return new AsyncMonitoringService();
    }

}
