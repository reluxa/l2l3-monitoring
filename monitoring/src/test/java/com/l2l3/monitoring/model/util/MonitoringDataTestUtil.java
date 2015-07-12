package com.l2l3.monitoring.model.util;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;

import com.l2l3.monitoring.model.MonitoringData;

public final class MonitoringDataTestUtil {

    private MonitoringDataTestUtil() {
    }

    public static MonitoringData createSampleModel() {
	return MonitoringData.builder()
		.withClass(Object.class)
		.withMethodName("calculateSomething")
		.addParameter("value", BigDecimal.ONE)
		.withReturnValue("Hello World!")
		.withExecutionTime(Duration.ofSeconds(60))
		.withTimestamp(LocalDateTime.of(2015, 7, 10, 21, 34))
		.build();
    }

}
