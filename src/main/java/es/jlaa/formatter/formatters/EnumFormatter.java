package es.jlaa.formatter.formatters;

import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfigProvider;

public class EnumFormatter implements Formatter{

	@Override
	public boolean support(Class<?> type) {
		return type.isEnum();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(src);
		
		Class<? extends Enum> enumType = (Class<? extends Enum>) type;
		return Enum.valueOf(enumType, src);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(obj);
		
		return ((Enum) obj).name();
	}

}
