/*
 * ValidationPattern.java
 *
 * 26 lug 2024
 */
package it.pagopa.swclient.mil.bean;

/**
 * <p>
 * Patterns to validate headers.
 * </p>
 * 
 * @author Antonio Tarricone
 */
public class ValidationPattern {
	/**
	 * <p>
	 * Pattern to validate RequestId.
	 * </p>
	 */
	public static final String REQUEST_ID = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";

	/**
	 * <p>
	 * Pattern to validate Version.
	 * </p>
	 */
	public static final String VERSION = "^[ -~]{1,64}$";

	/**
	 * <p>
	 * Pattern to validate AcquirerId.
	 * </p>
	 */
	public static final String ACQUIRER_ID = "^\\d{1,11}$";

	/**
	 * <p>
	 * Pattern to validate Channel.
	 * </p>
	 */
	public static final String CHANNEL = "^(" + Channel.ATM + "|" + Channel.POS + "|" + Channel.TOTEM + "|" + Channel.CASH_REGISTER + "|" + Channel.CSA + ")$";

	/**
	 * <p>
	 * Pattern to validate MerchantId.
	 * </p>
	 */
	public static final String MERCHANT_ID = "^[0-9a-zA-Z]{1,15}$";

	/**
	 * <p>
	 * Pattern to validate TerminalId.
	 * </p>
	 */
	public static final String TERMINAL_ID = "^[0-9a-zA-Z]{1,8}$";

	/**
	 * <p>
	 * Private default constructor.
	 * </p>
	 */
	private ValidationPattern() {
	}
}
