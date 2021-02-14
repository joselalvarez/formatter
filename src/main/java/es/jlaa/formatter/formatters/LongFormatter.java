package es.jlaa.formatter.formatters;

import java.text.ParseException;

import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfig;
import es.jlaa.formatter.FormatterConfigProvider;
import es.jlaa.formatter.exceptions.FormatterException;

public class LongFormatter implements Formatter{

	@Override
	public boolean support(Class<?> type) {
		return Long.class.equals(type) || long.class.equals(type);
	}

	@Override
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(src);
		
		FormatterConfig config = configProvider.getFormatterConfig(Long.class);
		try {
			return FormatterHelper.getIntegerNumberFormat(config).parse(src).longValue();
		} catch (ParseException e) {
			throw new FormatterException("Error al parsear '" + src + "' : " + e.getMessage());
		}
	}

	@Override
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(obj);
		
		FormatterConfig config = configProvider.getFormatterConfig(Long.class);
		return FormatterHelper.getIntegerNumberFormat(config).format((Long) obj);
	}

}
