/*
 * ErrorCode.java
 *
 * 26 nov 2022
 */
package it.pagopa.swclient.mil;

import it.pagopa.swclient.mil.bean.ValidationPattern;

/**
 * <p>
 * Error codes.
 * </p>
 * 
 * @author Antonio Tarricone
 */
public final class ErrorCode {
	/**
	 * <p>
	 * Error code prefix.
	 * </p>
	 */
	public static final String MODULE_ID = "000";

	/*
	 * Codes
	 */

	/**
	 * <p>
	 * Error code for "RequestId must not be null".
	 * </p>
	 */
	public static final String REQUEST_ID_MUST_NOT_BE_NULL = MODULE_ID + "000001";

	/**
	 * <p>
	 * Error code for "RequestId must match regexp".
	 * </p>
	 */
	public static final String REQUEST_ID_MUST_MATCH_REGEXP = MODULE_ID + "000002";

	/**
	 * <p>
	 * Error code for "Version must match regexp".
	 * </p>
	 */
	public static final String VERSION_MUST_MATCH_REGEXP = MODULE_ID + "000004";

	/**
	 * <p>
	 * Error code for "AcquirerId must not be null".
	 * </p>
	 */
	public static final String ACQUIRER_ID_MUST_NOT_BE_NULL = MODULE_ID + "000005";

	/**
	 * <p>
	 * Error code for "AcquirerId must match regexp".
	 * </p>
	 */
	public static final String ACQUIRER_ID_MUST_MATCH_REGEXP = MODULE_ID + "000006";

	/**
	 * <p>
	 * Error code for "Channel must not be null".
	 * </p>
	 */
	public static final String CHANNEL_MUST_NOT_BE_NULL = MODULE_ID + "000007";

	/**
	 * <p>
	 * Error code for "Channel must match regexp".
	 * </p>
	 */
	public static final String CHANNEL_MUST_MATCH_REGEXP = MODULE_ID + "000008";

	/**
	 * <p>
	 * Error code for "TerminalId must not be null".
	 * </p>
	 */
	public static final String TERMINAL_ID_MUST_NOT_BE_NULL = MODULE_ID + "000009";

	/**
	 * <p>
	 * Error code for "TerminalId must match regexp".
	 * </p>
	 */
	public static final String TERMINAL_ID_MUST_MATCH_REGEXP = MODULE_ID + "00000A";

	/**
	 * <p>
	 * Error code for "If Channel equals to POS, MerchantId must not be null".
	 * </p>
	 */
	public static final String MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS = MODULE_ID + "00000B";

	/**
	 * <p>
	 * Error code for "MerchantId must match regexp".
	 * </p>
	 */
	public static final String MERCHANT_ID_MUST_MATCH_REGEXP = MODULE_ID + "00000C";

	/*
	 * Descriptions
	 */

	/**
	 * <p>
	 * Error description for "Request ID must not be null".
	 * </p>
	 */
	public static final String REQUEST_ID_MUST_NOT_BE_NULL_DESCR = "Request ID must not be null";

	/**
	 * <p>
	 * Error description for "Request ID must match regexp".
	 * </p>
	 */
	public static final String REQUEST_ID_MUST_MATCH_REGEXP_DESCR = "Request ID must match \"" + ValidationPattern.REQUEST_ID + "\"";

	/**
	 * <p>
	 * Error description for "Version must match regexp".
	 * </p>
	 */
	public static final String VERSION_MUST_MATCH_REGEXP_DESCR = "Version must match \"" + ValidationPattern.VERSION + "\"";

	/**
	 * <p>
	 * Error description for "Acquirer ID must not be null".
	 * </p>
	 */
	public static final String ACQUIRER_ID_MUST_NOT_BE_NULL_DESCR = "Acquirer ID must not be null";

	/**
	 * <p>
	 * Error description for "Acquirer ID must match regexp".
	 * </p>
	 */
	public static final String ACQUIRER_ID_MUST_MATCH_REGEXP_DESCR = "Acquirer ID must match \"{regexp}\"";

	/**
	 * <p>
	 * Error description for "Channel must not be null".
	 * </p>
	 */
	public static final String CHANNEL_MUST_NOT_BE_NULL_DESCR = "Channel must not be null";

	/**
	 * <p>
	 * Error description for "Channel must match regexp".
	 * </p>
	 */
	public static final String CHANNEL_MUST_MATCH_REGEXP_DESCR = "Channel must match \"{regexp}\"";

	/**
	 * <p>
	 * Error description for "Terminal ID must not be null".
	 * </p>
	 */
	public static final String TERMINAL_ID_MUST_NOT_BE_NULL_DESCR = "Terminal ID must not be null";

