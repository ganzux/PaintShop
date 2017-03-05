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
		
		assertEquals(result, "G G G G M");
	}
	
	@Test
	public void testValid5Colors14Customers() throws Exception {

		File file = new File(classLoader.getResource(validFolder + "5_colors.14_customers.gilt").toURI());
		String result = Main.main(file.getAbsolutePath());
		
		assertEquals(result, "G M G M G");
	}
	
	@Test
	public void testValid2Colors2Customers() throws Exception {

		File file = new File(classLoader.getResource(validFolder + "2_colors.2_customers.gilt").toURI());
		String result = Main.main(file.getAbsolutePath());
		
		assertEquals(result, "M G");
	}
	
	@Test
	public void testValid9Colors10Customers() throws Exception {

		File file = new File(classLoader.getResource(validFolder + "9_colors.10_customers.gilt").toURI());
		String result = Main.main(file.getAbsolutePath());
		
		assertEquals(result, "G M G M G G M M G");
	}
	
	
	
	
	@Test
	public void testInValid5Colors3Customers() throws Exception {

		File file = new File(classLoader.getResource(invalidFolder + "1_color.2_customers.gilt").toURI());
		try{
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "No solution exists");
		}
		
		
	}
	
	@Test
	public void testInValid5Colors3CustomersMjultipleMM() throws Exception {

		File file = new File(classLoader.getResource(invalidFolder + "5_colors.3_customers.MM.gilt").toURI());
		try{
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "It is not possible, sorry!");
		}
		
		
	}
	
	
	
	
	
}
