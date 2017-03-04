package com.ganzux.paintshoppro.factory;

import com.ganzux.paintshoppro.pojo.Color;
import com.ganzux.paintshoppro.pojo.Gloss;

public class GlossFactory implements AbstractColorFactory{

	@Override
	public Color createColor() {
		return new Gloss();
	}

}
