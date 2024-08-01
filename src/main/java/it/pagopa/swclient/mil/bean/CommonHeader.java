/*
 * CommonHeader.java
 *
 * 26 nov 2022
 */
package it.pagopa.swclient.mil.bean;

import it.pagopa.swclient.mil.ErrorCode;
import it.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPos;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.ws.rs.HeaderParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>Common header attributes</p>
 * 
 * @author Antonio Tarricone
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
@MerchantIdNotNullForPos(message = ErrorCode.MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS_MSG)
public class CommonHeader {
	/*
	 * Request ID
	 */
	@HeaderParam(HeaderParamName.REQUEST_ID)
	@NotNull(message = ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL_MSG)
	// It's verified by it.pagopa.swclient.mil.CommonHeadersValidatorFilter:
	// @Pattern(regexp = ValidationPattern.REQUEST_ID, message = ErrorCode.REQUEST_ID_MUST_MATCH_REGEXP_MSG)
	private String requestId;

	/*
	 * Version of the required API
	 */
	@HeaderParam(HeaderParamName.VERSION)
	// It's verified by it.pagopa.swclient.mil.CommonHeadersValidatorFilter:
	// @Pattern(regexp = ValidationPattern.VERSION, message = ErrorCode.VERSION_MUST_MATCH_REGEXP_MSG)
	private String version;

	/*
	 * Acquirer ID assigned by PagoPA
	 */
	@HeaderParam(HeaderParamName.ACQUIRER_ID)
	@NotNull(message = ErrorCode.ACQUIRER_ID_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = ValidationPattern.ACQUIRER_ID, message = ErrorCode.ACQUIRER_ID_MUST_MATCH_REGEXP_MSG)
	private String acquirerId;

	/*
	 * Channel originating the request
	 */
	@HeaderParam(HeaderParamName.CHANNEL)
	@NotNull(message = ErrorCode.CHANNEL_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = ValidationPattern.CHANNEL)
	private String channel;

	/*
	 * Merchant ID originating the transaction. If Channel equals to POS, MerchantId must not be null.
	 */
	@HeaderParam(HeaderParamName.MERCHANT_ID)
	@Pattern(regexp = ValidationPattern.MERCHANT_ID, message = ErrorCode.MERCHANT_ID_MUST_MATCH_REGEXP_MSG)
	private String merchantId;

	/*
	 * ID of the terminal originating the transaction. It must be unique per acquirer, channel and
	 * merchant if present.
	 */
	@HeaderParam(HeaderParamName.TERMINAL_ID)
	@NotNull(message = ErrorCode.TERMINAL_ID_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = ValidationPattern.TERMINAL_ID, message = ErrorCode.TERMINAL_ID_MUST_MATCH_REGEXP_MSG)
	private String terminalId;
}
