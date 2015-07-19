package com.l2l3.monitoring.config;

import static com.google.common.collect.Lists.newArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

import com.l2l3.monitoring.repository.EsMonitoringRepository;
import com.l2l3.monitoring.repository.MonitoringRepository;
import com.l2l3.monitoring.service.AsyncMonitoringService;
import com.l2l3.monitoring.service.MonitoringService;

@Configuration
@EnableAsync
public class MonitoringConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public MonitoringRepository monitoringRepository() {
	return new EsMonitoringRepository(restTemplate(), elasticsearchClusterUrl());
    }

    public String elasticsearchClusterUrl() {
	return environment.getRequiredProperty("es.cluster.url");
    }

    @Bean
    public MonitoringService monitoringService() {
	return new AsyncMonitoringService(monitoringRepository());
    }

    @Bean
    public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	restTemplate.setMessageConverters(newArrayList(new MappingJackson2HttpMessageConverter()));
	return restTemplate;
    }

}
