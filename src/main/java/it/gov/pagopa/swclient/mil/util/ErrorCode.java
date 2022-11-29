/*
 * ErrorCode.java
 *
 * 26 nov 2022
 */
package it.gov.pagopa.swclient.mil.util;

/**
 * 
 * @author Antonio Tarricone
 */
public final class ErrorCode {
	public static final String MODULE_ID = "000";

	public static final String REQUEST_ID_MUST_NOT_BE_NULL = MODULE_ID + "000001";
	public static final String REQUEST_ID_MUST_MATCH_REGEXP = MODULE_ID + "000002";

	public static final String VERSION_SIZE_MUST_BE_AT_MOST_MAX = MODULE_ID + "000003";
	public static final String VERSION_MUST_MATCH_REGEXP = MODULE_ID + "000004";

	public static final String ACQUIRER_ID_MUST_NOT_BE_NULL = MODULE_ID + "000005";
	public static final String ACQUIRER_ID_MUST_MATCH_REGEXP = MODULE_ID + "000006";

	public static final String CHANNEL_MUST_NOT_BE_NULL = MODULE_ID + "000007";
	public static final String CHANNEL_MUST_MATCH_REGEXP = MODULE_ID + "000008";

	public static final String TERMINAL_ID_MUST_NOT_BE_NULL = MODULE_ID + "000009";
	public static final String TERMINAL_ID_MUST_MATCH_REGEXP = MODULE_ID + "00000A";

	private ErrorCode() {
	}
}
