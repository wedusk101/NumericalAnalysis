package com.numerical;
import java.util.Scanner;

public class Polynomial 
{
	private static int coef[];  // coefficients
	private static int deg;     // degree of polynomial (0 for the zero polynomial)
		
	private void getDegree()
	{
		System.out.println("Enter the highest degree for the Polynomial");
		Scanner s = new Scanner(System.in);
		deg = s.nextInt();
	} 
	
	private void getCoef()
	{
		Scanner s = new Scanner(System.in);
		for(int i = coef.length - 1; i >= 0; i--)
		{
			System.out.println("Enter the coefficient value when exponent of the term is " + i);
			coef[i] = s.nextInt();
		}
	}

	public Polynomial()
	{
		getDegree();      
        coef = new int[deg + 1];
        getCoef();
    }

	public static double polyEval(double x)
	{
		double result = 0;
		for (int i = coef.length-1; i >= 0; i--)
			result = coef[i] + (x * result);
		return result;
	}

	/*public static void main(String[] args) //for testing
	{
		Polynomial p1;
		p1=new Polynomial();
		double c = p1.polyEval(2);
		System.out.println(c);

	}*/
}