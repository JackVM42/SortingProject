/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.sortingproject;

import static java.lang.System.currentTimeMillis;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jackvanmilligen
 */
public class SortingProject {
 	
 	public static void displayArray(int[] array) {
 		for (int i = 0; i < array.length; i++) {
 			System.out.print(array[i] + "  ");
 		}
 		System.out.println("\n");
 	}
 	
 	public static void sortIntArray() {
		Scanner input = new Scanner(System.in);
		int numItems, searchNum, location;
		int[] test;
		Random rand = new Random();
                long start=0;
                long finish=0;
                long total=0;
		
		System.out.print("Enter number of elements: ");
		numItems = input.nextInt();
		
		/* populate array */
		test = new int[numItems];
		for (int i = 0; i < test.length; i++) {
			test[i] = rand.nextInt(10);
		}
		System.out.println("Unsorted:");
		Sorts.printArray(test);
   
                start = System.nanoTime();
                Sorts.quicksort(test);
                finish = System.nanoTime();
                total = finish - start;
                
		
		
                System.out.println("\nSorted:");
		Sorts.printArray(test);
                System.out.println("\nThe time taken is:" + total + " nanoseconds");
                System.out.println("Comparisons: " + Sorts.getComparisons());
                System.out.println("Switches: " + Sorts.getSwitches());
                System.out.println("\nReversed: ");
                Sorts.revQuicksort(test);
                Sorts.printArray(test);
		/* search for number in sorted array */
		System.out.print("Enter a number to search for: ");
		searchNum = input.nextInt();
		while (searchNum != -1){
                        start = currentTimeMillis();
			location = Searches.binarySearch(test, 0, test.length-1, searchNum);
                        finish = currentTimeMillis();
                        total = finish - start;
                        System.out.println("The time taken is:" + total + " ms");
			System.out.println("Number at position: " + location);
			System.out.print("Enter a number to search for: ");
			searchNum = input.nextInt();
		}
  	}


 	public static void displayArray(Circle[] array) {
 		for (int i = 0; i < array.length; i++) {
 			System.out.println(array[i] + "  ");
 		}
 		System.out.println("\n");
 	}
 	
 	
 	public static void sortObjectArray() {
 		Scanner input = new Scanner(System.in);
		int numObjects;
		Circle[] test;
		Random rand = new Random();
		
		System.out.print("Enter number of objects: ");
		numObjects = input.nextInt();
		input.close();
		
		/* populate array */
		test = new Circle[numObjects];
		for (int i = 0; i < test.length; i++) {
			test[i] = new Circle(rand.nextInt(10));
		}
		System.out.println("Unsorted:");
		displayArray(test);
		
		Sorts.quicksort(test);
		
		System.out.println("Sorted:");
		displayArray(test);	
 	}
 	
 	
	public static void main(String[] args) {
		sortIntArray();
                sortObjectArray();
                //sortObjectArray();
	}
}

