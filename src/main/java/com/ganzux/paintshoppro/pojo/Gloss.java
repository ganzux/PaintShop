package com.ganzux.paintshoppro.pojo;

/**
 * Class for Gloss Colors
 * @author ganzux Alvaro Alcedo Moreno
 */
public class Gloss extends Color {

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////

	@Override
	public String toString(){
		return getName() + GLOSS_LBL;
	}

	@Override
	public String getCode() {
		return GLOSS_LBL;
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
