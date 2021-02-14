package es.jlaa.formatter;

public interface FormatterConfig {

	boolean containsKey(String key);

	String getValue(String key);

	String getValue(String key, String def);
}
