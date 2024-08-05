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
 * Personal Data Vault client.
 * </p>
 * <p>
 * To use this:
 * </p>
 * <ul>
 * <li>Add {@code io.quarkus:quarkus-rest-client-jackson} to the dependencies.</li>
 * <li>Add {@code quarkus.rest-client.pdv-api.url} to {@code application.properties} with the URL to
 * reach PDV, e.g.: {@code https://api.uat.tokenizer.pdv.pagopa.it/tokenizer/v1/tokens}</li>
 * <li>Add {@code pdv-api.api-key} to {@code application.properties} with the API-key of PDV.</li>
 * </ul>
 * 
 * @author Antonio Tarricone
 */
@RegisterRestClient(configKey = "pdv-api")
public interface Tokenizer {
	/**
	 * <p>
	 * Protects personal data.
	 * </p>
	 * 
	 * @param personalData {@link it.pagopa.swclient.mil.pdv.bean.PersonalData}
	 * @return {@link it.pagopa.swclient.mil.pdv.bean.Token}
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ClientHeaderParam(name = "x-api-key", value = "${pdv-api.api-key}", required = true)
	Uni<Token> tokenize(PersonalData personalData);

	/**
	 * <p>
	 * Puts in clear protected personal data.
	 * </p>
	 * 
	 * @param tokenValue {@link it.pagopa.swclient.mil.pdv.bean.Token}
	 * @return {@link it.pagopa.swclient.mil.pdv.bean.PersonalData}
	 */
	@GET
	@Path("/{token}")
	@Produces(MediaType.APPLICATION_JSON)
	@ClientHeaderParam(name = "x-api-key", value = "${pdv-api.api-key}", required = true)
	Uni<PersonalData> detokenize(@PathParam("token") String tokenValue);
}