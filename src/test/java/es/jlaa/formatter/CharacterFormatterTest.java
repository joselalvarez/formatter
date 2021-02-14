package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.jlaa.formatter.utils.FormatterUtil;

public class CharacterFormatterTest {
	
	@Test
	public void testFormat() {
		assertEquals("A", FormatterUtil.format(Character.class, 'A'));
		assertEquals("B", FormatterUtil.format(char.class, 'B'));
	}
	
	@Test
	public void testParse() {
		assertTrue('A' == FormatterUtil.parse(Character.class, "A"));
		assertTrue('B' == FormatterUtil.parse(char.class, "B"));
	}
}
