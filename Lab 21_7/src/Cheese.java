
public class Cheese {

	protected String name;
	protected double price;
	protected int amount;

	public static int numCheese = 0;
	
	public Cheese() {
		name = "";
		price = 0;
		amount = 0;
		numCheese++;
	}
	public Cheese(String name) {
		this.name = name;
		price = 0;
		amount = 0;
		numCheese++;
	}
	public Cheese(String name, double price) {
		this.name = name;
		this.price = price;
		amount = 0;
		numCheese++;
	}

	public String getName() {
		return name;
	}
	public void setName(String newName) {
		name = newName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double newPrice) {
		price = newPrice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int newAmount) {
		amount = newAmount;
	}
}
