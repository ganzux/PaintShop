package com.ganzux.paintshoppro.pojo;

/**
 * Class for Matte Colors
 * @author ganzux Alvaro Alcedo Moreno
 */
public class Matte extends Color{

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////

	@Override
	public String toString(){
		return getName() + MATTE_LBL;
	}

	@Override
	public String getCode() {
		return MATTE_LBL;
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
