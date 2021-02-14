package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.jlaa.formatter.config.Format;
import es.jlaa.formatter.utils.FormatterUtil;

public class BooleanFormatterTest {
	
	@Test
	public void testFormatTrue() {
		assertEquals("true", FormatterUtil.format(Boolean.class, true));
		assertEquals("true", FormatterUtil.format(boolean.class, true));
	}
	
	@Test
	public void testFormatFalse() {
		assertEquals("false", FormatterUtil.format(Boolean.class, false));
		assertEquals("false", FormatterUtil.format(boolean.class, false));
	}
	
	@Test
	public void testFormatWithValues() {
		assertEquals("1", FormatterUtil.format(Boolean.class, true, Format.config().withBooleanValues("1", "0")));
		assertEquals("0", FormatterUtil.format(Boolean.class, false, Format.config().withBooleanValues("1", "0")));
	}
	
	@Test
	public void testParseTrue() {
		assertEquals(true, FormatterUtil.parse(Boolean.class, "true"));
	}
	
	@Test
	public void testParseFalse() {
		assertEquals(false, FormatterUtil.parse(Boolean.class, "false"));
	}
	
	@Test
	public void testParseWithValues() {
		assertEquals(true, FormatterUtil.parse(Boolean.class, "1", Format.config().withBooleanValues("1", "0")));
		assertEquals(false, FormatterUtil.parse(Boolean.class, "0", Format.config().withBooleanValues("1", "0")));
	}	
}
