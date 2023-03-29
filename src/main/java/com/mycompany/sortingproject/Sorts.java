/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingproject;


import java.util.Random;

public class Sorts {
 	
	    //class variables
    private static int comparisons = 0;
    private static int switches = 0;
    
    //setters and getters
    public static int getComparisons(){
        return comparisons;
    }
    
    public static void setComparisons(int a){
        comparisons = a;
    }
    
    public static int getSwitches(){
        return switches;
    }
    
    public static void setSwitches(int a){
        switches = a;
    }
    
    
    /**
     * Sorts an array of ints in accending order
     * Overloaded method which allows you to quicksort an int array just passing an array without needing and upper and lower index
     * @param arr the array which is to be sorted
     */
    public static void quicksort(int[] arr) {
    quicksort(arr, 0, arr.length - 1, 1);
  }
    
    /**
     * Method which uses the quicksort algorithm in order to sort an array of ints in order based off order
     * @param arr Array to be sorted
     * @param lowInd Index of the first item in the array to be sorted
     * @param highInd Index of the last item to be sorted
     * @param order 1 means accending, 0 means decending
     */
    public static void quicksort(int[] arr, int lowInd, int highInd, int order) {
        
        //makes sure that if your algorithm is tyrying to sort a single number it will just quit here since it is already in order
    if (lowInd >= highInd) {
        comparisons++;//CHECKS
        return;
    }

    int pivot = medianPivot(arr, lowInd, highInd);
    
    //partions our array section using the partition method and then gets a return of the left pointer variable at the end of teh partition method
    //For accending order
    int lp = 0;
    
    if(order == 1){
        lp = partition(arr, lowInd, highInd, pivot);
    }
    
    //for decending
    if(order == 0){
        lp = revPartition(arr, lowInd, highInd, pivot);
    }


    //recursively quicksorts our smaller and smaller sections until the sections become of length one and the return statement at the top runs
        quicksort(arr, lowInd, lp - 1, order);
       quicksort(arr, lp + 1, highInd, order); 
  }
    
