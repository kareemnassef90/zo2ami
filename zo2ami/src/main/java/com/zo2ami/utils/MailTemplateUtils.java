package com.zo2ami.utils;

import java.util.Map;

public final class MailTemplateUtils {
	
	private MailTemplateUtils() {}
	
	public static String buildMail(String rowContent, Map<String, String> data) {
		String processedContent = "";
		for (Map.Entry<String, String> element : data.entrySet()) {
			processedContent = rowContent.replaceAll("{"+element.getKey()+"}", element.getValue());
		}
		return processedContent;
	}

}
