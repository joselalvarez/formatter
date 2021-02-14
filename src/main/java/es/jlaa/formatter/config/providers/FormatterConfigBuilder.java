package es.jlaa.formatter.config.providers;

import java.util.HashMap;
import java.util.Locale;
import es.jlaa.formatter.FormatterConfig;
import es.jlaa.formatter.FormatterConfigProvider;
import es.jlaa.formatter.config.Format;
import es.jlaa.formatter.formatters.DateFormatter;
import es.jlaa.formatter.impl.SimpleFormatterConfig;

public class FormatterConfigBuilder implements FormatterConfigProvider{
	
	private SimpleFormatterConfig def;
	private SimpleFormatterConfig current;
	private HashMap<Class<?>, SimpleFormatterConfig> typesIndex;
	
	public FormatterConfigBuilder() {
		def = new SimpleFormatterConfig();
		current = def;
		typesIndex = new HashMap<Class<?>, SimpleFormatterConfig>();
	}
	
	public FormatterConfigBuilder forDefault() {
		current = def;
		return this;
	}
	
	public FormatterConfigBuilder forType(Class<?> type) {
		if (typesIndex.containsKey(type)) {
			current = typesIndex.get(type);
		}else {
			current = new SimpleFormatterConfig();
			typesIndex.put(type, current);
		}
		return this;
	}
	
	public FormatterConfigBuilder with(String key, String value) {
		current.put(key, value);
		return this;
	}
	
	public FormatterConfigBuilder withPattern(String pattern) {
		return with(Format.Keys.PATTERN, pattern);
	}
	
	public FormatterConfigBuilder withLocale(String locale) {
		return with(Format.Keys.LOCALE, locale);
	}
	
	public FormatterConfigBuilder withLocale(Locale locale) {
		return with(Format.Keys.LOCALE, locale.toString());
	}
	
	public FormatterConfigBuilder withTrueValue(String value) {
		return with(Format.Keys.TRUE_VALUE, value);
	}
	
	public FormatterConfigBuilder withFalseValue(String value) {
		return with(Format.Keys.FALSE_VALUE, value);
	}
	
	public FormatterConfigBuilder withBooleanValues(String tValue, String fValue) {
		return withTrueValue(tValue).withFalseValue(fValue);
	}
	
	public FormatterConfigBuilder withDecimalSeparator(char separator) {
		return with(Format.Keys.DECIMAL_SEPARATOR, String.valueOf(separator));
	}
	
	public FormatterConfigBuilder withGroupingSeparator(char separator) {
		return with(Format.Keys.GROUPING_SEPARATOR, String.valueOf(separator));
	}
	
	public FormatterConfigBuilder withOnlyDate() {
		return with(Format.Keys.DATE_FORMAT, DateFormatter.FORMAT_DATE);
	}
	
	public FormatterConfigBuilder withOnlyTime() {
		return with(Format.Keys.DATE_FORMAT, DateFormatter.FORMAT_TIME);
	}
	
	public FormatterConfigBuilder withDateAndTime() {
		return with(Format.Keys.DATE_FORMAT, DateFormatter.FORMAT_DATE_TIME);
	}
	
	public FormatterConfigBuilder withNumberSeparators(char decimal, char grouping) {
		return withDecimalSeparator(decimal).withGroupingSeparator(grouping);
	}
	
	public FormatterConfigBuilder without(String key) {
		current.remove(key);
		return this;
	}
		
	@Override
	public FormatterConfig getFormatterConfig(Class<?>... types) {

		if (types != null) {
			for (Class<?> type : types) {
				if (typesIndex.containsKey(type)) return typesIndex.get(type).copy();
			}
		}

		return def.copy();
	}

}
