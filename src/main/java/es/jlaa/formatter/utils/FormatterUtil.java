package es.jlaa.formatter.utils;

import es.jlaa.formatter.FormatterService;
import es.jlaa.formatter.formatters.CompositeFormatter;
import es.jlaa.formatter.formatters.DefaultFormatter;
import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfigProvider;
import es.jlaa.formatter.impl.SimpleFormatterService;

public class FormatterUtil {
	
	private static Formatter formatter;
	private static FormatterService instance;
	
	public static synchronized Formatter getDefaultFormatter() {
		if (formatter == null) {
			formatter = new DefaultFormatter();
		}
		return formatter;
	}
	
	public static synchronized FormatterService getInstance() {
		if (instance == null) {
			instance = new SimpleFormatterService(getDefaultFormatter());
		}
		return instance;
	}
	
	public static FormatterService getInstance(Formatter formatter) {
		return new SimpleFormatterService(new CompositeFormatter().with(formatter));
	}
	
	public static <T> T parse(Class<T> type, String src, FormatterConfigProvider configProvider) {
		return getInstance().parse(type, src, configProvider);
	}
	
	public static <T> String format(Class<T> type, T obj, FormatterConfigProvider configProvider) {
		return getInstance().format(type, obj, configProvider);
	}
	
	public static <T> T parse(Class<T> type, String src, T def, FormatterConfigProvider configProvider) {
		return getInstance().parse(type, src, def, configProvider);
	}
	
	public static <T> String format(Class<T> type, T obj, String def, FormatterConfigProvider configProvider) {
		return getInstance().format(type, obj, def, configProvider);
	}
	
	public static <T> T parse(Class<T> type, String src) {
		return getInstance().parse(type, src);
	}
	
	public static <T> String format(Class<T> type, T obj) {
		return getInstance().format(type, obj);
	}
	
	public static <T> T parse(Class<T> type, String src, T def) {
		return getInstance().parse(type, src, def);
	}
	
	public static <T> String format(Class<T> type, T obj, String def) {
		return getInstance().format(type, obj, def);
	}
}
