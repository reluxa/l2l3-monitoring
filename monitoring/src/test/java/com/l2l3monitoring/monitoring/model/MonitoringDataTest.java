package com.l2l3monitoring.monitoring.model;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import org.junit.Test;

public class MonitoringDataTest {

    @Test
    public void dataIsCreatedProperly() {
	MonitoringData monitoringData = MonitoringData.builder()
		.withClass(Object.class)
		.withMethodName("calculateSomething")
		.addParameter("value", BigDecimal.ONE)
		.withReturnValue("Hello World!")
		.withException(new RuntimeException())
		.withExecutionTime(Duration.ofSeconds(60))
		.withTimestamp(LocalDateTime.of(2015, 7, 10, 21, 34))
		.build();
	assertThat(monitoringData.clazz.getSimpleName(), is("Object"));
	assertThat(monitoringData.methodName, is("calculateSomething"));
	assertThat(monitoringData.parameters.get("value"), is(BigDecimal.ONE));
	assertThat(monitoringData.returnValue, is("Hello World!"));
	assertThat(monitoringData.exception.get(), instanceOf(RuntimeException.class));
	assertThat(monitoringData.executionTime.getSeconds(), is(Long.valueOf(60)));
	assertThat(monitoringData.timestamp.toString(), is("2015-07-10T21:34"));
    }

}