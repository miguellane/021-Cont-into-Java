package io;

import java.util.ArrayList;

public class IORunner {

	
	public static void main(String[] args) {
		// edit as necessary
		//testPeople();
		People p = new People();
		ArrayList<Person> p5 = p.readFile();
		p.printPeople(p5);
		
	}
	

	
	
	public static void testPeople() {
		// fill in as necessary		
	}
	
	

	
	
}
