package es.jlaa.formatter.formatters;

import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfigProvider;

public class StringFormatter implements Formatter{

	@Override
	public boolean support(Class<?> type) {
		return String.class.equals(type);
	}

	@Override
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(src);
		
		return src;
	}

	@Override
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(obj);
		
		return (String) obj;
	}

}
