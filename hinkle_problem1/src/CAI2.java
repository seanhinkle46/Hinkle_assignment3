import java.security.SecureRandom;
import java.util.Scanner;

//This program produces two random single digit integers, 
//asks a multiplication problem,
//if the answer is correct, print message then terminate,
//if incorrect, continuously prompt with message
public class CAI2 {
	private static SecureRandom numgen = new SecureRandom();
	private static Scanner in = new Scanner(System.in);
	private static int studentAnswer;
	private static int correctAnswer;
	
	public static void quiz() {
		//create two random integers
		int num1 = numgen.nextInt(10);
		int num2 = numgen.nextInt(10);
		//calculates the correct answer and stores it
		correctAnswer = num1*num2;
		
		//begins the quizzing process
		askQuestion(num1, num2);
		readResponse();
		//checks if the answer is correct, if not,
		//continuously asks until response is correct
		while(!isAnswerCorrect()) {
			displayIncorrectResponse();
			askQuestion(num1, num2);
			readResponse();
		}
		displayCorrectResponse();
		in.close();
	}
	
	//given the numbers generated, asks the question
	private static void askQuestion(int num1, int num2) {
		System.out.printf("How much is %d times %d?%n", num1, num2);
	}
	
	private static void readResponse() {
		studentAnswer = in.nextInt();
	}
	
	//checks student answer versus correct answer generated in quiz method
	public static boolean isAnswerCorrect() {
		return (studentAnswer == correctAnswer);
	}
	
	//prints one of four correct response messages randomly
	public static void displayCorrectResponse() {
		int rand = numgen.nextInt(4) + 1;
		switch (rand) {
		case 1:
			System.out.println("Very good!");
			break;
		case 2:
			System.out.println("Excellent!");
			break;
		case 3:
			System.out.println("Nice work!");
			break;
		case 4:
			System.out.println("Keep up the good work!");
		}
	}
	
	//prints one of four incorrect response messages randomly
	public static void displayIncorrectResponse() {
		int rand = numgen.nextInt(4) + 1;
		switch (rand) {
		case 1:
			System.out.println("No. Please try again.");
			break;
		case 2:
			System.out.println("Wrong. Try once more.");
			break;
		case 3:
			System.out.println("Don't give up!");
			break;
		case 4:
			System.out.println("No. Keep trying.");
		}
	}
	 
	public static void main(String[] args) {
		quiz();
	}
}