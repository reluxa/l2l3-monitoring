package com.l2l3.monitoring.config;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MonitoringAsyncUncaughtExceptionHandlerTest {

    private MonitoringAsyncUncaughtExceptionHandler target;

    @Mock
    private Throwable throwable;

    @Before
    public void setUp() throws Exception {
        target = new MonitoringAsyncUncaughtExceptionHandler();
    }

    @Test
    public void printCause() throws NoSuchMethodException, SecurityException {
        Method method = this.getClass().getMethod("printCause");
        target.handleUncaughtException(throwable, method);
        verify(throwable, times(2)).getCause();
    }

}
