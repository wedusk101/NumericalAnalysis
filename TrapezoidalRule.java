import java.util.*;
import java.math.*;

public class TrapezoidalRule 
{

    static class Polynomial
{
	    private int[] coef;    // array of coefficients
	    private int[] exp;     // array of exponents 
	    int degree;            // highest power of the polynomial
	    Scanner s=new Scanner(System.in);
	    Polynomial(int degree)
	    {
	    	this.degree=degree;
	    	int[] coef=new int[degree];
	 	    int[] exp =new int[degree];
	 	    for(int index=0;index<degree;index++)
	 	    {
	 	    	System.out.println("Enter the coefficient");
	 	    	coef[index]=s.nextInt();
	 	    	System.out.println("Enter the respective exponent");
	 	    	exp[index] =s.nextInt();		
	 	    }
	    }
	    
}

   static double f(double x,Polynomial p) {
       double sum=0;
       for (int i = 0; i <= p.degree; i++) //loop will run till the highest degree of polynomial
       {
           double prod=p.coef[i];   //taking coefficients from the array
           
           
           for (int j = 0; j < p.exp[j]; i++)
           {
               prod=prod*x;  
           }
           sum=sum+prod;
       }
      return sum;
   }

  /*
   * Integrate f from a to b using the trapezoidal rule.
   * Increase N for more precision.
   */
   static double integrateTrapezoid(double lower, double upper, int interval, Polynomial p) {
      double h = (upper - lower) / interval;              // step size
      double sum = 0.5 * (f(lower,p) + f(upper,p));    //calculating 1st and last means y0 and yn
      for (int i = 1; i < interval; i++) 
      {
         double x = lower + h * i;      //incrementing value of x with respect to h  
         sum = sum + f(x,p);            //calculating sum from y1 to y(n-1)
         
      }

      return sum * h;
   }


   // sample program
   public static void main(String[] args) {
             Scanner s=new Scanner(System.in);       
       System.out.println("Enter the highest degree of polynomial");
       int degree=s.nextInt();
       Polynomial p=new Polynomial(degree);
      double lower = 2;
      double upper = 7;
      System.out.println(integrateTrapezoid(lower, upper, 5,p));
   }
   

}




