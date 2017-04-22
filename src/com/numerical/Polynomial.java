//package com.numerical;
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
                polyDisplay();
        }

	public static double polyEval(double x)
	{
		double result = 0;
		for (int i = coef.length-1; i >= 0; i--)
	            result = coef[i] + (x * result);
		return result;
	}
	public static double polyDerivEval(double x)
        {
                double result = 0;
                for (int i = coef.length-1; i > 0; i--)
                    result = result+i*coef[i]*Math.pow(x,i-1);
                return result;
        }
	
	public void polyDisplay()
	{
		System.out.println("The polynomial you have entered is :");
		for(int i = deg; i >= 0; i--)
		{
			if(coef[i] == 0)
				continue;
			if(i == 0)
			{
				System.out.print(coef[i] + "x^" + i);
				break;
			}
			System.out.print(coef[i] + "x^" + i + " + ");
		}
		System.out.println();
	}
    
	public static void main(String[] args) //for testing
	{
		Polynomial p1;
		p1=new Polynomial();
		double c = p1.polyEval(2);
                double d = p1.polyDerivEval(2);
		System.out.println(c);
		System.out.println(d);
	}
}
