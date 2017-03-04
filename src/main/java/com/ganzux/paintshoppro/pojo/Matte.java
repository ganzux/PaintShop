package com.ganzux.paintshoppro.pojo;

public class Matte implements Color{

	private String name;
	
	public Matte() {
		super();
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name + MATTE_LBL;
	}

	@Override
	public String getCode() {
		return MATTE_LBL;
	}

	@Override
	public String getName() {
		return name;
	}

	
}
