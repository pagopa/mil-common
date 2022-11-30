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

/**
 * Common header attributes
 * 
 * @author Antonio Tarricone
 */
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
	 * ID of the terminal originating the transaction. It must be unique per acquirer and channel.
	 */
	@HeaderParam("TerminalId")
	@NotNull(message = "[" + ErrorCode.TERMINAL_ID_MUST_NOT_BE_NULL + "] TerminalId must not be null")
	@Pattern(regexp = "^[0-9a-zA-Z]{8}$", message = "[" + ErrorCode.TERMINAL_ID_MUST_MATCH_REGEXP + "] TerminalId must match \"{regexp}\"")
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
		builder.append("CommonHeader [requestId=").append(requestId).append(", version=").append(version).append(", acquirerId=").append(acquirerId).append(", channel=").append(channel).append(", terminalId=").append(terminalId).append("]");
		return builder.toString();
	}
}
