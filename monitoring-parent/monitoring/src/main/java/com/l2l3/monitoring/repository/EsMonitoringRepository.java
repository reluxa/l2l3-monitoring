package com.l2l3.monitoring.repository;

import org.springframework.web.client.RestTemplate;

import com.l2l3.monitoring.model.MonitoringData;

public class EsMonitoringRepository implements MonitoringRepository {

    private final String elasticsearchClusterUrl;

    private final RestTemplate restTemplate;

    public EsMonitoringRepository(RestTemplate restTemplate, String elasticsearchClusterUrl) {
	this.restTemplate = restTemplate;
	this.elasticsearchClusterUrl = elasticsearchClusterUrl;
    }

    @Override
    public void save(MonitoringData data) {
	restTemplate.postForObject(elasticsearchClusterUrl, data, MonitoringData.class);
    }

}
