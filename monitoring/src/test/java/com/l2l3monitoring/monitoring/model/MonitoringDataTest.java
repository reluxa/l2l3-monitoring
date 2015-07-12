package com.l2l3monitoring.monitoring.model;

import static com.l2l3monitoring.monitoring.model.util.MonitoringDataTestUtil.createSampleModel;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

public class MonitoringDataTest {

    @Test
    public void dataIsCreatedProperly() {
	MonitoringData monitoringData = createSampleModel();
	assertThat(monitoringData.clazz.getSimpleName(), is(Object.class.getSimpleName()));
	assertThat(monitoringData.methodName, is("calculateSomething"));
	assertThat(monitoringData.parameters.get("value"), is(BigDecimal.ONE));
	assertThat(monitoringData.returnValue.get(), is("Hello World!"));
	assertThat(monitoringData.executionTime.getSeconds(), is(Long.valueOf(60)));
	assertThat(monitoringData.timestamp.toString(), is("2015-07-10T21:34"));
    }

}