	/**
	 * <p>
	 * Error description for "Terminal ID must match regexp".
	 * </p>
	 */
	public static final String TERMINAL_ID_MUST_MATCH_REGEXP_DESCR = "Terminal ID must match \"{regexp}\"";

	/**
	 * <p>
	 * Error description for "If channel equals to POS, merchant ID must not be null".
	 * </p>
	 */
	public static final String MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS_DESCR = "If channel equals to POS, merchant ID must not be null";

	/**
	 * <p>
	 * Error description for "Merchant ID must match regexp".
	 * </p>
	 */
	public static final String MERCHANT_ID_MUST_MATCH_REGEXP_DESCR = "Merchant ID must match \"{regexp}\"";

	/*
	 * Messages
	 */

	/**
	 * <p>
	 * Error message for "Request ID must not be null".
	 * </p>
	 */
	public static final String REQUEST_ID_MUST_NOT_BE_NULL_MSG = "[" + REQUEST_ID_MUST_NOT_BE_NULL + "] " + REQUEST_ID_MUST_NOT_BE_NULL_DESCR;

	/**
	 * <p>
	 * Error message for "Request ID must match regexp".
	 * </p>
	 */
	public static final String REQUEST_ID_MUST_MATCH_REGEXP_MSG = "[" + REQUEST_ID_MUST_MATCH_REGEXP + "] " + REQUEST_ID_MUST_MATCH_REGEXP_DESCR;

	/**
	 * <p>
	 * Error message for "Version must match regexp".
	 * </p>
	 */
	public static final String VERSION_MUST_MATCH_REGEXP_MSG = "[" + VERSION_MUST_MATCH_REGEXP + "] " + VERSION_MUST_MATCH_REGEXP_DESCR;

	/**
	 * <p>
	 * Error message for "Acquirer ID must not be null".
	 * </p>
	 */
	public static final String ACQUIRER_ID_MUST_NOT_BE_NULL_MSG = "[" + ACQUIRER_ID_MUST_NOT_BE_NULL + "] " + ACQUIRER_ID_MUST_NOT_BE_NULL_DESCR;

	/**
	 * <p>
	 * Error message for "Acquirer ID must match regexp".
	 * </p>
	 */
	public static final String ACQUIRER_ID_MUST_MATCH_REGEXP_MSG = "[" + ACQUIRER_ID_MUST_MATCH_REGEXP + "] " + ACQUIRER_ID_MUST_MATCH_REGEXP_DESCR;

	/**
	 * <p>
	 * Error message for "Channel must not be null".
	 * </p>
	 */
	public static final String CHANNEL_MUST_NOT_BE_NULL_MSG = "[" + CHANNEL_MUST_NOT_BE_NULL + "] " + CHANNEL_MUST_NOT_BE_NULL_DESCR;

	/**
	 * <p>
	 * Error message for "Channel must match regexp".
	 * </p>
	 */
	public static final String CHANNEL_MUST_MATCH_REGEXP_MSG = "[" + CHANNEL_MUST_MATCH_REGEXP + "] " + CHANNEL_MUST_MATCH_REGEXP_DESCR;

	/**
	 * <p>
	 * Error message for "Terminal ID must not be null".
	 * </p>
	 */
	public static final String TERMINAL_ID_MUST_NOT_BE_NULL_MSG = "[" + TERMINAL_ID_MUST_NOT_BE_NULL + "] " + TERMINAL_ID_MUST_NOT_BE_NULL_DESCR;

	/**
	 * <p>
	 * Error message for "Terminal ID must match regexp".
	 * </p>
	 */
	public static final String TERMINAL_ID_MUST_MATCH_REGEXP_MSG = "[" + TERMINAL_ID_MUST_MATCH_REGEXP + "] " + TERMINAL_ID_MUST_MATCH_REGEXP_DESCR;

	/**
	 * <p>
	 * Error message for "If channel equals to POS, merchant ID must not be null".
	 * </p>
	 */
	public static final String MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS_MSG = "[" + MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS + "] " + MERCHANT_ID_MUST_NOT_BE_NULL_FOR_POS_DESCR;

	/**
	 * <p>
	 * Error message for "Merchant ID must match regexp".
	 * </p>
	 */
	public static final String MERCHANT_ID_MUST_MATCH_REGEXP_MSG = "[" + MERCHANT_ID_MUST_MATCH_REGEXP + "] " + MERCHANT_ID_MUST_MATCH_REGEXP_DESCR;

	/**
	 * <p>
	 * Private default constructor.
	 * </p>
	 */
	private ErrorCode() {
	}
}
