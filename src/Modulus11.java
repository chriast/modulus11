import java.util.Scanner;

public class Modulus11 {

	public static void main(String args[]) {
		System.out.println("");
		System.out.println("Modulus11 initiated");
		System.out.println("");
		System.out.println("Please type in something that contains at least 2 numbers");
		System.out.print(">");

		Scanner scanner = new Scanner(System.in);
		new Algorithm(scanner).process(scanner.nextLine().replaceAll("[^0-9]", ""));

		scanner.close();

	}

}
