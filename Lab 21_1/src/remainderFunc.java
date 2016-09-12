import java.util.Scanner;
public class remainderFunc {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int max = 0, divisor = 0;
		
		System.out.print("Please enter the max number: ");
		max = input.nextInt();
		System.out.print("Please enter the divisor: ");
		divisor = input.nextInt();
		
		for(int i = 1; i <= max ;i++){
			System.out.println("Num: "+ i +" % "+ divisor +" = "+ (i % divisor));
		}
		
	}
}
