package com.ganzux.paintshoppro.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ganzux.paintshoppro.factory.ColorFactory;
import com.ganzux.paintshoppro.pojo.Color;
import com.ganzux.paintshoppro.pojo.Customer;

/**
 * Your program should accept an input file as a command line argument,
 * and print a result to standard out.  An example input file is:
		5
		1 M 3 G 5 G
		2 G 3 M 4 G
		5 M
 *
 */
public abstract class FileUtils {

	public static Object[] readFile(File file) throws Exception{
		int colorNumbers = 0;
		int numOFCustomers = 0;
		List<Customer> customers = new ArrayList<Customer>();
		
		try {

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
					customers.add(readPairs(line));
				}
				numOFCustomers ++;
			}
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return new Object[]{colorNumbers ,customers};
	}
	
	public static Object[] readFile(String path) throws Exception{
		File file = new File(path);
		return readFile(file);
	}
	
	private static Customer readPairs(String str) throws Exception{

		Customer customer = new Customer();

		// all the data has a space
		String[] data = str.split(" ");
		
		for (int i = 0 ; i < data.length ; i += 2){
			String colorNumber = data[i];
			String colorType   = data[i + 1];

			Color myColor = ColorFactory.createColor(colorType);
			myColor.setName(colorNumber);
			customer.addFavouriteColor(myColor);
		}
		
		return customer;
	}

}
