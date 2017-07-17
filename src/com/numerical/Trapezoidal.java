
/****************************************************************************************************************************** 
    The following code implements the Trapezoidal Rule which numerically integrates a function in the interval [a, b] and 
    calculates the area enclosed by it.It is implemented as a part of the java package "com.numerical" where there is another
    method known as Simpson's 1/3rd rule that also serves the same purpose. This piece of code has the following components
    and dependencies.
 
    Polynomial - Superclass - This class creates a polynomial object which the user inputs as parameter for the program.
	
    integrateTraapezoidal() - Returns void - Used for calculating the area enclosed by the of the given polynomial function.
	
    inputEval() - Returns double - Used for calculating the value of the polynomial at a particular point. Here it is 
    implemented by calling the method polyEval() from the Polynomial superclass which actually evaluates the value of
    the given polynomial.
	
    main() - Returns void - Provided for testing the code. Commented out over here.
    
    Implementation Details
    ----------------------
    
    INPUT - y = f(x) continuous on [a, b]
	
    OUTPUT - area enclosed by the Polynomial function in sq. units
 
    The Trapezoidal Rule algorithm takes a polynomial as input from the user along with a closed interval [a, b]
    and works by approximating the region under the graph of the function f(x) as a trapezoid and calculating its area.
    The trapezoidal rule has faster convergence in general than Simpson's rule,the accuracy of this rule depends on the 
    No. of intervals,No. of intervals is the No. of trapezoids in which the area under under the curve is divided. 
    
******************************************************************************************************************************/
package com.numerical;

import java.util.Scanner;

public class Trapezoidal extends Polynomial
{
	static final double EPSILON = 0.000006;	// EPSILON is the pre-specified accuracy
	public void integrateTrapezoidal()
	{
		double  leftInterval = 0.0, rightInterval = 0.0,interval=0.0, sum = 0.0,  fb = 0.0 , fa=0.0,fx=0.0,N;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the endpoints of the closed interval [a,b] :");	
		leftInterval = in.nextDouble();
		rightInterval = in.nextDouble();
		System.out.println("Enter the number of intervals:");
		N=in.nextDouble();
		
	                fb=inputEval(rightInterval);    //value of function at the point of right interval
	                fa=inputEval(leftInterval);     //value of function at the point of left interval
	                interval=(rightInterval-leftInterval)/N;
	                sum = fb + fa;    //calculating 1st and last means y0 and yn
			
	                for (double xh = leftInterval+interval; xh < rightInterval; xh=xh+interval) 
	                {
	                	fx=inputEval(xh);		//incrementing value of x with respect to h  
	                     sum=sum+(2*fx);       //calculating sum from y1 to y(n-1)
	                }
	                double area = (interval/2)*sum;
	                System.out.println("The Area is " + area + " square units.");
	              
	}
	            
	            double inputEval(double leftInterval)  // evaluates the value of a function at a given point 
	            {
	                return polyEval(leftInterval);
	            }
    /*public static void main(String args[])
    {
        Trapezoidal obj = new Trapezoidal();
        obj.integrateTrapezoidal();
    }*/
} // end
