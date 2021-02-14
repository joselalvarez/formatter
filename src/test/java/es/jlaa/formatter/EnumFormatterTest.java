package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.jlaa.formatter.utils.FormatterUtil;

public class EnumFormatterTest {
	
	private enum TestEnum {ONE, TWO};
	
	@Test
	public void testFormat() {
		assertEquals("ONE", FormatterUtil.format(TestEnum.class, TestEnum.ONE));
	}
	
	@Test
	public void testParse() {
		assertEquals(TestEnum.TWO, FormatterUtil.parse(TestEnum.class, "TWO"));
	}
}
