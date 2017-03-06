package com.ganzux.paintshoppro.pojo;

/**
 * Interface IColor defining the methods that we need for every color, like the name,
 * the code and also the method toString for logging and debugging purposes
 * You run a paint shop, and there are a few different colors of paint you can prepare.
 * Each color can be either "gloss" or "matte".
 * @author ganzux Alvaro Alcedo Moreno
 */
public interface IColor {
	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	public void setName(String text);
	public String toString();

	public String getCode();
	public String getName();
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
