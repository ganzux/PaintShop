package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.Color;
import com.ganzux.paintshoppro.pojo.IColor;

/**
 * Public class with the rules to use the factories depending on the color
 * type, so if we are using Color.MATTE_LBL, we will return a MatteFactory
 * and if we are using Color.GLOSS_LBL it will be GlossFactory.
 * @author ganzux Alvaro Alcedo Moreno
 */
public class ColorFactory {

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	public static IColor createColor(String colorType) throws Exception{
		
		AbstractColorFactory myFactory = null;
		
		if (Color.MATTE_LBL.equalsIgnoreCase(colorType)){
			myFactory = new MatteFactory();
		} else if (Color.GLOSS_LBL.equalsIgnoreCase(colorType)){
			myFactory = new GlossFactory();
		} else {
			throw new Exception("The Color MUST be either Matte or Gloss");
		}

		return myFactory.createColor();
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////
}
