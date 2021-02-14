package es.jlaa.formatter;

public interface FormatterService {

	public <T> T parse(Class<T> type, String src, FormatterConfigProvider configProvider);

	public <T> String format(Class<T> type, T obj, FormatterConfigProvider configProvider);

	public <T> T parse(Class<T> type, String src, T def, FormatterConfigProvider configProvider);

	public <T> String format(Class<T> type, T obj, String def, FormatterConfigProvider configProvider);

	public <T> T parse(Class<T> type, String src);

	public <T> String format(Class<T> type, T obj);

	public <T> T parse(Class<T> type, String src, T def);

	public <T> String format(Class<T> type, T obj, String def);

}
