import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the desired length of the password: ");
		int length = scanner.nextInt();

		System.out.print("Enter the complexity level (1 for only numbers, 2 for numbers and letters,3 for numbers, letters, and symbols): ");
		int complexity = scanner.nextInt();

		String password = generatePassword(length, complexity);
		System.out.println("Generated Password: "+ password);


		scanner.close();
	}

	private static String generatePassword(int length,int complexity) {
		String numbers = "0123456789";
		String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNPQRSTUVWXYZ";
		String symbols = "!@#$%^&*()_-+=";

		StringBuilder validChars = new StringBuilder();
		validChars.append(numbers);

		if (complexity >= 2) {
			validChars.append(letters);
		}
		if (complexity ==3) {
			validChars.append(symbols);
		}

		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();

		for (int i = 0; i< length; i++) {
			int randomIndex = random.nextInt(validChars.length());
			password.append(validChars.charAt(randomIndex));
		}

		return password.toString();
	}
}
