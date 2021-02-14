package es.jlaa.formatter.config;

import es.jlaa.formatter.config.providers.FormatterConfigBuilder;

public class Format {
	
	public static class Keys{
	
		public static final String PATTERN = "pattern";
		public static final String LOCALE = "locale";
		
		//Boolean
		public static final String TRUE_VALUE = "true_value";
		public static final String FALSE_VALUE = "false_value";
		public static final String CASE_SENSITIVE = "case_sensitive";
		
		//Numbers
		public static final String DECIMAL_SEPARATOR = "decimal_separator";
		public static final String GROUPING_SEPARATOR = "grouping_separator";
		
		//Date
		public static final String DATE_FORMAT = "date_format";
	}
	
	public static FormatterConfigBuilder config(Class<?> type) {
		return new FormatterConfigBuilder().forType(type);
	}
	
	public static FormatterConfigBuilder config() {
		return new FormatterConfigBuilder();
	}

}
