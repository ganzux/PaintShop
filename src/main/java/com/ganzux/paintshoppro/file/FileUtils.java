package com.ganzux.paintshoppro.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ganzux.paintshoppro.factory.ColorFactory;
import com.ganzux.paintshoppro.pojo.Customer;
import com.ganzux.paintshoppro.pojo.IColor;

/**
 * Class to manage the Files and bind the data on a Customer Object.
 * @author ganzux Alvaro Alcedo Moreno
 *
 */
public abstract class FileUtils {

	///////////////////////////////////////////////////////////////
	//                       Public Methods                      //
	///////////////////////////////////////////////////////////////

	/**
	 * Method to convert the file into our Data Model Object
	 * @param file The file to read
	 * @return An Object with the first position as the number of colors
	 * and the second one with the Customer Objects
	 * @throws Exception The Exceptions to be managed
	 */
	public static Object[] readFile(File file) throws FileNotFoundException, IOException, Exception {

		int colorNumbers = 0;
		int numOFCustomers = 0;
		
		// SecurityCheck with the number of colors
		Map<String, String> colorsIncluded = new HashMap<String, String>();

		List<Customer> customers = new ArrayList<Customer>();

		FileReader fileReader = new FileReader(file);

		BufferedReader bufferedReader = new BufferedReader(fileReader);

		String line;
		
		while ((line = bufferedReader.readLine()) != null) {
			if (numOFCustomers == 0){
				try {
					colorNumbers = Integer.parseInt(line.trim());
				} catch(NumberFormatException nfe){
					throw new Exception("First line should be a number!", nfe);
				}
			}
			else {
				customers.add(readPairs(line, colorsIncluded));
			}
			numOFCustomers ++;
		}

		fileReader.close();
		
		if (colorNumbers != colorsIncluded.size()){
			throw new Exception("The number of colors doesn't match with the specified with the Customers");
		}
		
		return new Object[]{colorNumbers ,customers};
	}

	/**
	 * Works like {@link #readFile(File)}
	 */
	public static Object[] readFile(String path) throws Exception{
		File file = new File(path);
		return readFile(file);
	}
	///////////////////////////////////////////////////////////////
	//                      /Public Methods                      //
	///////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////////////////
	//                      Private Methods                      //
	///////////////////////////////////////////////////////////////
	private static Customer readPairs(String str, Map<String, String> colorsIncluded) throws Exception{

		Customer customer = new Customer();

		// all the data has a space
		String[] data = str.split(" ");
		
		for (int i = 0 ; i < data.length ; i += 2){
			String colorNumber = data[i];
			String colorType   = data[i + 1];
			
			colorsIncluded.put(colorNumber, colorNumber);

			IColor myColor = ColorFactory.createColor(colorType);
			myColor.setName(colorNumber);
			customer.addFavouriteColor(myColor);
		}
		
		return customer;
	}
	///////////////////////////////////////////////////////////////
	//                     /Private Methods                      //
	///////////////////////////////////////////////////////////////
}
