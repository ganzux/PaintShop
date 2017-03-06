package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.IColor;
import com.ganzux.paintshoppro.pojo.Gloss;

/**
 * Gloss Factory
 * @author ganzux Alvaro Alcedo Moreno
 */
public class GlossFactory implements AbstractColorFactory{

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	@Override
	public IColor createColor() {
		return new Gloss();
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
