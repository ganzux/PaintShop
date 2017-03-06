package com.ganzux.paintshoppro;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.ganzux.paintshoppro.file.FileUtils;
import com.ganzux.paintshoppro.pojo.IColor;
import com.ganzux.paintshoppro.pojo.Color;
import com.ganzux.paintshoppro.pojo.Customer;

public class Main {

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////
	public static String main(String path) throws Exception, IOException, FileNotFoundException, NumberFormatException {
		
		Object[] fileData = FileUtils.readFile(path);
		
		int numberOfColors = (int) fileData[0];
		List<Customer> customers = (List<Customer>) fileData[1];

		return mix(numberOfColors, customers);
	}
	
	public static void main(String[] args){
		try {
			System.out.println(main(args[0]));
		} catch (NumberFormatException e) {
			System.err.println("Error with the file, check it please. " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("File not found, check it please. " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error reading the file, check it please. " + e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////////////////
	//                      Private Methods                      //
	///////////////////////////////////////////////////////////////
	/**
	 * You want to mix the colors, so that:
	 * There is just one batch for each color, and it's either gloss or matte.
	 * For each customer, there is at least one color they like.
	 * You make as few mattes as possible (because they are more expensive).
	 * @throws Exception 
	 */
	private static String mix(int numberOfColors, List<Customer> customers) throws Exception{
		String[] colorTypes = new String[numberOfColors];
		
		String[][] colorMatrix = generateColorMatrix(numberOfColors, customers);
		
		// At this point the matrix is sorted, with those customers with 1 favorite
		// color at the beginning. Those customers with just 1 color are mandatories
		for (String[] line : colorMatrix){

			if (isOneValue(line)){
				for (int idx = 0 ; idx < line.length ; idx++){
					String value = line[idx];
					if (null != value){
						if (colorTypes[idx] == null){
							colorTypes[idx] = value;
						} else if (colorTypes[idx] != value){
							throw new Exception("No solution exists");
						}
					}
				}
			}

			// There is more than 1 color for the customer
			else {
				manageConflicts(line, colorTypes);

				for (int idx = 0 ; idx < line.length ; idx++){
					String value = line[idx];
					if (null != value){
						if (colorTypes[idx] == null){
							colorTypes[idx] = value;
						} else if (colorTypes[idx] != value){
							throw new Exception("It is not possible, sorry!");
						}
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String s : colorTypes){
			sb.append(s).append(" ");
		}
		
		// remove the last white space
		return sb.substring(0, sb.length() - 1);
	}
	
	private static String[][] generateColorMatrix(int numberOfColors, List<Customer> customers){
		String[][] matrix = new String[customers.size()][numberOfColors];
		
		int customerId = 0;
		
		Collections.sort(customers);
		
		for (Customer customer : customers){
			
			Collection<IColor> customerColors = customer.getFavouriteColors();

			boolean thereIsGloss = false;
			for (IColor color : customerColors){
				int colorNumer = Integer.valueOf(color.getName());
				matrix[customerId][colorNumer - 1] = color.getCode();
				if (Color.GLOSS_LBL == color.getCode()){
					thereIsGloss = true;
				}
			}
			
			// If the Customer is going to mix any color with one that is Gloss,
			// we can put all of them as gloss; this comes from the first example
			// provided, 1M 3G 5G - 2G 3M 4G - 5M = G G G G M
//			if (thereIsGloss){
//				for (Color color : customerColors){
//					int colorNumer = Integer.valueOf(color.getName());
//					matrix[customerId][colorNumer - 1] = Color.GLOSS_LBL;
//				}
//			}

			customerId++;
			}
		return matrix;
	}
	
	private static boolean isOneValue(String[] line){
		int values = 0;
		
		for (String value : line){
			if (null != value){
				values++;
			}
			if (values > 1){
				return false;
			}
		}
		
		return true;
	}

	/**
	 * Method that changes all the Mattes To Gloss if there are not in a certainly position.
	 * This is because every Customer is allowed to have just 1 favorite Matte color.
	 * @param line
	 * @param positionExcluded
	 * @return true if we changed something
	 */
	private static boolean changeMates(String[] line, int positionExcluded){
		
		boolean change = false;

		for (int i = 0 ; i < line.length ; i++){
			if (i != positionExcluded){
				String value = line[i];
				if (null != value && Color.MATTE_LBL.equalsIgnoreCase(value)){
					line[i] = Color.GLOSS_LBL;
					change = true;
				}
			}
		}
		
		return change;
	}

	private static void manageConflicts(String[] line, String[] solution){
	
		for (int i = 0 ; i < line.length ; i++){
			if (line[i] != null && solution[i] != null && solution[i] != line[i]){
				if (solution[i] == Color.MATTE_LBL){
					line[i] = Color.MATTE_LBL;
					changeMates(line, i);
				}
				
				else {
					line[i] = Color.GLOSS_LBL;
				}
			}
		}

	}
	///////////////////////////////////////////////////////////////
	//                     /Private Methods                      //
	///////////////////////////////////////////////////////////////

}
