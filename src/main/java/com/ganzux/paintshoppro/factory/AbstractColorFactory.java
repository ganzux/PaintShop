package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.IColor;

/**
 * Interface defining the methods that the Factories must create.
 * @author ganzux Alvaro Alcedo Moreno
 */
public interface AbstractColorFactory {

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	public IColor createColor();
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
