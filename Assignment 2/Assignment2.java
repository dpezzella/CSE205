// Assignment #: 2
//         Name: Derek Pezzella
//    StudentID: 
//      Lecture: TTh 4:30-5:45pm
//  Description: Takes input from user until they enter 0, 
//  		then computes the minimum integer, the largest integer 
//  		divisible by two, the number of even integers, 
//  		and the sum of the positive integers. All of these
//  		calculations include the number 0.

import java.util.Scanner;

class Assignment2 {
	//The element in the array that comes after the first 0 digit
	//Start at one since there will always be at least one integer in the sequence (0)
	static int zeroPos = 1;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Initialize for 100 elements, since I don't know how many the user will enter
		int[] input = new int[100];
		int i = 1;

		input[0] = scan.nextInt();
		
		if(input[0] != 0) {
			while(input[i-1] != 0) {
				input[i] = scan.nextInt();
				i++;
			}
		}

		//Append the zero to the end since we are taking the 0 into
		//account when doing the calculations
		if(input.length > 1 && input[0] != 0) {
			//Since we increased i during the last loop, i should be the element following the last zero
			zeroPos = i;

			input[i] = 0;
		}

		System.out.println("The minimum integer is " + calculateMinimum(input) + "\n" 
				+ "The largest integer that is divisible by 2 is " + largestDivTwo(input) + "\n"
				+ "The count of even integers in the sequence is " + countEven(input) + "\n"
				+ "The sum of positive integers is " + sumPosInt(input));
	}

	//Calculate the minimum number given in an array
	static int calculateMinimum(int[] array) {
		int minNum = Integer.MAX_VALUE; 

		for(int i = 0; i <= zeroPos; i++) {
			if(array[i] < minNum) {
				minNum = array[i];
			}
		}

		return minNum;
	}
	
	//largestDivTwo and countEven can be combined into one function
	//but for clarity's sake, I will leave it as two.
	
	//Find the largest integer that is divisble by two in the array
	static int largestDivTwo(int[] array) {
		int largestEven = Integer.MIN_VALUE;

		for(int i = 0; i <= zeroPos; i++) {
			if(array[i]%2 == 0 && array[i] > largestEven) {
				largestEven = array[i];
			}
		}

		return largestEven;
	}

	//Count the number of even integers in the array
	static int countEven(int[] array) {
		int count = 0;

		for(int i = 0; i < zeroPos; i++) {
			if(array[i]%2 == 0) {
				count++;
			}
		}

		return count;
	}

	//Find the sum of all of the positive integers in the array
	static int sumPosInt(int[] array) {
		int sum = 0;

		for(int i = 0; i <= zeroPos; i++) {
			if(array[i] > 0) {
				sum += array[i];
			}
		}

		return sum;
	}

}
