package com.ganzux.paintshoppro.pojo;

import java.util.ArrayList;
import java.util.Collection;

public class Customer implements Comparable<Customer>{

	/**
	 * You have a number of customers, and each have some colors they like,
	 * either gloss or matte.
	 */
	private Collection<Color> favouriteColors;
	
	public Customer() {
		favouriteColors = new ArrayList<Color>();
	}

	/**
	 * No customer will like more than one color in matte.
	 * @param color
	 * @return
	 */
	public boolean addFavouriteColor(Color color){
		if (color instanceof Matte){
			if (doIAlreadyHaveMate()){
				return false;
			}
		}
		favouriteColors.add(color);
		return true;
	}
	
	public Collection<Color> getFavouriteColors(){
		return favouriteColors;
	}

	private boolean doIAlreadyHaveMate(){
		for (Color c : favouriteColors){
			if (c instanceof Matte){
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Customer o) {
		if (favouriteColors.size() > o.getFavouriteColors().size()){
			return 1;
		} else if (favouriteColors.size() < o.getFavouriteColors().size()){
			return -1;
		}
		return 0;
	}

}
