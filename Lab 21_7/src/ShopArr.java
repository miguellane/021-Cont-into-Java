import java.util.*;

public class ShopArr {

	private Cheese[] cheese;
	private void init(int max) {
		cheese = new Cheese[max]; 
		
		if (max > 0) {
			cheese[0] = new Cheese();
			cheese[0].setName("Dalaran Sharp");
			cheese[0].setPrice(1.25);
		}
		if (max > 1) {
			cheese[1] = new Cheese("Stormwind Brie");
			cheese[1].setPrice(10.00);
		}
		if (max > 2) {
			cheese[2] = new Cheese("Alterac Swiss", 40.00);
		}
		Random ranGen = new Random(100);

		for (int i = 3; i < max; i++) {
			cheese[i] = new Cheese("Cheese Type " + (char)('A'+i) , ranGen.nextInt(1000)/100.0);
		}
	}
	public ShopArr() {
		init(10);
	}
	public ShopArr(int max) {
		init(max);
	}
	private void intro(Scanner input) {
		System.out.println("We sell " + cheese.length + " types of Cheese");

		for (int i = 0; i < cheese.length; i++) {
			System.out.println(cheese[i].getName() + ": $" + cheese[i].getPrice() + " per pound");
		}
		for (int i = 0; i < cheese.length; i++) {
			System.out.print("Enter amount of " + cheese[i].getName() + " : ");
			cheese[i].setAmount(input.nextInt());
		}
	}
	private double calcSubTotal() {
		double amount = 0;
		for (int i = 0; i < cheese.length; i++) {
			amount += cheese[i].getAmount() * cheese[i].getPrice();
		}
		
		return amount;
	}
	private double discount(double sub) {
		return ((sub > 100)? 25 : (sub > 50)? 10: 0);
	}
	private void itemizedList(){
		int amt;
		System.out.println();
		for (int i = 0; i < cheese.length; i++) {
			if ((amt = cheese[i].getAmount()) > 0) 
				System.out.println(amt + " lbs of "+ cheese[i].getName()+ " @ $"+ cheese[i].getPrice()+ "  = " + (amt * cheese[i].getPrice()));
		}
	}
	private void printTotal(double sub, double disc) {
		System.out.println();
		System.out.println("Sub Total  : $" + sub);
		System.out.println("- Discount : $"+ disc);
		System.out.println("Total Price: $" + (sub - disc));
	}
	private void printFree(){
		int amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		for (int i = 0; i < cheese.length; i++) 		
			if ((amt = cheese[i].getAmount()) > 0)
				System.out.println(amt + " lbs of " + cheese[i].getName() + " @ $0 = " + 0);
		System.out.println("Total Price: FREE");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double sub = calcSubTotal();
		double disAmt = discount(sub);

		System.out.println();
		System.out.print("Do you want to see the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		//System.out.println("Random num is "+ free);
		if (free != 0)
			printTotal(sub, disAmt);
		else {
			printFree();
			return ;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
	}
}
