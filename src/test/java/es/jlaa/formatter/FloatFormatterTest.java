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

public class FloatFormatterTest {
	@Test
	public void testFormat() {
		NumberFormat numberFormat = DecimalFormat.getInstance();
		assertEquals(numberFormat.format(Float.MAX_VALUE), FormatterUtil.format(Float.class, Float.MAX_VALUE));
		assertEquals(numberFormat.format(Float.MIN_VALUE), FormatterUtil.format(float.class, Float.MIN_VALUE));
	}
	
	@Test
	public void testFormatWithPattern() {
		NumberFormat numberFormat = new DecimalFormat("######.00");
		assertEquals(numberFormat.format(Float.MAX_VALUE), FormatterUtil.format(Float.class, Float.MAX_VALUE, Format.config().withPattern("######.00")));
		assertEquals(numberFormat.format(Float.MIN_VALUE), FormatterUtil.format(float.class, Float.MIN_VALUE, Format.config().withPattern("######.00")));
	}
	
	@Test
	public void testFormatWithSeparators() {
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setDecimalSeparator('\'');
		ds.setGroupingSeparator('.');
		NumberFormat numberFormat = new DecimalFormat("###,###.00", ds);
		assertEquals(numberFormat.format(Float.MAX_VALUE), FormatterUtil.format(Float.class, Float.MAX_VALUE, Format.config().withPattern("###,###.00").withNumberSeparators('\'', '.')));
		assertEquals(numberFormat.format(Float.MIN_VALUE), FormatterUtil.format(float.class, Float.MIN_VALUE, Format.config().withPattern("###,###.00").withNumberSeparators('\'', '.')));
	}
	
	@Test
	public void testParse() {
		NumberFormat numberFormat = DecimalFormat.getInstance();
		String src = numberFormat.format(123456.567);
		try {
			assertTrue(numberFormat.parse(src).floatValue() == FormatterUtil.parse(Float.class, src));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithPattern() {
		NumberFormat numberFormat = new DecimalFormat("######.00");
		String src = numberFormat.format(123456.567);
		try {
			assertTrue(numberFormat.parse(src).floatValue() == FormatterUtil.parse(Float.class, src, Format.config().withPattern("######.00")));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithSeparators() {
		DecimalFormatSymbols ds = new DecimalFormatSymbols();
		ds.setDecimalSeparator('\'');
		ds.setGroupingSeparator('.');
		NumberFormat numberFormat = new DecimalFormat("###,###.00", ds);
		String src = numberFormat.format(123456.567);
		try {
			assertTrue(numberFormat.parse(src).floatValue() == FormatterUtil.parse(Float.class, src, Format.config().withPattern("###,###.00").withNumberSeparators('\'', '.')));
		} catch (ParseException e) {
			fail();
		}
	}
}
