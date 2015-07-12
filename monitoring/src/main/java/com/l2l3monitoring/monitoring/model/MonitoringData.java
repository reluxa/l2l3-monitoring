package com.l2l3monitoring.monitoring.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.google.common.collect.ImmutableMap;

public class MonitoringData {

    public final Class<?> clazz;

    public final String methodName;

    public final ImmutableMap<String, Object> parameters;

    public final Optional<Object> returnValue;

    public final Optional<Throwable> exception;

    public final Duration executionTime;

    public final LocalDateTime timestamp;

    private MonitoringData(Builder builder) {
	this.clazz = builder.clazz;
	this.methodName = builder.methodName;
	this.parameters = builder.parameters.build();
	this.returnValue = builder.returnValue;
	this.exception = builder.exception;
	this.executionTime = builder.executionTime;
	this.timestamp = builder.timestamp;
    }

    @Override
    public String toString() {
	return ReflectionToStringBuilder.toString(this);
    }

    @Override
    public int hashCode() {
	return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
	return EqualsBuilder.reflectionEquals(this, other);
    }

    public static Builder builder() {
	return new Builder();
    }

    public static class Builder {

	private Class<?> clazz;

	private String methodName;

	private ImmutableMap.Builder<String, Object> parameters = ImmutableMap.builder();

	private Optional<Object> returnValue = Optional.empty();

	private Optional<Throwable> exception = Optional.empty();

	private Duration executionTime;

	private LocalDateTime timestamp;

	private Builder() {
	}

	public Builder withClass(Class<?> clazz) {
	    this.clazz = clazz;
	    return this;
	}

	public Builder withMethodName(String methodName) {
	    this.methodName = methodName;
	    return this;
	}

	public Builder addParameter(String name, Object value) {
	    parameters.put(name, value);
	    return this;
	}

	public Builder withReturnValue(Object returnValue) {
	    this.returnValue = Optional.ofNullable(returnValue);
	    return this;
	}

	public Builder withException(Throwable exception) {
	    this.exception = Optional.ofNullable(exception);
	    return this;
	}

	public Builder withExecutionTime(Duration executionTime) {
	    this.executionTime = executionTime;
	    return this;
	}

	public Builder withTimestamp(LocalDateTime timestamp) {
	    this.timestamp = timestamp;
	    return this;
	}

	public MonitoringData build() {
	    return new MonitoringData(this);
	}

    }

}
