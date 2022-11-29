package com.main;

import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0, j = 0,r=0,c=0;
		Scanner s = new Scanner(System.in);

		//get the no. of rows and columns of the matrix from the user
		System.out.println("Enter no. of rows:");
		r = s.nextInt();
		System.out.println("Enter no. of columns:");
		c = s.nextInt();

		//accept the matrix
		System.out.println("Enter the first matrix:>>");
		matrix1 m1 = new matrix1(r,c);
		m1.get_input();
		
		m1.print_matrix();
	}
}
	
class matrix1
	{
		private double[][] mat;
		int row, column;

		//constructor
		matrix1()
		{
			row=0;
			column=0;
		}

		//constructor
		matrix1(int r, int c)
		{
			row = r;
			column = c;
			mat = new double[row][column];
		}

		//function to accept matrix values from user
		public void get_input()
		{
			Scanner s = new Scanner(System.in);
			int i=0,j=0;
			
			System.out.println("Enter the matrix elements(row-wise)");
			for (i=0; i < row; i++)
			{
				for(j=0; j<column; j++)
		        {
					mat[i][j] = s.nextDouble();
				}

			}
		}

		//function to print matrix 
		public void print_matrix()
		{
			int i = 0, j = 0;
			System.out.println("The matrix is:>>");
			for (i = 0; i < row; i++)
			{
				System.out.println("");
				for (j = 0; j < column; j++)
				{
					System.out.print("   "+mat[i][j]);
				}

			}
		}
	}
	
