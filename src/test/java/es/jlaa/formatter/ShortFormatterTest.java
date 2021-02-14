package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

import org.junit.Test;

import es.jlaa.formatter.config.Format;
import es.jlaa.formatter.utils.FormatterUtil;

public class ShortFormatterTest {
	@Test
	public void testFormat() {
		NumberFormat numberFormat = DecimalFormat.getIntegerInstance();
		assertEquals(numberFormat.format(Short.MAX_VALUE), FormatterUtil.format(Short.class, Short.MAX_VALUE));
		assertEquals(numberFormat.format(Short.MIN_VALUE), FormatterUtil.format(short.class, Short.MIN_VALUE));
	}
	
	@Test
	public void testFormatWithPattern() {
		NumberFormat numberFormat = new DecimalFormat("00000");
		numberFormat.setParseIntegerOnly(true);
		assertEquals(numberFormat.format(123), FormatterUtil.format(Short.class, (short) 123, Format.config().withPattern("00000")));
	}
	
	@Test
	public void testFormatWithSeparators() {
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setGroupingSeparator('.');
		NumberFormat numberFormat = new DecimalFormat("##,###", ds);
		assertEquals(numberFormat.format(Short.MAX_VALUE), FormatterUtil.format(Short.class, Short.MAX_VALUE, Format.config().withPattern("##,###").withGroupingSeparator('.')));
	}
	
	@Test
	public void testParse() {
		NumberFormat numberFormat = DecimalFormat.getInstance();
		numberFormat.setParseIntegerOnly(true);
		String src = numberFormat.format(29005);
		try {
			assertTrue(numberFormat.parse(src).shortValue() == FormatterUtil.parse(Short.class, src));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithPattern() {
		NumberFormat numberFormat = new DecimalFormat("00000");
		numberFormat.setParseIntegerOnly(true);
		String src = numberFormat.format(9005);
		try {
			assertTrue(numberFormat.parse(src).shortValue() == FormatterUtil.parse(Short.class, src, Format.config().withPattern("00000")));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithSeparators() {
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setGroupingSeparator('.');
		NumberFormat numberFormat = new DecimalFormat("##,###", ds);
		String src = numberFormat.format(29005);
		try {
			assertTrue(numberFormat.parse(src).shortValue() == FormatterUtil.parse(Short.class, src, Format.config().withPattern("##,###").withGroupingSeparator('.')));
		} catch (ParseException e) {
			fail();
		}
	}
}
