package bledsoe_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI4 {
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
		
		int expectedAnswer = first * second;
			askQuestion(first,second, i);
			int response = readResponse(sc);
			if (isAnswerCorrect(expectedAnswer,response))
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
	
	
	//create method to ask question
	public static void askQuestion(int num1, int num2, int i) {
	System.out.println("What is "+ num1 +" times " + num2 + "?");
	
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
		int correct = rand.nextInt(4);
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
