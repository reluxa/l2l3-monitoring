package com.l2l3.monitoring.config;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import com.google.common.base.Throwables;

public class MonitoringAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonitoringAsyncUncaughtExceptionHandler.class);

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... params) {
	LOGGER.error("Error at calling: " + method.getName(), Throwables.getRootCause(throwable));
    }

}
