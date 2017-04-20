package com.numerical;
import java.util.Scanner;

class RegularFalsiMethod extends Polynomial
{
	
    static final double EPSILON = 0.000006;	// EPSILON is the pre-specified accuracy
	
    void calcFalseRoot()	// calculates the zeroes of a function using the Bisection method
    {
	double  leftInterval = 0.0, rightInterval = 0.0, root = 0.0, k = 0.0, fb = 0.0 , fa=0.0;
	Scanner in = new Scanner(System.in);
	System.out.println("Enter the endpoints of the closed interval [a,b] :");		
	leftInterval = in.nextDouble();
	rightInterval = in.nextDouble();
	if((inputEval(leftInterval)*inputEval(rightInterval))<0) // tests if the function has at least one real root in the given interval
	{
            while(Math.abs(leftInterval - rightInterval)>EPSILON)       
            {
                fb=inputEval(rightInterval);    //value of function at the point of right interval
                fa=inputEval(leftInterval);     //value of function at the point of left interval
                
                /*Calculation of root where,
                  root= b - ((b-a)/ (f(b) - f(a))  ) * f(b)
                */
                
                root = fb/(fb-fa);
	        root = root*(rightInterval-leftInterval);
                root = rightInterval - root;
                k = inputEval(root); // k is the intermediate value of the function at the point of intersection of secant line
                if(fb * k < 0)
                    leftInterval = root;
                else
                    rightInterval = root;
            }
            System.out.println("The real root in the specified interval is: " + root);      
	}
	else
            System.out.println("No real roots on this interval. OPERATION ABORTED.");
	in.close();
    }
 
    double inputEval(double leftInterval)  // evaluates the value of a function at a given point 
    {
        return Polynomial.polyEval(leftInterval);
    }
}

class RegularFalsi                    
{
    public static void main(String args[])
    {
        RegularFalsiMethod obj = new RegularFalsiMethod();
        obj.calcFalseRoot();
    }
} // end
