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

public class IntegerFormatterTest {
	
	@Test
	public void testFormat() {
		NumberFormat numberFormat = DecimalFormat.getIntegerInstance();
		assertEquals(numberFormat.format(Integer.MAX_VALUE), FormatterUtil.format(Integer.class, Integer.MAX_VALUE));
		assertEquals(numberFormat.format(Integer.MIN_VALUE), FormatterUtil.format(int.class, Integer.MIN_VALUE));
	}
	
	@Test
	public void testFormatWithPattern() {
		NumberFormat numberFormat = new DecimalFormat("0000000");
		numberFormat.setParseIntegerOnly(true);
		assertEquals(numberFormat.format(123), FormatterUtil.format(Integer.class, 123, Format.config().withPattern("0000000")));
	}
	
	@Test
	public void testFormatWithSeparators() {
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setGroupingSeparator('.');
		NumberFormat numberFormat = new DecimalFormat("###,###", ds);
		assertEquals(numberFormat.format(Integer.MAX_VALUE), FormatterUtil.format(Integer.class, Integer.MAX_VALUE, Format.config().withPattern("###,###").withGroupingSeparator('.')));
	}
	
	@Test
	public void testParse() {
		NumberFormat numberFormat = DecimalFormat.getInstance();
		numberFormat.setParseIntegerOnly(true);
		String src = numberFormat.format(123456);
		try {
			assertTrue(numberFormat.parse(src).intValue() == FormatterUtil.parse(Integer.class, src));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithPattern() {
		NumberFormat numberFormat = new DecimalFormat("0000000");
		numberFormat.setParseIntegerOnly(true);
		String src = numberFormat.format(123456);
		try {
			assertTrue(numberFormat.parse(src).intValue() == FormatterUtil.parse(Integer.class, src, Format.config().withPattern("0000000")));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithSeparators() {
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setGroupingSeparator('.');
		NumberFormat numberFormat = new DecimalFormat("###,###", ds);
		String src = numberFormat.format(123456);
		try {
			assertTrue(numberFormat.parse(src).intValue() == FormatterUtil.parse(Integer.class, src, Format.config().withPattern("###,###").withGroupingSeparator('.')));
		} catch (ParseException e) {
			fail();
		}
	}
}
