package com.ganzux.paintshoppro;

import java.io.File;

import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {

	ClassLoader classLoader = getClass().getClassLoader();
	String validFolder = "files" + File.separator + "valid" + File.separator;
	String invalidFolder = "files" + File.separator + "invalid" + File.separator;

	@Test
	public void testValid5Colors3Customers() throws Exception {

		File file = new File(classLoader.getResource(validFolder + "5_colors.3_customers.gilt").toURI());
		String result = Main.main(file.getAbsolutePath());
		
		assertEquals("G G G G M", "G G G G M");
	}
}
