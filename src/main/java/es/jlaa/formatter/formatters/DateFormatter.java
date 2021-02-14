package es.jlaa.formatter.formatters;

import java.text.ParseException;
import java.util.Date;

import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfig;
import es.jlaa.formatter.FormatterConfigProvider;
import es.jlaa.formatter.exceptions.FormatterException;

public class DateFormatter implements Formatter{
	
	public static final String FORMAT_DATE_TIME = "datetime";
	public static final String FORMAT_DATE = "date";
	public static final String FORMAT_TIME = "time";
	
	@Override
	public boolean support(Class<?> type) {
		return Date.class.equals(type);
	}

	@Override
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(src);
		
		FormatterConfig config = configProvider.getFormatterConfig(Date.class);
		try {
			return FormatterHelper.getDateFormat(config).parse(src);
		} catch (ParseException e) {
			throw new FormatterException("Error al parsear '" + src + "' : " + e.getMessage());
		}
	}

	@Override
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(obj);
		
		FormatterConfig config = configProvider.getFormatterConfig(Date.class);
		return FormatterHelper.getDateFormat(config).format((Date) obj);
	}

}
