package com.l2l3monitoring.monitoring.config;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MonitoringConfiguration.class)
public class MonitoringConfigurationTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void applicationContextIsReady() {
	assertNotNull(applicationContext);
    }

}
