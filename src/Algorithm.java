import java.util.Scanner;

public class Algorithm {

	Scanner scanner = null;
	int[] algorithmArray = {2,3,4,5,6,7};
	
	public Algorithm(Scanner scanner) {
		this.scanner = scanner;
	}

	public void process(String accountNumber) {
		if (accountNumber.length() < 2){
			errorHandle("ERROR: Not enough digits. Can not process.");
		}
		
		System.out.println("");
		System.out.println("processing account number: " + accountNumber);
		System.out.println("");
		
		int numbersLength = accountNumber.length();
		int controlDigit = Integer.parseInt(accountNumber.substring(numbersLength - 1));
		System.out.println("expecting control digit: " + controlDigit);
		
		int[] digits = accountNumber
				.substring(0, numbersLength - 2)
				.chars()
				.map(i -> Character.getNumericValue(i)).toArray();
		
		int algStartPnt = numbersLength - 2;
		int sum = 0;
		for(int x = 0;x<digits.length;x++){
			sum += digits[x] * algorithmArray[algStartPnt % 6];
			algStartPnt--;
		}
		
		int calculatedCtrlDigit = 11 - (sum % 11);
		
		if(calculatedCtrlDigit == 11){
			calculatedCtrlDigit = 0;
		}
		
		if(calculatedCtrlDigit == 10){
			System.out.println("calculated control digit: - ");
			System.out.println("");
			System.out.println("The account number is not valid because it has no possible control digit.");
		}
		else if (calculatedCtrlDigit == controlDigit){
			System.out.println("calculated control digit: " + calculatedCtrlDigit);
			System.out.println("");
			System.out.println("The account number is valid.");
		}
		else if (calculatedCtrlDigit != controlDigit){
			System.out.println("calculated control digit: " + calculatedCtrlDigit);
			System.out.println("");
			System.out.println("The account number is not valid.");
		}		

	}

	private void errorHandle(String message) {
		this.scanner.close();
		System.out.println(message);
		System.exit(1);
	}

}

