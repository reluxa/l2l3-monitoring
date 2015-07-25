package com.l2l3.monitoring;

import static com.l2l3.monitoring.model.util.MonitoringDataTestUtil.createSampleModel;
import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.elasticsearch.action.search.SearchResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.l2l3.monitoring.config.TestMonitoringConfiguration;
import com.l2l3.monitoring.es.EmbeddedElasticsearchServer;
import com.l2l3.monitoring.service.MonitoringService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestMonitoringConfiguration.class })
public class MonitoringIntegrationTest {

    private static final int WAIT_TIME = 3000;

    @Autowired
    private MonitoringService monitoringService;

    private EmbeddedElasticsearchServer embeddedElasticsearchServer;

    @Before
    public void startEmbeddedElasticsearchServer() {
	embeddedElasticsearchServer = new EmbeddedElasticsearchServer();
    }

    @After
    public void shutdownEmbeddedElasticsearchServer() {
	embeddedElasticsearchServer.shutdown();
    }

    @Test
    public void save() {
	monitoringService.processMonitoringData(createSampleModel());

	waitForAsyncOperation();

	SearchResponse result = embeddedElasticsearchServer.getClient().prepareSearch().execute().actionGet();

	assertThat(result.getHits().hits().length, is(1));
	assertThat(result.getHits().hits()[0].getSource().get("clazz"), is("java.lang.Object"));

    }

    private void waitForAsyncOperation() {
	try {
	    sleep(WAIT_TIME);
	} catch (InterruptedException e) {
	    fail();
	}
    }

}
