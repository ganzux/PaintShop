package com.ganzux.paintshoppro.pojo;

/**
 * You run a paint shop, and there are a few different colors of paint you can prepare.
 * Each color can be either "gloss" or "matte".
 * @throws Exception 
 */
public interface Color {
	
	public static final String MATTE_LBL = "M";
	public static final String GLOSS_LBL = "G";
	
	public void setName(String text);
	public String toString();

	public String getCode();
	public String getName();
}
