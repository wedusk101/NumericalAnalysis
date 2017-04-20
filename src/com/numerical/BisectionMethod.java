package com.numerical;
import java.util.Scanner;

public class BisectionMethod extends Polynomial
{
	
	static final double EPSILON = 0.000006;	// EPSILON is the pre-specified accuracy
	
	public void calcBisectionRoot()	// calculates the zeroes of a function using the Bisection method
	{
		double  leftInterval = 0.0, rightInterval = 0.0, root = 0.0, k = 0.0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the endpoints of the closed interval [a,b] :");		
		leftInterval = in.nextDouble();
		rightInterval = in.nextDouble();
		if((inputEval(leftInterval)*inputEval(rightInterval))<0) // tests if the function has at least one real root in the given interval
		{
			while(Math.abs(leftInterval - rightInterval)>EPSILON)       
			{
				root = (leftInterval + rightInterval)/2;         
				k = inputEval(root); // k is the intermediate value of the function at the point of bisection 
				if(inputEval(leftInterval) * k > 0)
					leftInterval = root;
				else
					rightInterval = root;
			}
			System.out.println("The real root in the specified interval is: " + root);      
		}
		else
			System.out.println("No real roots on this interval. OPERATION ABORTED.");
		//in.close();
	}
 
	double inputEval(double leftInterval)  // evaluates the value of a function at a given point 
	{
	   return polyEval(leftInterval);
	}
}

/*public class Bisection // for testing                    
{
	public static void main(String args[])
	{
		BisectionMethod obj = new BisectionMethod();
		obj.calcBisectionRoot();
	}
} // end*/
