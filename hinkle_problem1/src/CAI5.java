//Sean Hinkle, Programming assignment 3, Dr. Hollander
import java.security.SecureRandom;
import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

//This program produces two random single digit integers, 
//asks a multiplication problem,
//if the answer is correct, print message then terminate,
//if incorrect, continuously prompt with message
public class CAI5 {
	private static SecureRandom numgen = new SecureRandom();
	private static Scanner in = new Scanner(System.in);
	private static double studentAnswer;
	private static double correctAnswer;
	private static int numCorrect;
	private static int difficultyLevel;
	private static int problemType;
	private static int quizMode;
	private static double num1;
	private static double num2;
	
	//Runs the quiz by asking ten total questions, 
	//then asks if the user wants to repeat the process
	public static void quiz() {
		//determines the number of digits involved in the problems, and the types of problems asked
		readDifficulty();
		readProblemType();
		//reset numCorrect if this is a restart
		numCorrect = 0;
		
		for (int i = 0; i < 10; i++) {
			generateQuestionArgument(problemType);
			askQuestion();
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
	
	//asks the question based on class variables set previously
	private static void askQuestion() {
		String operation;
		switch (quizMode) {
		case 1:
			operation = "plus";
			System.out.printf("How much is %.0f %s %.0f?%n", num1, operation, num2);
			break;
		case 2:
			operation = "times";
			System.out.printf("How much is %.0f %s %.0f?%n", num1, operation, num2);
			break;
		case 3:
			operation = "minus";
			System.out.printf("How much is %.0f %s %.0f?%n", num1, operation, num2);
			break;
		case 4:
			operation = "divided by";
			System.out.printf("How much is %.0f %s %.0f?%n", num1, operation, num2);
		}
		
	}
	
	private static void readResponse() {
		//for the sake of division problems, rounds student answer to two decimals. The answer is also rounded to two decimals, so the two can be directly compared
		studentAnswer = new BigDecimal(in.nextDouble()).divide(new BigDecimal(1.0), 2, RoundingMode.HALF_UP).doubleValue();
	}
	
	//checks student answer versus correct answer generated in quiz method
	//***This can be an equals comparison*** because both numbers are rounded using the same method, RoundingMode.HALF_UP
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
	
	public static void setCorrectAnswer(int probType) {
		switch (probType) {
		case 1:
			correctAnswer = num1+num2;
			break;
		case 2:
			correctAnswer = num1*num2;
			break;
		case 3:
			correctAnswer = num1-num2;
			break;
		case 4:
			//This operates precise division using big decimal, first ensuring that there is no division by 0, then
			//rounds it to 2 decimal places using typical rounding methods, then converts it to a double
			if (num2 == 0) {
				correctAnswer = 0;
			} else {
			correctAnswer = new BigDecimal(num1).divide(new BigDecimal(num2), 2, RoundingMode.HALF_UP).doubleValue();
			}
			break;
		case 5:
			// generate random number 1-4 to call back to this function, 
			//therefore randomly assigning a problem type
			quizMode = numgen.nextInt(4) + 1;
			setCorrectAnswer(quizMode);
			break;
		}
	}
	
	public static void generateQuestionArgument(int probType) {
		switch (difficultyLevel) {
		case 1:
			num1 = numgen.nextInt(10);
			num2 = numgen.nextInt(10);
			setCorrectAnswer(probType);
			break;
		case 2:
			num1 = numgen.nextInt(100);
			num2 = numgen.nextInt(100);
			setCorrectAnswer(probType);
			break;
		case 3:
			num1 = numgen.nextInt(1000);
			num2 = numgen.nextInt(1000);
			setCorrectAnswer(probType);
			break;
		case 4:
			num1 = numgen.nextInt(10000);
			num2 = numgen.nextInt(10000);
			setCorrectAnswer(probType);
			break;
		}
	}
	
	public static void readDifficulty() {
		System.out.println("What difficulty level would you like to use? (ranges 1-4)");
		difficultyLevel = in.nextInt();
	}
	
	public static void readProblemType() {
		System.out.println("What types of problems would you like to study?");
		System.out.println("1 = addition problems only");
		System.out.println("2 = multiplication problems only");
		System.out.println("3 = subtraction problems only");
		System.out.println("4 = division problems only");
		System.out.println("5 = random mix of all types: ");
		problemType = in.nextInt();
		//in addition to setting problem type, sets quizMode so that the method
		//askQuestion can function with case 5, random mix of all types
		quizMode = problemType;
	}
	
	public static void main(String[] args) {
		quiz();
	}
}