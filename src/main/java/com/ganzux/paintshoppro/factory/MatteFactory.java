package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.IColor;
import com.ganzux.paintshoppro.pojo.Matte;

/**
 * Matte Factory
 * @author ganzux Alvaro Alcedo Moreno
 */
public class MatteFactory implements AbstractColorFactory{

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	@Override
	public IColor createColor() {
		return new Matte();
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
