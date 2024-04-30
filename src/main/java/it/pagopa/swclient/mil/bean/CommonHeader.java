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
import jakarta.validation.constraints.Size;
import jakarta.ws.rs.HeaderParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * Common header attributes
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
	@HeaderParam("RequestId")
	@NotNull(message = ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$", message = ErrorCode.REQUEST_ID_MUST_MATCH_REGEXP_MSG)
	private String requestId;

	/*
	 * Version of the required API
	 */
	@HeaderParam("Version")
	@Size(max = 64, message = ErrorCode.VERSION_SIZE_MUST_BE_AT_MOST_MAX_MSG)
	@Pattern(regexp = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$", message = ErrorCode.VERSION_MUST_MATCH_REGEXP_MSG)
	private String version;

	/*
	 * Acquirer ID assigned by PagoPA
	 */
	@HeaderParam("AcquirerId")
	@NotNull(message = ErrorCode.ACQUIRER_ID_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = "^\\d{1,11}$", message = ErrorCode.ACQUIRER_ID_MUST_MATCH_REGEXP_MSG)
	private String acquirerId;

	/*
	 * Channel originating the request
	 */
	@HeaderParam("Channel")
	@NotNull(message = ErrorCode.CHANNEL_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = "^(" + Channel.ATM + "|" + Channel.POS + "|" + Channel.TOTEM + "|" + Channel.CASH_REGISTER + "|" + Channel.CSA + ")$", message = ErrorCode.CHANNEL_MUST_MATCH_REGEXP_MSG)
	private String channel;

	/*
	 * Merchant ID originating the transaction. If Channel equals to POS, MerchantId must not be null.
	 */
	@HeaderParam("MerchantId")
	@Pattern(regexp = "^[0-9a-zA-Z]{1,15}$", message = ErrorCode.MERCHANT_ID_MUST_MATCH_REGEXP_MSG)
	private String merchantId;

	/*
	 * ID of the terminal originating the transaction. It must be unique per acquirer, channel and
	 * merchant if present.
	 */
	@HeaderParam("TerminalId")
	@NotNull(message = ErrorCode.TERMINAL_ID_MUST_NOT_BE_NULL_MSG)
	@Pattern(regexp = "^[0-9a-zA-Z]{1,8}$", message = ErrorCode.TERMINAL_ID_MUST_MATCH_REGEXP_MSG)
	private String terminalId;
}
