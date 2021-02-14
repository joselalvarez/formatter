package es.jlaa.formatter;

import static org.junit.Assert.fail;

import org.junit.Test;

import es.jlaa.formatter.utils.FormatterUtil;

public class NullSafeTest {
	
	@Test
	public void testNull() {
		try {
			FormatterUtil.format(Double.class, null);
			fail();
		}catch(Exception e) {}
	}
	
	@Test
	public void testNullSafe() {
		try {
			FormatterUtil.format(Double.class, null, "0");
		}catch(Exception e) {
			fail();
		}
	}
}
