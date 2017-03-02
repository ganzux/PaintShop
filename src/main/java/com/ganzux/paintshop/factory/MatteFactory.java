package com.ganzux.paintshop.factory;

import com.ganzux.paintshop.pojo.Color;
import com.ganzux.paintshop.pojo.Matte;

public class MatteFactory implements AbstractColorFactory{

	@Override
	public Color createColor() {
		return new Matte();
	}

}
