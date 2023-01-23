/*
 * CommonHeader.java
 *
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.ws.rs.HeaderParam;

import it.gov.pagopa.swclient.mil.ErrorCode;
import it.gov.pagopa.swclient.mil.validation.constraints.MerchantIdNotNullForPos;

/**
 * Common header attributes
 * 
 * @author Antonio Tarricone
 */
@MerchantIdNotNullForPos(message = "[" + ErrorCode.MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS + "] If Channel equals to POS, MerchantId must not be null")
public class CommonHeader {
	/*
	 * Request ID
	 */
	@HeaderParam("RequestId")
	@NotNull(message = "[" + ErrorCode.REQUEST_ID_MUST_NOT_BE_NULL + "] RequestId must not be null")
	@Pattern(regexp = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$", message = "[" + ErrorCode.REQUEST_ID_MUST_MATCH_REGEXP + "] RequestId must match \"{regexp}\"")
	private String requestId;

	/*
	 * Version of the required API
	 */
	@HeaderParam("Version")
	@Size(max = 64, message = "[" + ErrorCode.VERSION_SIZE_MUST_BE_AT_MOST_MAX + "] Version size must be at most {max}")
	@Pattern(regexp = "^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$", message = "[" + ErrorCode.VERSION_MUST_MATCH_REGEXP + "] Version must match \"{regexp}\"")
	private String version;

	/*
	 * Acquirer ID assigned by PagoPA
	 */
	@HeaderParam("AcquirerId")
	@NotNull(message = "[" + ErrorCode.ACQUIRER_ID_MUST_NOT_BE_NULL + "] AcquirerId must not be null")
	@Pattern(regexp = "^\\d{1,11}$", message = "[" + ErrorCode.ACQUIRER_ID_MUST_MATCH_REGEXP + "] AcquirerId must match \"{regexp}\"")
	private String acquirerId;

	/*
	 * Channel originating the request
	 */
	@HeaderParam("Channel")
	@NotNull(message = "[" + ErrorCode.CHANNEL_MUST_NOT_BE_NULL + "] Channel must not be null")
	@Pattern(regexp = "^(ATM|POS|TOTEM|CASH_REGISTER|CSA)$", message = "[" + ErrorCode.CHANNEL_MUST_MATCH_REGEXP + "] Channel must match \"{regexp}\"")
	private String channel;

	/*
	 * Merchant ID originating the transaction. If Channel equals to POS, MerchantId must not be null.
	 */
	@HeaderParam("MerchantId")
	@Pattern(regexp = "^[0-9a-zA-Z]{1,15}$", message = "[" + ErrorCode.MERCHANT_ID_MUST_MATCH_REGEXP + "] MerchantId must match \"{regexp}\"")
	private String merchantId;
	
	/*
	 * ID of the terminal originating the transaction. It must be unique per acquirer, channel and merchant if present.
	 */
	@HeaderParam("TerminalId")
	@NotNull(message = "[" + ErrorCode.TERMINAL_ID_MUST_NOT_BE_NULL + "] TerminalId must not be null")
	@Pattern(regexp = "^[0-9a-zA-Z]{1,8}$", message = "[" + ErrorCode.TERMINAL_ID_MUST_MATCH_REGEXP + "] TerminalId must match \"{regexp}\"")
	private String terminalId;

	/**
	 * @return the requestId
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * @param requestId the requestId to set
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the acquirerId
	 */
	public String getAcquirerId() {
		return acquirerId;
	}

	/**
	 * @param acquirerId the acquirerId to set
	 */
	public void setAcquirerId(String acquirerId) {
		this.acquirerId = acquirerId;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the terminalId
	 */
	public String getTerminalId() {
		return terminalId;
	}

	/**
	 * @param terminalId the terminalId to set
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CommonHeader [requestId=").append(requestId).append(", version=").append(version).append(", acquirerId=").append(acquirerId).append(", channel=").append(channel).append(", merchantId=").append(merchantId).append(", terminalId=").append(terminalId).append("]");
		return builder.toString();
	}
}
