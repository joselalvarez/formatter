package es.jlaa.formatter;

public interface FormatterConfigProvider {

	FormatterConfig getFormatterConfig(Class<?> ... types);
	
}
