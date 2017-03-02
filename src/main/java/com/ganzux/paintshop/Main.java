package com.ganzux.paintshop;

import java.util.List;

import com.ganzux.paintshop.file.FileUtils;
import com.ganzux.paintshop.pojo.Customer;

public class Main {

	public static void main(String[] args) throws Exception {
		List<Customer> customers = FileUtils.readFile(args[0]);
	}
	
	/**
	 * You want to mix the colors, so that:
	 * There is just one batch for each color, and it's either gloss or matte.
	 * For each customer, there is at least one color they like.
	 * You make as few mattes as possible (because they are more expensive).
	 */
	private static void mix(){
		
	}

}
