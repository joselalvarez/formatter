package es.jlaa.formatter.formatters;

import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.FormatterConfigProvider;

public class CharacterFormatter implements Formatter{

	@Override
	public boolean support(Class<?> type) {
		return Character.class.equals(type) || char.class.equals(type);
	}

	@Override
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(src);
		
		return Character.valueOf(src.charAt(0));
	}

	@Override
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		
		FormatterHelper.nullCheck(obj);
		
		Character c = (Character) obj;
		return c.toString();
	}

}
