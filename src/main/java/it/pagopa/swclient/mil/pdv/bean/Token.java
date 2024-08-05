/*
 * Token.java
 *
 * 16 mag 2024
 */
package it.pagopa.swclient.mil.pdv.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * Personal Data Vault output class.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Token {
	/**
	 * <p>
	 * Protected value of personal data.
	 * </p>
	 */
	@JsonProperty("token")
	private String value;
}
