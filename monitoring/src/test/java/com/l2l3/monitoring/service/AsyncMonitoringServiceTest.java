package com.l2l3.monitoring.service;

import static com.l2l3.monitoring.model.util.MonitoringDataTestUtil.createSampleModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AsyncMonitoringServiceTest {

    private AsyncMonitoringService target;

    @Before
    public void init() {
	target = new AsyncMonitoringService();
    }

    @Test
    public void processMonitoringData() {
	target.processMonitoringData(createSampleModel());
    }

}
