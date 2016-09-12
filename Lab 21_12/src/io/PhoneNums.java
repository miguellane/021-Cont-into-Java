package io;

import java.util.*;
import java.io.*;

public class PhoneNums {

	public static ArrayList<String> readPhoneNumbers() {

		String filename = "data/phone.txt"; 
		ArrayList<String> output = new ArrayList<String>();

		try {
			Scanner input = new Scanner ( new FileReader(filename) );

			while (input.hasNextLine()) {
				Scanner a = new Scanner(input.nextLine());
				a.useDelimiter("[+ -]");
				String cc = a.next();
				String area = a.next();
				String pn = a.next();
				System.out.println("Country Code: " + cc);
				System.out.println("Area Code: " + area);
				System.out.println("Phone number: " + pn);
//				System.out.println(input.nextLine()); // Comment this line out
				if(a.hasNext()){
					System.out.print(a.next());
				}
				System.out.println();
			}
			input.close();
		} catch ( NoSuchElementException e){
			System.out.println(e);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
		
		return output;
	}
	
	public static void main(String[] args){
		readPhoneNumbers();
	}
	

}
