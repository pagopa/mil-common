/*
 * EntityWithoutAnnotation.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import org.bson.codecs.pojo.annotations.BsonId;

/**
 * 
 * @author antonio.tarricone
 */
public class EntityWithoutAnnotation {
	@BsonId
	public String id;
	public String attribute1;
	public String attribute2;
}
