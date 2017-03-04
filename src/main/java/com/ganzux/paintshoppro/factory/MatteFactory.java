package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.Color;
import com.ganzux.paintshoppro.pojo.Matte;

public class MatteFactory implements AbstractColorFactory{

	@Override
	public Color createColor() {
		return new Matte();
	}

}
