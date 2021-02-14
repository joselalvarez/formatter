package es.jlaa.formatter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import es.jlaa.formatter.config.Format;
import es.jlaa.formatter.utils.FormatterUtil;

public class DateFormatterTest {

	@Test
	public void testFormat() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance();
		assertEquals(dateFormat.format(date), FormatterUtil.format(Date.class, date));
	}
	
	@Test
	public void testFormatDateTime() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		assertEquals(dateFormat.format(date), FormatterUtil.format(Date.class, date, Format.config().withDateAndTime()));
	}
	
	@Test
	public void testFormatTime() {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getTimeInstance();
		assertEquals(dateFormat.format(date), FormatterUtil.format(Date.class, date, Format.config().withOnlyTime()));
	}
	
	
	@Test
	public void testFormatWithPattern() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		assertEquals(dateFormat.format(date), FormatterUtil.format(Date.class, date, Format.config().withPattern("dd/MM/yyyy")));
	}
	
	@Test
	public void testFormatWithDateTimePattern() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		assertEquals(dateFormat.format(date), FormatterUtil.format(Date.class, date, Format.config().withPattern("dd/MM/yyyy hh:mm:ss")));
	}
	
	
	@Test
	public void testParse() {
		DateFormat dateFormat = DateFormat.getDateInstance();
		String src = dateFormat.format(new Date());
		try {
			assertEquals(dateFormat.parse(src), FormatterUtil.parse(Date.class, src));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseDateTime() {
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		String src = dateFormat.format(new Date());
		try {
			assertEquals(dateFormat.parse(src), FormatterUtil.parse(Date.class, src, Format.config().withDateAndTime()));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseTime() {
		DateFormat dateFormat = DateFormat.getTimeInstance();
		String src = dateFormat.format(new Date());
		try {
			assertEquals(dateFormat.parse(src), FormatterUtil.parse(Date.class, src, Format.config().withOnlyTime()));
		} catch (ParseException e) {
			fail();
		}
	}
	
	
	@Test
	public void testParseWithPattern() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String src = dateFormat.format(new Date());
		try {
			assertEquals(dateFormat.parse(src), FormatterUtil.parse(Date.class, src, Format.config().withPattern("dd/MM/yyyy")));
		} catch (ParseException e) {
			fail();
		}
	}
	
	@Test
	public void testParseWithDateTimePattern() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String src = dateFormat.format(new Date());
		try {
			assertEquals(dateFormat.parse(src), FormatterUtil.parse(Date.class, src, Format.config().withPattern("dd/MM/yyyy hh:mm:ss")));
		} catch (ParseException e) {
			fail();
		}
	}
	
}
