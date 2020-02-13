import java.security.SecureRandom;
import java.util.Scanner;

//This program produces two random single digit integers, 
//asks a multiplication problem,
//if the answer is correct, print message then terminate,
//if incorrect, continuously prompt with message
public class CAI1 {
	private static SecureRandom numgen = new SecureRandom();
	private static Scanner in = new Scanner(System.in);
	private static int correctAnswer;
	
	public static void quiz() {
		//create two random integers
		int num1 = numgen.nextInt(10);
		int num2 = numgen.nextInt(10);
		//calculates the correct answer and stores it
		correctAnswer = num1*num2;
		
		//begins the quizzing process
		askQuestion(num1, num2);
		//checks if the answer is correct, if not,
		//continuously prompts incorrect response until it is correct
		while(!isAnswerCorrect()) {
			displayIncorrectResponse();
		}
		displayCorrectResponse();
		in.close();
	}
	
	//given the numbers generated, asks the question
	private static void askQuestion(int num1, int num2) {
		System.out.printf("How much is %d times %d?%n", num1, num2);
	}
	
	//scans in answer, checks it versus correct answer generated in quiz method
	public static boolean isAnswerCorrect() {
		int ans = in.nextInt();
		return (ans == correctAnswer);
	}
	
	public static void displayCorrectResponse() {
		System.out.println("Very good!");
	}
	 
	public static void displayIncorrectResponse() {
		System.out.println("No. Please try again.");
	}
	 
	public static void main(String[] args) {
		quiz();
	}
}