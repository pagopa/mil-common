/*
 * PersonalData.java
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
import lombok.experimental.Accessors;

/**
 * <p>
 * Personal Data Vault input class.
 * </p>
 * 
 * @author Antonio Tarricone
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalData {
	/**
	 * <p>
	 * Value of personal data to protect.
	 * </p>
	 */
	@JsonProperty("pii")
	private String value;
}