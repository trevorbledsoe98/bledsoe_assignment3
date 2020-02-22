package bledsoe_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String anotherround;
		do {
		quiz(sc);
		System.out.println("Do you want another round of questions?(yes/no):");
		anotherround = sc.next();
		}while(anotherround.equalsIgnoreCase("yes"));
		sc.close();
	}
	
	//program logic
	public static void quiz(Scanner sc) {
		SecureRandom rand = new SecureRandom();
		int countCorrect = 0;
		int difficulty = readDifficulty(sc);
		for(int i = 1; i <= 10; i++) {
		int first = generateQuestionArgument(rand, difficulty);
		int second = generateQuestionArgument(rand, difficulty);
		int operation = pickOperation(rand, sc);
		int correctAns = generateCorrectAnswer(operation, first, second);
		
			askQuestion(first,second, i, operation);
			int response = readResponse(sc);
			if (isAnswerCorrect(correctAns,response))
			{
				displayCorrectResponse(rand);
				countCorrect++;
			}
			else
			{
				displayIncorrectResponse(rand);
			}
		}
			displayCompletionMessage(countCorrect);
	}
	
	
	//method for difficulty
	private static int generateQuestionArgument(SecureRandom rand, int difficulty){
		int argument = 0;
		
		if(difficulty == 1)
			argument = rand.nextInt(10);
		else if(difficulty == 2)
			argument = rand.nextInt(100);
		else if(difficulty == 3)
			argument = rand.nextInt(1000);
		else 
			argument = rand.nextInt(10000);
		
		return argument;
	}
	
	
	//method for problem type
	private static void askQuestion(int first, int second, int i, int operation) {
		switch(operation)
		{
		case 1:
		System.out.println("Q." + i + " how much is " + first + " plus " + second + "?");
		break;
		case 2:
		System.out.println("Q." + i + " how much is " + first + " times " + second + "?");
		break;
		case 3:
		System.out.println("Q." + i + " how much is " + first + " minus " + second + "?");
		break;
		case 4:
		System.out.println("Q." + i + " how much is " + first + " divided by " + second + "?");
		
		}

		}

		//reading operation from the user
		private static int pickOperation(SecureRandom rand, Scanner sc) {
		System.out.print("Please pick an operation 1.Addition, 2.Multiplication, 3.Subtraction, 4. Division, 5.Mixed: \n");
		int operation = sc.nextInt();

		if(operation == 5)
		operation = rand.nextInt(4) + 1;
		  
		return operation;
		}

		//method to generate Correct answer based on user selection
		private static int generateCorrectAnswer(int operation, int first, int second){

		switch(operation)
		{
		case 1:
		return first + second;
		case 2:
		return first * second;
		case 3:
		return first - second;
		case 4:
		return first / second;
		}
		return 0;
		}
	
	//method for reading difficulty
	private static int readDifficulty(Scanner sc) {
		System.out.println("Enter your difficulty(1-4): ");
		return sc.nextInt();
	}
	
	//method for completion message
	public static void displayCompletionMessage(int countCorrect) {
		
		double percent =((double)countCorrect / 10.0) * 100.0;
		
		System.out.println("You scored: " +percent+ "%");
		
		if(percent < 75)
			{System.out.print("Please ask your teacher for extra help\n");
			}
		else {
			System.out.println("Congratulations, you are ready to go to the next level!");
			}
	}
	
	
	//create method to read user input
	public static int readResponse(Scanner sc) {
		Scanner user = new Scanner(System.in);
		int answer = user.nextInt();
		return answer;
	}
		
		
	//create method to check for right answer
	public static boolean isAnswerCorrect(int expectedAnswer, int studentAnswer){
		return expectedAnswer == studentAnswer;
	}

	//create method for correct responses
	public static void displayCorrectResponse(SecureRandom rand){
		SecureRandom rand1 = new SecureRandom();
		int correct = rand1.nextInt(4);
		switch(correct) {
		case 0 : System.out.println("Very Good!");
		break;
		case 1 : System.out.println("Excellent!");
		break;
		case 2 : System.out.println("Nice Work!");
		break;
		case 3 : System.out.println("Keep Up The Good Work!");
		break;
		}
	}
	
	//create method for incorrect respose
	public static void displayIncorrectResponse(SecureRandom rand) {
		SecureRandom rand2 = new SecureRandom();
		int incorrect = rand2.nextInt(4);
		switch(incorrect) {
		case 0 : System.out.println("No. Please Try Again");
		break;
		case 1 : System.out.println("Wrong. Try Once More");
		break;
		case 2 : System.out.println("Don't Give Up!");
		break;
		case 3 : System.out.println("No. Keep Trying");
		break;
		}	
	}
	

}



