/********************************************************************************************************************** 	
	The following code implements the Regula Falsi Method for finding true zeroes of polynomials. It is implemented as a
	part of the	java package "com.numerical" where there are a few other root finding methods. This piece of code has
	the following components and dependencies.
	
 	Polynomial - Superclass - This class creates a polynomial object which the user inputs as parameter for the program.
	
	calcFalseRoot() - Returns void - Used for calculating the actual root of the given polynomial.
	
	inputEval() - Returns double - Used for calculating the value of the polynomial at a particular point. Here it is 
	implemented by calling the method polyEval() from the Polynomial superclass which actually evaluates the value of
	the given polynomial.
	
	main() - Returns void - Provided for testing the code. Commented out over here.
	
	Implementation Details
	----------------------
	
	INPUT - y = f(x) continuous on	[a, b]
	OUTPUT - Value of x such that f(x) = 0
	
	The Regula Falsi Method algorithm takes a polynomial as input from the user along with a closed interval [a, b] where
	the user suspects the root could lie. The two points of the interval are used for evaluating f(x) such that either
	f(a) or f(b) is negative. This means the function changes sign on the interval implying the presence of a root
	somewhere on the interval. However, this will be true IF AND ONLY IF the function is CONTINUOUS on the closed interval.
	Since, this a bracketed method, it is guaranteed to converge even if it takes a large number of iterations.Unlike Bisection
	method instead of bisecting the interval, we find where the chord joining the boundary points of the interval meet the 
	X axis. The roots are then calculated using the equation of the chord.The rate of convergence is still linear but faster
	than that of the bisection method in some cases.It's sign is checked and the new interval is appropriately updated such 
	that the bracketing property is preserved.The program stops executing once the absolute difference between
	the left and right intervals falls below a pre-specified value, here given by EPSILON which is 
	equal to 6 x 10e-6.
	
**********************************************************************************************************************/
package com.numerical;
import java.util.Scanner;

public class RegulaFalsiMethod extends Polynomial
{
	
    static final double EPSILON = 0.000006;	// EPSILON is the pre-specified accuracy
	
    public void calcFalseRoot()	// calculates the zeroes of a function using the Regula Falsi method
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
                if(fa*fb < 0)
                    rightInterval = root;
                else if (fa*fb > 0)
                    leftInterval = root;
		else
		    break;
            }
            System.out.println("The real root in the specified interval is: " + root);      
	}
	else
            System.out.println("No real roots on this interval. OPERATION ABORTED.");
	}
 
    double inputEval(double leftInterval)  // evaluates the value of a function at a given point 
    {
        return polyEval(leftInterval);
    }

    /*public static void main(String args[]) // for testing
    {
        RegulaFalsiMethod obj = new RegulaFalsiMethod();
        obj.calcFalseRoot();
    }*/
} // end           
