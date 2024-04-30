/*
 * EntityWithoutClientName.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import org.bson.codecs.pojo.annotations.BsonId;

import io.quarkus.mongodb.panache.common.MongoEntity;

/**
 * 
 * @author antonio.tarricone
 */
@MongoEntity(database = "swclient_mil_test", collection = "test")
public class EntityWithoutClientName {
	@BsonId
	public String id;
	public String attribute1;
	public String attribute2;
}
