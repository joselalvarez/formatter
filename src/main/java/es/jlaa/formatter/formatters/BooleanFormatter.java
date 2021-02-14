package es.jlaa.formatter.formatters;

import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfig;
import es.jlaa.formatter.FormatterConfigProvider;
import es.jlaa.formatter.config.Format;

public class BooleanFormatter implements Formatter{
	
	public static final String DEF_TRUE_VALUE = "true";
	public static final String DEF_FALSE_VALUE = "false";

	@Override
	public boolean support(Class<?> type) {
		return Boolean.class.equals(type) || boolean.class.equals(type);
	}

	@Override
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(src);
		
		FormatterConfig config = configProvider.getFormatterConfig(Boolean.class, boolean.class);
		boolean caseSensitive = Boolean.parseBoolean(config.getValue(Format.Keys.CASE_SENSITIVE));
		
		String value = caseSensitive ? src.trim() : src.trim().toLowerCase();
		String trueValue = caseSensitive ? config.getValue(Format.Keys.TRUE_VALUE, DEF_TRUE_VALUE) : config.getValue(Format.Keys.TRUE_VALUE, DEF_TRUE_VALUE).toLowerCase();
		
		return trueValue.equals(value) ? Boolean.TRUE : Boolean.FALSE;
	}

	@Override
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(obj);
		
		FormatterConfig config = configProvider.getFormatterConfig(Boolean.class, boolean.class);
		return (Boolean) obj ? config.getValue(Format.Keys.TRUE_VALUE, DEF_TRUE_VALUE) : config.getValue(Format.Keys.FALSE_VALUE, DEF_FALSE_VALUE);
	}

}
