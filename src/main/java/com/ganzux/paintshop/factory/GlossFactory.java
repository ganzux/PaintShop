package com.ganzux.paintshop.factory;

import com.ganzux.paintshop.pojo.Color;
import com.ganzux.paintshop.pojo.Gloss;

public class GlossFactory implements AbstractColorFactory{

	@Override
	public Color createColor() {
		return new Gloss();
	}

}
