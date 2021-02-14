package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.jlaa.formatter.config.Format;
import es.jlaa.formatter.utils.FormatterUtil;

public class ByteFormatterTest {
	
	@Test
	public void testFormat() {
		assertEquals("127", FormatterUtil.format(Byte.class, Byte.MAX_VALUE));
		assertEquals("-128", FormatterUtil.format(byte.class, Byte.MIN_VALUE));
	}
	
	@Test
	public void testFormatWithPattern() {
		assertEquals("007", FormatterUtil.format(Byte.class,(byte) 7, Format.config().withPattern("000")));
		assertEquals("-08", FormatterUtil.format(byte.class, (byte) -8, Format.config().withPattern("00")));
	}
	
	@Test
	public void testParse() {
		assertTrue((byte) Byte.MAX_VALUE == FormatterUtil.parse(Byte.class, "127"));
		assertTrue((byte) Byte.MIN_VALUE == FormatterUtil.parse(Byte.class, "-128"));
	}
	
	@Test
	public void testParseWithPattern() {
		assertTrue((byte) 7 == FormatterUtil.parse(Byte.class, "007", Format.config().withPattern("000")));
		assertTrue((byte) -8 == FormatterUtil.parse(Byte.class, "-08", Format.config().withPattern("00")));
	}
}
