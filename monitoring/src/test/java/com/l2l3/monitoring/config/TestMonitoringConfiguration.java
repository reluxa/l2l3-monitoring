package com.l2l3.monitoring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/test.properties")
@Import({ MonitoringConfiguration.class })
public class TestMonitoringConfiguration {

}
