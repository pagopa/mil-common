/*
 * Tokenizer.java
 *
 * 16 mag 2024
 */
package it.pagopa.swclient.mil.pdv.client;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.smallrye.mutiny.Uni;
import it.pagopa.swclient.mil.pdv.bean.PersonalData;
import it.pagopa.swclient.mil.pdv.bean.Token;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * <p>
 * To use this:
 * <ul>
 * <li>Add {@code io.quarkus:quarkus-rest-client-jackson} to the dependencies.</li>
 * <li>Add {@code quarkus.rest-client.pdv-api.url} to {@code application.properties} with the URL to
 * reach PDV, e.g.: {@code https://api.uat.tokenizer.pdv.pagopa.it/tokenizer/v1/tokens}</li>
 * <li>Add {@code pdv-api.api-key} to {@code application.properties} with the API-key of PDV.</li>
 * </ul>
 * </p>
 * 
 * @author Antonio Tarricone
 */
@RegisterRestClient(configKey = "pdv-api")
public interface Tokenizer {
	/**
	 * 
	 * @param personalData
	 * @return
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ClientHeaderParam(name = "x-api-key", value = "${pdv-api.api-key}", required = true)
	Uni<Token> tokenize(PersonalData personalData);

	/**
	 * 
	 * @param tokenValue
	 * @return
	 */
	@GET
	@Path("/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@ClientHeaderParam(name = "x-api-key", value = "${pdv-api.api-key}", required = true)
	Uni<PersonalData> detokenize(@PathParam("token") String tokenValue);
}