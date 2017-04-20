package com.numerical;
import java.util.*;
import java.math.*;

public class TrapezoidalRule extends Polynomial
{

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
      double h = (upper - lower) / (double)interval;              // step size
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
             Scanner in=new Scanner(System.in);       
       System.out.println("Enter the highest degree of polynomial");
       int degree=in.nextInt();
       Polynomial p=new Polynomial(degree);
      double lower = 2;
      double upper = 7;
      System.out.println(integrateTrapezoid(lower, upper, 5,p));
	  in.close();
   }
}
   





