package es.jlaa.formatter;

public interface Formatter {

	boolean support(Class<?> type);
	
	Object parse(Class<?> type, String src, FormatterConfigProvider configProvider);
	
	String format(Class<?> type, Object obj, FormatterConfigProvider configProvider);
	
}
