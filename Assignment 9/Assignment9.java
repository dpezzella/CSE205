// Assignment #: 9
//         Name: Derek Pezzella
//    StudentID: 
//      Lecture: TTh 4:30-5:45pm
//  Description: Given an array input by the user, the minimum element, greatest element divisible by 2, count of even elements, and sum of elements with array indexes divisble by 3 will be found using recursion.

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;

public class Assignment9 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int[] elements = new int[100];
		int input = 1;
		int i = 0;

		int minNum = 0;
		int divTwo = 0;
		int countEvenNum = 0;
		int divThree = 0;

		//get input
		while(input != 0 && i < elements.length) {
			input = Integer.parseInt(in.readLine());
			elements[i] = input;

			i++;
		}

		//call methods to find values
		minNum = findMin(elements, elements.length - 2, elements.length - 1, 0);
		divTwo = computeMaxDivisbleBy2(elements, elements.length - 1, elements.length - 1, 0);
		countEvenNum = countEvenNumbers(elements, elements.length - 1, elements.length - 1, 0);
		divThree = computeSumOfNumbersAtIndexDivisibleBy3(elements, elements.length - 1, elements.length - 1, 0);

		//print results
		System.out.println("The minimum number is " + minNum);
		System.out.println("The largest integer that is divisible by 2 is " + divTwo);
		System.out.println("The count of even numbers in the sequence is " + countEvenNum);
		System.out.println("The sum of numbers at indexes divisible by 3 is " + divThree);

	}

	//Find the minimum element using reursion
	public static int findMin(int[] numbers, int startIndex, int endIndex, int result) {
		if(startIndex == 0) {
			return result;
		} else {
			//if the element is less than the previous one, and less than the previous min element
			if(numbers[startIndex] < numbers[endIndex] &&  numbers[startIndex] < result) {
				result = numbers[startIndex];
			}

			return findMin(numbers, endIndex - 2, endIndex - 1, result);
		}
	}
	
	//Compute the greatest element that is divisble by 2	
	public static int computeMaxDivisbleBy2(int[] elements, int startIndex, int endIndex, int result) {
		if(startIndex == 0) {
			return result;
		} else {
			//element is divisble by 2 (mod 2 = 0) and greater than previous max element
			if(elements[startIndex]%2 == 0 && elements[startIndex] > result) {
				result = elements[startIndex];
			}
		}

		return computeMaxDivisbleBy2(elements, startIndex - 1, endIndex, result);
	}

	//Compute the number of even element	
	public static int countEvenNumbers(int[] elements, int startIndex, int endIndex, int result) {
		if(startIndex == 0) {
			if(elements[startIndex]%2 == 0) {
				return result + 2; //account for 0, which is even, and the element at startIndex
			} else {
				return result + 1; //account for 0, which is even
			}
		} else {
			//Abs isn't really necessary here, but just in case
			//Since the element is full of 0's and 0 is even, we'll need to sort those out
			//then adjust at the end of the count
			if(Math.abs(elements[startIndex]%2) == 0 && elements[startIndex] != 0) {
				result++;
			}
		}

		return countEvenNumbers(elements, startIndex - 1, endIndex, result);
	}
	
	//Compute the sum of the numbers with indexes divisible by 3	
	public static int computeSumOfNumbersAtIndexDivisibleBy3(int[] elements, int startIndex, int endIndex, int result) {
		if(startIndex == 0) {
			//Since the last element (0) is divisible by 3, add it to the result
			return result + elements[0];
		} else {
			if(Math.abs(startIndex%3) == 0) {
				result += elements[startIndex];
			}
		}

		return computeSumOfNumbersAtIndexDivisibleBy3(elements, startIndex - 1, endIndex, result);
	}
}

