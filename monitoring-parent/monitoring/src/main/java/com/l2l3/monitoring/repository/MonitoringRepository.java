package com.l2l3.monitoring.repository;

import java.util.List;

import com.l2l3.monitoring.model.MonitoringData;

public interface MonitoringRepository {

    void save(MonitoringData data);

    void save(List<MonitoringData> data);

}
