package bledsoe_problem1;

import java.security.SecureRandom;
import java.util.Scanner;



public class CAI2 {
	
	public static void main(String[] args) {
		quiz();
	}
	
	//program logic
	public static void quiz() {
		SecureRandom rand = new SecureRandom();
		int first = rand.nextInt(10);
		int second = rand.nextInt(10);
		
		int expectedAnswer = first * second;
		int studentAnswer = -1;
		
		while(true) {
			askQuestion(first,second);
			studentAnswer = readResponse();
			if (isAnswerCorrect(expectedAnswer,studentAnswer))
			{
				displayCorrectResponse();
				break;
			}
			else
			{
				displayIncorrectResponse();
			}
		}
	}
	
	//create method to ask question
	public static void askQuestion(int num1, int num2) {
	System.out.println("What is "+ num1 +" times " + num2 + "?");
	
	}
	
	//create method to read user input
	public static int readResponse() {
		Scanner user = new Scanner(System.in);
		int answer = user.nextInt();
		return answer;
			}
		
		
	//create method to check for right answer
	public static boolean isAnswerCorrect(int expectedAnswer, int studentAnswer){
		return expectedAnswer == studentAnswer;
	}

	//create method for correct responses
	public static void displayCorrectResponse(){
		SecureRandom rand = new SecureRandom();
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
	public static void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom();
		int incorrect = rand.nextInt(4);
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


