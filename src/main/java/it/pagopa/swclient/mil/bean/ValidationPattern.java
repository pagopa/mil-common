/*
 * ValidationPattern.java
 *
 * 26 lug 2024
 */
package it.pagopa.swclient.mil.bean;

/**
 * 
 * @author Antonio Tarricone
 */
public class ValidationPattern {
	public static final String REQUEST_ID = "^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$";
	public static final String VERSION = "^[ -~]{1,64}$";
	public static final String ACQUIRER_ID = "^\\d{1,11}$";
	public static final String CHANNEL = "^(" + Channel.ATM + "|" + Channel.POS + "|" + Channel.TOTEM + "|" + Channel.CASH_REGISTER + "|" + Channel.CSA + ")$";
	public static final String MERCHANT_ID= "^[0-9a-zA-Z]{1,15}$";
	public static final String TERMINAL_ID = "^[0-9a-zA-Z]{1,8}$";
	
	private ValidationPattern() {
	}
}
