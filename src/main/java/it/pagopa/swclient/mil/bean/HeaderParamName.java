/*
 * HeaderParamName.java
 *
 * 28 ago 2023
 */
package it.pagopa.swclient.mil.bean;

/**
 * <p>
 * Headers name.
 * </p>
 * 
 * @author Antonio Tarricone
 */
public class HeaderParamName {
	/**
	 * <p>
	 * Request ID.
	 * </p>
	 */
	public static final String REQUEST_ID = "RequestId";

	/**
	 * <p>
	 * Version of the required API.
	 * </p>
	 */
	public static final String VERSION = "Version";

	/**
	 * <p>
	 * Acquirer ID assigned by PagoPA.
	 * </p>
	 */
	public static final String ACQUIRER_ID = "AcquirerId";

	/**
	 * <p>
	 * Channel originating the request.
	 * </p>
	 */
	public static final String CHANNEL = "Channel";

	/**
	 * <p>
	 * Merchant ID originating the transaction. If Channel equals to POS, MerchantId must not be null.
	 * </p>
	 */
	public static final String MERCHANT_ID = "MerchantId";

	/**
	 * <p>
	 * ID of the terminal originating the transaction. It must be unique per acquirer, channel and
	 * merchant if present.
	 * </p>
	 */
	public static final String TERMINAL_ID = "TerminalId";

	/**
	 * <p>
	 * Private default constructor.
	 * </p>
	 */
	private HeaderParamName() {
	}
}