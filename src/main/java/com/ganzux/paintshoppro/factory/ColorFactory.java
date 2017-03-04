package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.Color;

public class ColorFactory {

	public static Color createColor(String colorType) throws Exception{
		
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

}
