package es.jlaa.formatter.formatters;

import java.util.ArrayList;
import java.util.List;

import es.jlaa.formatter.FormatterConfigProvider;
import es.jlaa.formatter.Formatter;
import es.jlaa.formatter.exceptions.FormatterException;

public class CompositeFormatter implements Formatter{

	private List<Formatter> formatters;
	
	public CompositeFormatter() {
		this.formatters = new ArrayList<Formatter>();
	}
	
	public CompositeFormatter with(Formatter formatter) {
		formatters.add(formatter);
		return this;
	}

	protected Formatter getFormatter(Class<?> type){
		for (Formatter f : formatters) {
			if (f.support(type)) {
				return f;
			}
		}
		return null;
	}
	
	private Formatter safeFormatter(Class<?> type) {
		Formatter f = getFormatter(type);
		if (f != null) {
			return f;
		}
		throw new FormatterException("Formateador no valido para el tipo: " + type);
	}

	@Override
	public boolean support(Class<?> type) {
		return getFormatter(type) != null;
	}

	@Override
	public Object parse(Class<?> type, String src, FormatterConfigProvider configProvider) {
		return safeFormatter(type).parse(type, src, configProvider);
	}

	@Override
	public String format(Class<?> type, Object obj, FormatterConfigProvider configProvider) {
		return safeFormatter(type).format(type, obj, configProvider);
	}


}
