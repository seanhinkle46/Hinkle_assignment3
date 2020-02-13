import java.security.SecureRandom;
import java.util.Scanner;

//This program produces two random single digit integers, 
//asks a multiplication problem,
//if the answer is correct, print message then terminate,
//if incorrect, continuously prompt with message
public class CAI3 {
	private static SecureRandom numgen = new SecureRandom();
	private static Scanner in = new Scanner(System.in);
	private static int studentAnswer;
	private static int correctAnswer;
	private static int numCorrect;
	
	//Runs the quiz by asking ten total questions, 
	//then asks if the user wants to repeat the process
	public static void quiz() {
		//reset numCorrect if this is a restart
		numCorrect = 0;
		for (int i = 0; i < 10; i++) {
			//create two random integers for each question
			int num1 = numgen.nextInt(10);
			int num2 = numgen.nextInt(10);
			//calculates the correct answer and stores it
			correctAnswer = num1*num2;
			
			//for each round, asks a question, checks response,
			//prints out the correct message
			askQuestion(num1, num2);
			readResponse();
			if (isAnswerCorrect()) {
				numCorrect++;
				displayCorrectResponse();
			} else {
				displayIncorrectResponse();
			}
		}
		displayCompletionMessage();
		System.out.printf("%nWould you like to solve a new problem set?" 
				+ " If so, enter 1, if no, enter 0%n");
		int status = in.nextInt();
		if (status == 1) {
			quiz();
		} else return;
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
			System.out.printf("Very good!%n%n");
			break;
		case 2:
			System.out.printf("Excellent!%n%n");
			break;
		case 3:
			System.out.printf("Nice work!%n%n");
			break;
		case 4:
			System.out.printf("Keep up the good work!%n%n");
		}
	}
	
	//prints one of four incorrect response messages randomly
	public static void displayIncorrectResponse() {
		int rand = numgen.nextInt(4) + 1;
		switch (rand) {
		case 1:
			System.out.printf("No. Please try again.%n%n");
			break;
		case 2:
			System.out.printf("Wrong. Try once more.%n%n");
			break;
		case 3:
			System.out.printf("Don't give up!%n%n");
			break;
		case 4:
			System.out.printf("No. Keep trying.%n%n");
		}
	}
	
	//based on the number correct, prints our percentage score
	//and a different message for those above and below 75%
	public static void displayCompletionMessage() {
		int percentage = numCorrect*10;
		System.out.println("Your total score is " + percentage + "%");
		if (numCorrect > 7) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		} else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	 
	public static void main(String[] args) {
		quiz();
	}
}