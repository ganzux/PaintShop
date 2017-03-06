package com.ganzux.paintshoppro;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class AppTest extends TestCase {

	///////////////////////////////////////////////////////////////
	//                        Attributes                         //
	///////////////////////////////////////////////////////////////
	private final ClassLoader classLoader = getClass().getClassLoader();
	private final String validFolder = "files" + File.separator + "valid" + File.separator;
	private final String invalidFolder = "files" + File.separator + "invalid" + File.separator;
	///////////////////////////////////////////////////////////////
	//                        /Attributes                        //
	///////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////////////////
	//                           Tests                           //
	///////////////////////////////////////////////////////////////
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
	public void testInValid5Colors3Customers() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "1_color.2_customers.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "No solution exists");
		}
		
		
	}
	
	@Test
	public void testInValid5Colors3CustomersMjultipleMM() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "5_colors.3_customers.MM.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "It is not possible, sorry!");
		}
		
		
	}
	
	@Test
	public void testInValidFile() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "I_dont_exist.gilt").toURI());
		} catch(Exception e){
			assertEquals(e.getMessage(), null);
		}

	}
	
	@Test
	public void testInvalidNotSpecializedPaint() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "no_gloss_or_matte.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "The Color MUST be either Matte or Gloss");
		}
	}
	
	@Test
	public void testInvalidIncorrectNumberOfColorsLess() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "incorrect_colors_less.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "The number of colors doesn't match with the specified with the Customers");
		}
		
	}
	
	@Test
	public void testInvalidIncorrectNumberOfColorsMore() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "incorrect_colors_more.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "The number of colors doesn't match with the specified with the Customers");
		}
		
	}

	@Test
	public void testInvalidIncorrectNumberOfColorsChar() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "incorrect_colors_no_number.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			assertEquals(e.getMessage(), "First line should be a number!");
		}
		
	}
	
	@Test
	public void testInvalidIncorrectNumber() {

		try{
			File file = new File(classLoader.getResource(invalidFolder + "letter_instead_of_number.gilt").toURI());
			String result = Main.main(file.getAbsolutePath());
		} catch(Exception e){
			Assert.assertTrue(e.getMessage().contains("There is an error in the Color specification, "));
		}
		
	}
	///////////////////////////////////////////////////////////////
	//                          /Tests                           //
	///////////////////////////////////////////////////////////////
}
