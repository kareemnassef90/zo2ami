package com.zo2ami.utils;

import java.util.Map;

public final class MailTemplateUtils {
	
	private MailTemplateUtils() {}
	
	public static String buildMail(String template, Map<String, String> params) {
		String newTemplate = template;
		for(Map.Entry<String, String> entry : params.entrySet()){
			if(template.contains("{"+entry.getKey()+"}")) {
				newTemplate = newTemplate.replaceAll( "\\{"+entry.getKey()+"\\}", entry.getValue());
			}
		}
		return newTemplate;
	}

}
