package com.l2l3.monitoring.es;

import static org.elasticsearch.common.settings.ImmutableSettings.settingsBuilder;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.Node;

public class EmbeddedElasticsearchServer {

    private static final String DEFAULT_DATA_DIRECTORY = "target/montioring-data";

    private final Node node;
    private final String dataDirectory;

    public EmbeddedElasticsearchServer() {
	this(DEFAULT_DATA_DIRECTORY);
    }

    public EmbeddedElasticsearchServer(String dataDirectory) {
	this.dataDirectory = dataDirectory;

	ImmutableSettings.Builder elasticsearchSettings = settingsBuilder()
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
	deleteDataDirectory();
    }

    private void deleteDataDirectory() {
	try {
	    FileUtils.deleteDirectory(new File(dataDirectory));
	} catch (IOException e) {
	    throw new RuntimeException("Could not delete data directory of embedded elasticsearch server", e);
	}
    }
}
