package com.numerical;
import java.util.Scanner;

/* Working Conditions
 *  if a function has a root and has a non-zero derivative at that root,
 *  and is continuously differentiable in some interval around that root,
 *  then if we pick our starting point in the region of the root,
 *  the iterations will subsequently converge to the given root. 
 */

/*Failing conditions
 * the derivative may be zero at the root; 
 * the function may fail to be continuously differentiable;
 * the user gives a bad initial root that is
 * one that lies outside the range of guaranteed convergence. 
 */

/*Sample problem
 * f(x)=x^2 + 2*x - 2
 * initial guess root=1
 * 
 */
public class NewtonRaphsonMethod extends Polynomial
{
	
	static final double EPSILON = 0.000006;	// EPSILON is the pre-specified accuracy
	
	public void calcNewtonRaphsonRoot()	// calculates the root of a function using the Newton Raphson method
	{
		double  initRoot = 0.0;  //note the initial guess root should be somewhere in the region of the actual root
		double newRoot = 0.0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the initial guess of the root :");		
		initRoot = in.nextDouble();
		 if(inputDerivEval(initRoot)==0)
 		 {
 			 System.out.println("The Derivative for the initial root given by the user is 0 so Newton Raphson method cannot be applied");
 			 return;
 		 }
		 while(Math.abs(newRoot-initRoot)>EPSILON)       
		 {
		 		 initRoot=newRoot;      
		 		 if(inputDerivEval(initRoot)==0)
		 		 {
		 			 System.out.println("The initial root provided the user is not continuosly differentiable so Newton Raphson method cannot be applied");
		 			 return;
		 		 }
				 newRoot = initRoot - (inputEval(initRoot) / inputDerivEval(initRoot));
			     if (Math.abs((newRoot-initRoot)/initRoot)<EPSILON )
			     {
			     	 System.out.println("The  positive root is: " + newRoot);
			         break;
			     }
		 }
		
			    	
	}
 
	double inputEval(double result)  // evaluates the value of a function at a given point 
	{
	   return polyEval(result);
	}
	double inputDerivEval(double result)  // evaluates the value of the derivative of a  function at a given point 
    {
        return polyDerivEval(result);
    }
     
	public static void main(String args[]) // for testing
	{
		NewtonRaphsonMethod obj = new NewtonRaphsonMethod();
		obj.calcNewtonRaphsonRoot();
	}
}



