package kh.com.khmerside.khmersideprocomm.validation;

public class CommonValidationCls {
	/**
	 * 
	 * @param strParam
	 * @return true if param is number, otherwise return false;
	 */
	public static boolean isNumber(String strParam) {

		if (!strParam.matches("^-?[0-9]+(\\[0-9]+)?$")) return false;
		return true;
	}

	/**
	 * 
	 * @param strParam
	 * @return true if param is capitalAphabet, otherwise return false;
	 */
	public static boolean isCapitalAphabet(String strParam) {

		if (!strParam.matches("^-?[A-Z]+(\\[A-Z]+)?$")) return false;

		return true;
	}

	/**
	 * 
	 * @param strParam
	 * @return true if param is smallaphabet, otherwise return false;
	 */
	public static boolean isSmallAphabet(String strParam) {

		if (!strParam.matches("^-?[a-z]+(\\[a-z]+)?$")) return false;
		return true;
	}

	/**
	 * 
	 * @param strParam
	 * @return true if param is valid length with intLength, otherwise return false;
	 */
	public static boolean isValidLength(String strText, int intLength) {
		if (strText.length() != intLength) return false;
		return true;
	}
}
