package com.l2l3monitoring.monitoring.service;

import com.l2l3monitoring.monitoring.model.MonitoringData;

public interface MonitoringService {

    void processMonitoringData(MonitoringData data);

}