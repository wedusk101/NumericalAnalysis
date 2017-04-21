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
	                double Area=(interval/2)*sum;
	                System.out.println("The Area="+Area);
	              
	}
	            
	            double inputEval(double leftInterval)  // evaluates the value of a function at a given point 
	            {
	                return Polynomial.polyEval(leftInterval);
	            }
    /*public static void main(String args[])
    {
        Trapezoidal obj = new Trapezoidal();
        obj.integrateTrapezoidal();
    }*/
} // end
