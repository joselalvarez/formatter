package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.jlaa.formatter.utils.FormatterUtil;

public class StringFormatterTest {
	
	@Test
	public void testFormat() {
		assertEquals("Hello", FormatterUtil.format(String.class, "Hello"));
	}
	
	@Test
	public void testParse() {
		assertEquals("World", FormatterUtil.parse(String.class, "World"));
	}
}
