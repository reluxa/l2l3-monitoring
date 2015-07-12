package com.l2l3.monitoring.repository;

import static com.l2l3.monitoring.model.util.MonitoringDataTestUtil.createSampleModel;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.l2l3.monitoring.model.MonitoringData;

@RunWith(MockitoJUnitRunner.class)
public class EsMonitoringRepositoryTest {

    private EsMonitoringRepository target;

    @Mock
    private RestTemplate restTemplate;

    private String elasticsearchClusterUrl = "http://dummy.com";

    @Before
    public void init() throws Exception {
	target = new EsMonitoringRepository(restTemplate, elasticsearchClusterUrl);
    }

    @Test
    public void save() {
	target.save(createSampleModel());
	verify(restTemplate, times(1)).postForObject(eq("http://dummy.com"), any(MonitoringData.class),
		eq(MonitoringData.class));
    }

}
