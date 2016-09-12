package oop;


public class ModNCounter2  extends Counter { 


    private int cycleLength; 
    
    public ModNCounter2 (int n) { 
    	cycleLength = n; 
    }  

    
    public int value ( ) { 
    	if(myCount == cycleLength)
    		return 0;
    	return myCount;
    } 
} 