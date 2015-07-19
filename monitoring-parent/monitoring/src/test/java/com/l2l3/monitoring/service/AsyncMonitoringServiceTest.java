package com.l2l3.monitoring.service;

import static com.l2l3.monitoring.model.util.MonitoringDataTestUtil.createSampleModel;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.l2l3.monitoring.model.MonitoringData;
import com.l2l3.monitoring.repository.MonitoringRepository;

@RunWith(MockitoJUnitRunner.class)
public class AsyncMonitoringServiceTest {

    private AsyncMonitoringService target;

    @Mock
    private MonitoringRepository repository;

    @Before
    public void init() {
	target = new AsyncMonitoringService(repository);
    }

    @Test
    public void processMonitoringData() {
	target.processMonitoringData(createSampleModel());
	verify(repository, times(1)).save(any(MonitoringData.class));
    }

}
