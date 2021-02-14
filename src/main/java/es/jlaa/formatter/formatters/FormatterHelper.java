package es.jlaa.formatter.formatters;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.StringTokenizer;

import es.jlaa.formatter.FormatterConfig;
import es.jlaa.formatter.config.Format;

class FormatterHelper {

	public static void nullCheck(Object value) {
		if (value == null) throw new NullPointerException();
	}
	
	private static Locale getLocale(FormatterConfig config) {
		Locale locale = Locale.getDefault(Locale.Category.FORMAT);
		if (config.containsKey(Format.Keys.LOCALE)) {
			String strLocale = config.getValue(Format.Keys.LOCALE);
			String lang;
			String country;
		    StringTokenizer tokenizer = new StringTokenizer(strLocale,"_");
		    if (tokenizer.countTokens() >= 2) {
		    	lang = (String) tokenizer.nextElement();
		    	country = (String) tokenizer.nextElement();
		    	locale = new Locale(lang, country);
		    }else if (tokenizer.countTokens() > 0){
		    	lang = (String) tokenizer.nextElement();
		    	locale = new Locale(lang);
		    }
		}
		return locale;
	}

	
	public static NumberFormat getIntegerNumberFormat(FormatterConfig config) {
		
		DecimalFormat df = config.containsKey(Format.Keys.PATTERN) ? 
								new DecimalFormat(config.getValue(Format.Keys.PATTERN)) : new DecimalFormat();
		df.setParseIntegerOnly(true);
		
		DecimalFormatSymbols dfs = config.containsKey(Format.Keys.LOCALE) ? 
										new DecimalFormatSymbols(getLocale(config)) : new DecimalFormatSymbols();
		
		if (config.containsKey(Format.Keys.GROUPING_SEPARATOR)) {
			dfs.setGroupingSeparator(config.getValue(Format.Keys.GROUPING_SEPARATOR).charAt(0));
		}
		
		df.setDecimalFormatSymbols(dfs);
	
		return df;
	}
	
	public static NumberFormat getDecimalNumberFormat(FormatterConfig config) {
		
		DecimalFormat df = config.containsKey(Format.Keys.PATTERN) ? 
				new DecimalFormat(config.getValue(Format.Keys.PATTERN)) : new DecimalFormat();
		
		DecimalFormatSymbols dfs = config.containsKey(Format.Keys.LOCALE) ? 
								new DecimalFormatSymbols(getLocale(config)) : new DecimalFormatSymbols();
		
		if (config.containsKey(Format.Keys.GROUPING_SEPARATOR)) {
			dfs.setGroupingSeparator(config.getValue(Format.Keys.GROUPING_SEPARATOR).charAt(0));
		}
		
		if (config.containsKey(Format.Keys.DECIMAL_SEPARATOR)) {
			dfs.setDecimalSeparator(config.getValue(Format.Keys.DECIMAL_SEPARATOR).charAt(0));
		}
		
		df.setDecimalFormatSymbols(dfs);
		
		return df;

	}
	
	public static DateFormat getDateFormat(FormatterConfig config) {
		
		DateFormat dFormat = DateFormat.getDateInstance();
		
		if (config.containsKey(Format.Keys.DATE_FORMAT)) {
			String dateFormat = config.getValue(Format.Keys.DATE_FORMAT);
			if (DateFormatter.FORMAT_DATE_TIME.equals(dateFormat)) {
				dFormat = DateFormat.getDateTimeInstance();
			}else if (DateFormatter.FORMAT_TIME.equals(dateFormat)) {
				dFormat = DateFormat.getTimeInstance();
			}
		}
		
		if (config.containsKey(Format.Keys.PATTERN)) {
			dFormat = new SimpleDateFormat(config.getValue(Format.Keys.PATTERN));
		}
		
		return dFormat;
	}
	
}
