package es.jlaa.formatter.impl;

import es.jlaa.formatter.FormatterService;
import es.jlaa.formatter.config.providers.FormatterConfigBuilder;
import es.jlaa.formatter.exceptions.FormatterException;
import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfigProvider;

public class SimpleFormatterService implements FormatterService{
	
	private Formatter formatter;
	
	public SimpleFormatterService(Formatter formatter) {
		this.formatter = formatter;
	}
	
	private Formatter safeFormatter(Class<?> type) {
		if (formatter.support(type)) {
			return formatter;
		}
		throw new FormatterException("Formateador no valido para el tipo: " + type);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T> T parse(Class<T> type, String src, FormatterConfigProvider configProvider) {
		return (T) safeFormatter(type).parse(type, src, configProvider);
	}

	@Override
	public <T> String format(Class<T> type, T obj, FormatterConfigProvider configProvider) {
		return safeFormatter(type).format(type, obj, configProvider);
	}

	@Override
	public <T> T parse(Class<T> type, String src, T def, FormatterConfigProvider configProvider) {
		return src != null ? parse(type, src, configProvider) : def;
	}

	@Override
	public <T> String format(Class<T> type, T obj, String def, FormatterConfigProvider configProvider) {
		return obj != null ? format(type, obj, configProvider) : def;
	}

	@Override
	public <T> T parse(Class<T> type, String src) {
		return parse(type, src, new FormatterConfigBuilder());
	}

	@Override
	public <T> String format(Class<T> type, T obj) {
		return format(type, obj, new FormatterConfigBuilder());
	}

	@Override
	public <T> T parse(Class<T> type, String src, T def) {
		return parse(type, src, def, new FormatterConfigBuilder());
	}

	@Override
	public <T> String format(Class<T> type, T obj, String def) {
		return format(type, obj, def, new FormatterConfigBuilder());
	}

}
