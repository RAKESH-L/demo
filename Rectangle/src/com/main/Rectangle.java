package com.main;

import java.util.Scanner;

public class Rectangle {
	
	static void calculateArea(double l, double b) {
		System.out.println("Area of Rectangle: " + l*b);
	}
	
	static void getDimensions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of Rectangle: ");
		double length = sc.nextDouble();
		System.out.println("Enter the breath of Rectangle: ");
		double breath =  sc.nextDouble();
		
		calculateArea(length, breath);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		getDimensions();
		
	}

}
