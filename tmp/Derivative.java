/*The following code calculates the derivative of a function 
at a point from ab initio or first principle*/
import java.util.Scanner;
class Derivative
{
	static final double EPSILON = 0.000006;
	
	public static double calcDerivative(String func, double val)
	{
		double ddx = 0.0;
		
		if(func.equalsIgnoreCase("sin x") || func.equalsIgnoreCase("sinx")) // basic trigonometric functions
		{
			ddx = (Math.sin(val + EPSILON) - Math.sin(val)) / EPSILON;
		}
		
		else if(func.equalsIgnoreCase("cos x") || func.equalsIgnoreCase("cosx"))
		{
			ddx = (Math.cos(val + EPSILON) - Math.cos(val)) / EPSILON;
		}
		
		else if(func.equalsIgnoreCase("tan x") || func.equalsIgnoreCase("tanx"))
		{
			ddx = (Math.tan(val + EPSILON) - Math.tan(val)) / EPSILON;
		}
		
		else if(func.equalsIgnoreCase("atan x") || func.equalsIgnoreCase("atanx") || func.equalsIgnoreCase("arctan x") || func.equalsIgnoreCase("arctanx"))
		{
			ddx = (Math.atan(val + EPSILON) - Math.atan(val)) / EPSILON;
		}
		
		else if(func.equalsIgnoreCase("asin x") || func.equalsIgnoreCase("asinx") || func.equalsIgnoreCase("arcsin x") || func.equalsIgnoreCase("arcsinx"))
		{
			ddx = (Math.asin(val + EPSILON) - Math.asin(val)) / EPSILON;
		}
		
		else if(func.equalsIgnoreCase("acos x") || func.equalsIgnoreCase("acosx") || func.equalsIgnoreCase("arccos x") || func.equalsIgnoreCase("arccosx"))
		{
			ddx = (Math.acos(val + EPSILON) - Math.acos(val)) / EPSILON;
		} // end of basic trigonometric functions
		
		else
		{
			System.out.println("Invalid Input! Operation aborted.");
			System.exit(1);
		}				
		return ddx;
	}
}

class DriveDerivative
{
	public static void main(String args[])
	{
		String function;
		double value = 0.0;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter the function which you want to differentiate.");
		function = in.nextLine();
		System.out.println("Please enter the point where you want to calculate the derivative.");
		value = in.nextDouble();
		Derivative dr = new Derivative();
		System.out.println("The value of the derivative of the function at the given point is " + dr.calcDerivative(function, value) + ".");
		in.close();		
	}
}