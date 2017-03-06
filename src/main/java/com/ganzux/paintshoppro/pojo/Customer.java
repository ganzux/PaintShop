package com.ganzux.paintshoppro.pojo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Class for the Customer, with a Collection of favorite Colors. What it
 * is important in this class it is that it manages itself the business
 * rule about having just once Matte Color, returning false and not adding
 * it if we are trying to add more than one and also we are implementing
 * the Natural comparison with another Customer, so it will be done by
 * the amount of Favorite colors.
 * @author ganzux Alvaro Alcedo Moreno
 */
public class Customer implements Comparable<Customer>{
	
	///////////////////////////////////////////////////////////////
	//                        Attributes                         //
	///////////////////////////////////////////////////////////////

	/**
	 * You have a number of customers, and each have some colors they like,
	 * either gloss or matte.
	 */
	private Collection<IColor> favouriteColors;
	///////////////////////////////////////////////////////////////
	//                        /Attributes                        //
	///////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	public Customer() {
		favouriteColors = new ArrayList<IColor>();
	}

	/**
	 * No customer will like more than one color in matte.
	 * @param color
	 * @return
	 */
	public boolean addFavouriteColor(IColor color){
		if (color instanceof Matte){
			if (doIAlreadyHaveMate()){
				return false;
			}
		}
		favouriteColors.add(color);
		return true;
	}
	
	public Collection<IColor> getFavouriteColors(){
		return favouriteColors;
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
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////////////////
	//                      Private Methods                      //
	///////////////////////////////////////////////////////////////
	private boolean doIAlreadyHaveMate(){
		for (IColor c : favouriteColors){
			if (c instanceof Matte){
				return true;
			}
		}
		return false;
	}
	///////////////////////////////////////////////////////////////
	//                     /Private Methods                      //
	///////////////////////////////////////////////////////////////

}
