/********************************************************************************************************************** 	
	The following code implements a class Polynomial as a part of the java package "com.numerical". This piece of code
	has	the following components and dependencies.
	
	private static int coef[] - Private integer array to store the coefficients for the polynomial.
	private static int deg - Private integer variable to store the highest exponent of the polynomial.
	
	getDegree() - Returns void - Getter method to take as input the value for "int deg".
	
	getCoef() - Returns void - Getter method to take as input the values for "int coef[]".
	
 	Polynomial() - Constructor - Initializes the polynomial object. First, getDegree() is called to get the value of
	the highest exponent. An array of size "deg + 1" is created for the coefficients. Finally, getCoef() is called for 
	populating this array.
	
	polyDerivEval() - Returns double - This method returns the derivative of the polynomial at a point "x" which is 
	taken as a parameter.
	
	polyDisplay() - Returns void - Displays the polynomial input by the user.
	
	main() - Returns void - Provided for testing the code. Commented out over here.
	
	Implementation Details
	----------------------
	
	INPUT - Highest exponent in the polynomial and its coefficient.

	OUTPUT - A polynomial of the form (a_n * x ^ n) + (a_n-1 * x ^ n-1) + ... + (a_1 * x) + a_0

	For example, if the highest exponent in a polynomial is 4, the array will have 5 cells. The first cell will have
	the coefficient for exponent 4, the second cell for 3 and so on until the last cell which is exponent 0.
	A zero coefficient means that in the polynomial, no term with that coefficient exists.
	Illustration:
	
	|	4	|	3	|	2	|	1	|   0  | <---------Exponents(Array indices)
	----------------------------------------
	|	5	|	8	|	-3	|	7	|  -6  | <---------Coefficients
	
	So the resulting polynomial is  5x^4 + 8x^3 - 3x^2 + 7x - 6 .
	The polyDisplay() method ignores the terms where the coefficient is zero and hence doesn't display them.
	    	
**********************************************************************************************************************/


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
			if(i == 0 && coef[i] == 0)
			{
				System.out.print(0);
				break; // checks if the current term is the last term to avoid appending the "+" to it 
			}
			if(i == 0)
			{
				System.out.print(coef[i]);
				break; // checks if the current term is the last term to avoid appending the "+" to it 
			}
			if(coef[i] == 0)
				continue; // ignores zero coefficients
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
