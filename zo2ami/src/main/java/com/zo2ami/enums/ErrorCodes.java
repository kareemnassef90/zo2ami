package com.zo2ami.enums;

public enum ErrorCodes {
	
	MISSING_USERNAME("1000", "MISSING_USERNAME"),
	MISSING_EMAIL("1001", "MISSING_EMAIL"),
	MISSING_PASSWORD("1002", "MISSING_PASSWORD"),
	MISSING_CONFIRM_PASSWORD("1003", "MISSING_CONFIRM_PASSWORD"),
	MISSING_MOBILE_NUMBER("1004", "MISSING_MOBILE_NUMBER"),
	PASSWORDS_NOT_MATCHED("1005", "PASSWORDS_NOT_MATCHED"),
	MISSING_ACCOUNT_TYPE("1006", "MISSING_ACCOUNT_TYPE"),
	MISSING_CONTACT_PERSON_NAME("1007", "MISSING_CONTACT_PERSON_NAME"),
	MISSING_CONTACT_PERSON_EMAIL("1008", "MISSING_CONTACT_PERSON_EMAIL"),
	MISSING_CONTACT_PERSON_MOBILE_NUMBER("1009", "MISSING_CONTACT_PERSON_MOBILE_NUMBER"),
	MISSING_LOCATION("1010", "MISSING_LOCATION"),
	MISSING_LEGAL_DOCUMENT("1011", "MISSING_LEGAL_DOCUMENT"),
	EMAIL_ALREADY_EXISTS("1012", "EMAIL_ALREADY_EXISTS"),
	USER_NOT_FOUND("1013", "USER_NOT_FOUND"),
	MISSING_RESET_PASSWORD_TOKEN("1014", "MISSING_RESET_PASSWORD_TOKEN"),
	INVALID_RESET_PASSWORD_TOKEN("1015", "INVALID_RESET_PASSWORD_TOKEN"),
	EXPIRED_RESET_PASSWORD_TOKEN("1016", "EXPIRED_RESET_PASSWORD_TOKEN"),
//	PASSWORD_ALREADY_CHANGED("1017", "PASSWORD_ALREADY_CHANGED"),
	MISSING_CLIENT_TYPE("1018", "MISSING_CLIENT_TYPE"),
//	EMAIL_ALREADY_EXISTS("1019", "EMAIL_ALREADY_EXISTS"),
	INVALID_USERNAME_OR_PASSWORD("1020", "INVALID_USERNAME_OR_PASSWORD"),
	NEW_PASSWORD_EQUALS_THE_CURRENT_PASSWORD("1021", "NEW_PASSWORD_EQUALS_THE_CURRENT_PASSWORD"),
	
	MISSING_ID("1022", "MISSING_ID"),
	INVALID_ID("1023", "INVALID_ID"),
	
	MISSING_CATEGORY_NAME_AR("1024", "MISSING_CATEGORY_NAME_AR"),
	MISSING_CATEGORY_NAME_EN("1025", "MISSING_CATEGORY_NAME_EN"),
	MISSING_CATEGORY_DISPLAY_ORDER("1026", "MISSING_CATEGORY_DISPLAY_ORDER"),
	MISSING_ACTIVITY_NAME_AR("1027", "MISSING_ACTIVITY_NAME_AR"),
	MISSING_ACTIVITY_NAME_EN("1028", "MISSING_ACTIVITY_NAME_EN"),
	MISSING_ACTIVITY_PRICE("1029", "MISSING_ACTIVITY_PRICE"),
	MISSING_ACTIVITY_PICS("1030", "MISSING_ACTIVITY_PICS"),
	MISSING_ACTIVITY_START_DATE("1031", "MISSING_ACTIVITY_START_DATE"),
	MISSING_ACTIVITY_END_DATE("1032", "MISSING_ACTIVITY_END_DATE"),
	MISSING_CANCEL_REASON("1033", "MISSING_CANCEL_REASON"),
	CANNOT_CANCEL("1034", "CANNOT_CANCEL"),
	
;	
	private final String code;
	private final String message;
	
	
	ErrorCodes(String code, String message){
		this.code = code;
		this.message = message;
	}


	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}
	

}
