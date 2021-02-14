package es.jlaa.formatter.impl;

import java.util.HashMap;

import es.jlaa.formatter.FormatterConfig;

public class SimpleFormatterConfig implements FormatterConfig{

	private HashMap<String, String> cnf;
	
	public SimpleFormatterConfig() {
		this.cnf = new HashMap<String, String>();
	}
	
	public void put(String key, String value) {
		cnf.put(key, value);
	}
	
	public void remove(String key) {
		cnf.remove(key);
	}
	
	@Override
	public boolean containsKey(String key) {
		return cnf.containsKey(key);
	}

	@Override
	public String getValue(String key) {
		return cnf.get(key);
	}
	
	@Override
	public String getValue(String key, String def) {
		return cnf.containsKey(key) && cnf.get(key) != null ? cnf.get(key) : def;
	}
	
	public SimpleFormatterConfig copy() {
		SimpleFormatterConfig copy = new SimpleFormatterConfig();
		copy.cnf.putAll(cnf);
		return copy;
	}

}
