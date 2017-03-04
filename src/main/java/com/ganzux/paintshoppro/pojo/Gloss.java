package com.ganzux.paintshoppro.pojo;

public class Gloss implements Color{
	
	private String name;

	public Gloss() {
		super();
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString(){
		return name + GLOSS_LBL;
	}
	
	@Override
	public String getCode() {
		return GLOSS_LBL;
	}

	@Override
	public String getName() {
		return name;
	}
}
