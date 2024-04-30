/*
 * RepositoryWithClientName.java
 *
 * 30 apr 2024
 */
package it.pagopa.swclient.mil.observability;

import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

/**
 * 
 * @author antonio.tarricone
 */
@TraceReactivePanacheMongoRepository
@ApplicationScoped
public class RepositoryWithClientName implements ReactivePanacheMongoRepositoryBase<EntityWithClientName, String> {
}
