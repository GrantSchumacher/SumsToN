
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**  
* SumsToN.java - Given positive integer n, lists all possible ways to get a collection of positive integers adding up to n, excluding order
* @author  Grant Schumacher
* @version 1.0 
* Created: 02/03/20
* CS4050
* 
*/ 

public class SumsToN { 

	
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		/*
		System.out.println("--------------------");
		System.out.print("Input the value of n: ");
		 
		
		int n = scan.nextInt();
		
		genSums(n,n);
		*/
		while(true){
			System.out.println("--------------------");
			System.out.print("Input the value of n: ");
			String input = scan.next();
			int n = 0;
			
			try{
				n = Integer.parseInt(input);
				if(n > 0){
					System.out.println("For n=" +n+" the possibilites are:");
					genSums(n,n);
				}else{
					System.out.println("-Please enter a positive integer-");
				}
			}catch(NumberFormatException ne){
				System.out.println("-Not a valid number-");
			}
		}
	
		
	}
	
	//Print every element of an array to the console then move to the next line.
	public static void printArray(int[] array){
		for(int index =0; index < array.length; index++){	//Loop through the given array and print each value 
			if(index > 0){ //Prints a + between each value, helps make it more readable when input value is double digit
				System.out.print("+");
			}
			System.out.print(array[index]);
			}
		System.out.println();	
	} 
	
	
	
	public static void genSums(int n, int length){
		int[] sums = new int[length]; //Create an array based of input length
		Arrays.fill(sums, 1);	//Fill the array with all 1's 
		int maxValue;
		
		maxValue = n - (length -1);	//Maximum value of the most right integer based off of array size. The pattern of the summation problem is that the 
									//right most value has a correlated maximum value based off of the length. This value can be found by
									// taking the input size and subtracting the length of the array minus one. 
									// This is important because it tells our algorithm how many times to increment the numbers
		
		sums[sums.length-1] = maxValue; //Set the rightmost value of the array to the maxValue
		printArray(sums);				//Print this array because its a valid output
		
		if(length != 2){
			
			for(int i = length-1; i > 0; i--){ 	//Loop the length of the array minus one
				if(sums[length-1] > 2){			//Ensure the last value of the array is greater than two
					sums[length-1] -= 1;		//Remove one from the last index of the array and "put" it on the array index at value i-1
					sums[i-1] +=1;
					printArray(sums);			//Print the new array
				}
			}
			
		}else{
			
			for(int x = 1; x < n/2; x++){ //The algorithm needs to loop n/2 times if the sums array is of length 2 because 
										  //there are n/2 possible outputs for array of size 2 excluding duplicates
				sums[1] -= 1;			  //Decrease the value of index [1] by 1 
				sums[0] += 1;			  //Increment value of index [0] by 1
				printArray(sums);		  //Print the array of size 2 until all possible outputs excluding duplicates have been printed
			}
		}
		
		if(length > 1){	//Base case. If length is less than or equal to one end the recursive cycle. 
			length--;	//Decrease the length of the array but leave n unchanged
			genSums(n, length);	//Recursively call until all options have been printed
		}
	}
}
	
	
	
	




