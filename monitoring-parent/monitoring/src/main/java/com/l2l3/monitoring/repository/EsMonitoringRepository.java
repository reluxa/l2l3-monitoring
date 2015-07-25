package com.l2l3.monitoring.repository;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.web.client.RestTemplate;

import com.l2l3.monitoring.model.MonitoringData;

public class EsMonitoringRepository implements MonitoringRepository {

    private final String elasticsearchClusterUrl;

    private final RestTemplate restTemplate;

    public EsMonitoringRepository(RestTemplate restTemplate, String elasticsearchClusterUrl) {
        Validate.notBlank(elasticsearchClusterUrl);
        this.restTemplate = restTemplate;
        this.elasticsearchClusterUrl = elasticsearchClusterUrl;
    }

    @Override
    public void save(MonitoringData data) {
        Validate.notNull(data, "Data cannot be null");
        restTemplate.postForObject(elasticsearchClusterUrl, data, MonitoringData.class);
    }

    @Override
    public void save(List<MonitoringData> data) {
        Validate.notNull(data, "Data cannot be null");
        data.forEach(this::save);
    }

}
