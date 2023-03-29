/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sortingproject;

/**
 *
 * @author jackvanmilligen
 */
public class Circle implements Comparable {
	private static double PI = 3.14;
	private double radius;
		
	
	/**
	 * constructor
	 * pre: none
	 * post: A Circle object created. Radius initialized to 1.
	 */
	public Circle() {
		radius = 1;			//default radius
	}
	

	/**
	 * constructor
	 * pre: none
	 * post: A Circle object created with radius r.
	 */
	public Circle(double r) {
		radius = r;
	}


	/** 
	 * Changes the radius of the circle.
	 * pre: none
	 * post: Radius has been changed.
	 */
	public void setRadius(double newRadius) {
	 	radius = newRadius;
	}


	/** 
	 * Calcuates the area of the circle.
	 * pre: none
	 * post: The area of the circle has been returned.
	 */
	public double area() {
	 	double circleArea;
	 	
	 	circleArea = PI * radius * radius;
	 	return(circleArea);
	}

	
	/** 
	 * Returns the radius of the circle.
	 * pre: none
	 * post: The radius of the circle has been returned.
	 */
	public double getRadius() {
	 	return(radius);
	}
	
	
	/** 
	 * Displays the formula for the area of a circle.
	 * pre: none
	 * post: formula for area of a circle  has been displayed.
	 */
	public static void displayAreaFormula() {
	 	System.out.println("The formula for the area of a circle is a=Pi*r*r");
	}
	

	/** 
	 * Determines if the object is equal to another
	 * Circle object.
	 * pre: c is a Circle object.
	 * post: true has been returned if the objects have 
	 * the same radii. false has been returned otherwise.
	 */
	public boolean equals(Object c) {
		Circle testObj = (Circle)c;
		
	 	if (testObj.getRadius() == radius) {
			return(true);
		} else {
			return(false);
		}
	}


	/** 
	 * Determines if object c is smaller, the same, 
	 * or larger than this Circle object.
	 * pre: c is a Circle object
	 * post: -1 has been returned if c is larger than 
	 * this Circle, 0 has been returned if they are the same size,
	 * and 1 has been returned if c is smaller then this Circle.
	 */
	public int compareTo(Object c) {
		Circle testCircle = (Circle)c;
		
	 	if (radius < testCircle.getRadius()) {
			return(-1);
		} else if (radius == testCircle.getRadius()) {
			return(0);
		} else {
			return(1);
		}
	}


	/** 
	 * Returns a String that represents the Circle object.
	 * pre: none
	 * post: A string representing the Circle object has 
	 * been returned.
	 */
	public String toString() {
		String circleString;

		circleString = "Circle has radius " + radius;
	 	return(circleString);
	}
}