    /**
     * This method takes a array and a pivot value which is at the end of the sub array and places all of the values larger than the pivot to the right and all the smaller ones to the left
     * @param arr array to be sorted
     * @param lowInd the index of the first value in the partition section
     * @param highInd index of the last value in the partition section
     * @param pivot value of the pivot number
     * @return the value of the left pointer at the end for use in the quicksort method
     */
    private static int partition(int[] arr, int lowInd, int highInd, int pivot) {
    
       //left pointer starts at the index of the bottom if the partition section and right pointer starts one left of the pivot number
    int lp = lowInd;
    int rp = highInd - 1;

    //stops running once the two pointers have reached eachother
    while (lp < rp) {
        comparisons++;//CHECKS
        
      // lp works right through the array until it finds a number greater than the pivot number, or reaches the right pointer.
      while (arr[lp] <= pivot && lp < rp) {
        comparisons++;//CHECKS
        lp++;
      }

      // rp works left through the array until it finds a number less than the pivot number, or reaches the left pointer.
      while (arr[rp] >= pivot && lp < rp) {
        comparisons++;//CHECKS
        rp--;
      }
        
      //once the left pointer has a number bigger than the pivot and the right pointer has a number smaller we can just switch them
      swap(arr, lp, rp);
      switches++;//CHECKS
    }
    
    //makes sure that the last number is in order
    if(arr[lp] > arr[highInd]) {
        comparisons++;//CHECKS
        swap(arr, lp, highInd);
        switches++;//CHECKS
    }
    else {
      lp = highInd;
    }
    
    //returns the value of left pointer
    return lp;
  }
    
    
    /**
     * Will swap the two items in the array at the two passed indices
     * @param arr1 the array which the swap will occur in
     * @param index1 the first swap index
     * @param index2 the second swap index
     */
    private static void swap(int[] arr1, int index1, int index2){
        
        int tempstore = arr1[index1];
        arr1[index1] = arr1[index2];
        arr1[index2] = tempstore;
    }
    
    
    /**
     * Prints a section of the array out
     * @param arr Array to print out
     * @param lowInd Index of first item to include
     * @param highInd Index of last item to be included
     */
    public static void printArray(int[] arr, int lowInd, int highInd){
        
        for(int i = lowInd; i <= highInd; i++){
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }
    
    
    /**
     * Prints out the entire array
     * @param arr array to be printed
     */
    public static void printArray(int[] arr){
        
        for(int i = 0; i < arr.length; i++){
            System.out.println("Index " + i + ": " + arr[i]);
        }
    }
    
    /**
     * Makes an integer arry full of random ints
     * @param length length of array
     * @param maxNum largest number which can be included in the array
     * @return the array which has been made
     */
    public static int[] makeArray(int length, int maxNum){
        
        Random rand = new Random();
        
        //make array length long and fill it with random ints
        int[] arr = new int[length];
        for(int i = 0; i <= length - 1; i++){
            arr[i] = rand.nextInt(maxNum);
        }
        return arr;
    }
    
    
    /**
     * This method finds the median of the last first and middle item in the array section
     * @param arr array to use
     * @param lowInd index of first item being used
     * @param highInd index of the last item being used
     * @return returns the index of the median value
     */
    private static int median(int[] arr, int lowInd, int highInd){
        
        int midInd = (highInd - lowInd)/2 + lowInd;
        
        //find max
        int max = arr[lowInd];
        
        if(arr[midInd] > max){
            comparisons++;//CHECKS
            max = arr[midInd];
        }
        if(arr[highInd] > max){
            comparisons++;//CHECKS
            max = arr[highInd];
        }
        
        
        //find min
        int min = arr[lowInd];
        
        if(arr[midInd] < min){
            comparisons++;//CHECKS
            min = arr[midInd];
        }
        if(arr[highInd] < min){
            comparisons++;//CHECKS
            min = arr[midInd];
        }
        
        //find pivot value
        int pivot = arr[lowInd] + arr[midInd] + arr[highInd] - max - min;
        
        //find ind of median
        if(pivot == arr[lowInd]){
            comparisons++;//CHECKS
            return lowInd;
        }
        
        if(pivot == arr[midInd]){
            comparisons++;//CHECKS
            return midInd;
        }
        
        if(pivot == arr[highInd]){
            comparisons++;//CHECKS
            return highInd;
        }
            
        return highInd;
    }
    
    /**
     * picks median of the first last and mid value in the array and uses that as the pivot
     * @param arr array to chose pivot in
     * @param lowInd low index we are working with
     * @param highInd the high index of the array section we are working on
     * @return the value of the pivot
     */
    private static int medianPivot(int[] arr, int lowInd, int highInd){
            
        int pivotInd = median(arr, lowInd, highInd);
        int pivot = arr[pivotInd];
        swap(arr, pivotInd, highInd);
        switches++;//CHECKS
        return pivot;
    }
    
    
    /**
     * Sorts an array of ints in decending order
     * Overloaded method which allows you to quicksort an int array just passing an array without needing and upper and lower index
     * @param arr the array which is to be sorted
     */
    public static void revQuicksort(int[] arr) {
    quicksort(arr, 0, arr.length - 1, 0);
  }
    
    
    
    private static int revPartition(int[] arr, int lowInd, int highInd, int pivot) {
    
       //left pointer starts at the index of the bottom if the partition section and right pointer starts one left of the pivot number
    int lp = lowInd;
    int rp = highInd - 1;

    //stops running once the two pointers have reached eachother
    while (lp < rp) {

      // lp works right through the array until it finds a number greater than the pivot number, or reaches the right pointer.
      while (arr[lp] >= pivot && lp < rp) {
        lp++;
      }

      // rp works left through the array until it finds a number less than the pivot number, or reaches the left pointer.
      while (arr[rp] <= pivot && lp < rp) {
        rp--;
      }
        
      //once the left pointer has a number bigger than the pivot and the right pointer has a number smaller we can just switch them
      swap(arr, lp, rp);
    }
    
    //makes sure that the last number is in order
    if(arr[lp] < arr[highInd]) {
      swap(arr, lp, highInd);
    }
    else {
      lp = highInd;
    }
    
    //returns the value of left pointer
    return lp;
  }
    
    
  

//for circles
    

    public static void quicksort(Circle[] arr){
        quicksort(arr, 0, arr.length - 1);
    }
    
    public static void quicksort(Circle[] arr, int lowInd, int highInd) {
        if (lowInd < highInd) {
            int lp = partition(arr, lowInd, highInd);
            
            quicksort(arr, lowInd, lp - 1);
            quicksort(arr, lp + 1, highInd);
        }
    }

    private static int partition(Circle[] arr, int lowInd, int highInd) {
        Circle pivot = arr[highInd];
        int lp = lowInd;
        int rp = highInd;
        
        while(lp < rp){
            
            while(arr[lp].compareTo(pivot) != 1 && lp < rp){
                lp++;
            }
            
            while(arr[rp].compareTo(pivot) != -1 && lp < rp){
                rp--;
            }
            
            swap(arr, lp, rp);
        }
        swap(arr, lp, highInd);
        return lp;
    }
    
    public static void swap(Circle[] arr, int index1, int index2){
        Circle tempstore = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tempstore;
    }
}