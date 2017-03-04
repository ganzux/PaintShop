package com.ganzux.paintshoppro;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.ganzux.paintshoppro.file.FileUtils;
import com.ganzux.paintshoppro.pojo.Color;
import com.ganzux.paintshoppro.pojo.Customer;

public class Main {

	public static String main(String path) throws Exception {
		
		Object[] fileData = FileUtils.readFile(path);
		
		int numberOfColors = (int) fileData[0];
		List<Customer> customers = (List<Customer>) fileData[1];

		return mix(numberOfColors, customers);
	}
	
	/**
	 * You want to mix the colors, so that:
	 * There is just one batch for each color, and it's either gloss or matte.
	 * For each customer, there is at least one color they like.
	 * You make as few mattes as possible (because they are more expensive).
	 */
	private static String mix(int numberOfColors, List<Customer> customers){
		String[] colorTypes = new String[numberOfColors];
		
		String[][] colorMatrix = generateColorMatrix(numberOfColors, customers);
		
		
		
		return colorTypes.toString();
	}
	
	private static String[][] generateColorMatrix(int numberOfColors, List<Customer> customers){
		String[][] matrix = new String[customers.size()][numberOfColors];
		
		int customerId = 0;
		
		Collections.sort(customers);
		
		for (Customer customer : customers){
			
			Collection<Color> customerColors = customer.getFavouriteColors();

			boolean thereIsGloss = false;
			for (Color color : customerColors){
				int colorNumer = Integer.valueOf(color.getName());
				matrix[customerId][colorNumer - 1] = color.getCode();
				if (Color.GLOSS_LBL == color.getCode()){
					thereIsGloss = true;
				}
			}
			
			// If the Customer is going to mix any color with one that is Gloss,
			// we can put all of them as gloss; this comes from the first example
			// provided, 1M 3G 5G - 2G 3M 4G - 5M = G G G G M
			if (thereIsGloss){
				for (Color color : customerColors){
					int colorNumer = Integer.valueOf(color.getName());
					matrix[customerId][colorNumer - 1] = Color.GLOSS_LBL;
				}
			}

			customerId++;
			}
		return matrix;
	}

}
