/*
 * OtelReceiver.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SpanExporter;

/**
 * 
 * @author antonio.tarricone
 */
public class OtelReceiver implements SpanExporter {
	/*
	 * 
	 */
	private Map<String, String> attributes;

	/**
	 * 
	 */
	OtelReceiver() {
		attributes = new HashMap<>();
	}

	Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * 
	 */
	@Override
	public CompletableResultCode export(Collection<SpanData> spans) {
		spans.forEach(s -> s.getAttributes()
			.asMap()
			.entrySet()
			.stream()
			.forEach(e -> attributes.put(e.getKey().getKey(), e.getValue().toString())));

		return CompletableResultCode.ofSuccess();
	}

	/**
	 * 
	 */
	@Override
	public CompletableResultCode flush() {
		return CompletableResultCode.ofSuccess();
	}

	/**
	 * 
	 */
	@Override
	public CompletableResultCode shutdown() {
		return CompletableResultCode.ofSuccess();
	}
}
