package com.l2l3.elasticsearch;

import org.apache.commons.io.FileUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.File;
import java.io.IOException;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

@WebListener
public class EmbeddedElasticsearchServer implements ServletContextListener {

    private static final String DEFAULT_DATA_DIRECTORY = "target/elasticsearch-data";
    private static final Logger LOGGER = LoggerFactory.getLogger(EmbeddedElasticsearchServer.class);

    private final Node node;
    private final String dataDirectory;

    public static EmbeddedElasticsearchServer instance;

    public EmbeddedElasticsearchServer() {
        this(DEFAULT_DATA_DIRECTORY);
    }

    public EmbeddedElasticsearchServer(String dataDirectory) {
        this.dataDirectory = dataDirectory;

        ImmutableSettings.Builder elasticsearchSettings = ImmutableSettings.settingsBuilder()
                .put("http.enabled", "true")
                .put("http.cors.enabled", "true")
                .put("http.cors.allow-origin","/.*/")
                .put("path.data", dataDirectory);

        node = nodeBuilder()
                .local(true)
                .settings(elasticsearchSettings.build())
                .node();
    }

    public Client getClient() {
        return node.client();
    }

    public void shutdown() {
        node.close();
        //deleteDataDirectory();
    }

    private void deleteDataDirectory() {
        try {
            FileUtils.deleteDirectory(new File(dataDirectory));
        } catch (IOException e) {
            throw new RuntimeException("Could not delete data directory of embedded elasticsearch server", e);
        }
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("**** EmbeddedElasticsearchServer ctx init");
        instance = new EmbeddedElasticsearchServer();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("**** EmbeddedElasticsearchServer ctx close");
        instance.shutdown();
    }
}
