import java.util.*;
import java.math.*;

  class Polynomial
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




public class Euler
{
   

       static float f(float x,float y)
{
   return(1+(x*y));
    
}

   public static void main(String[] args) 
   {

       
   float x,y,xf,h,n;
   int i;
          Scanner s=new Scanner(System.in);       
      
   System.out.println("Solution by Euler Method\n");

   System.out.println("Enter initial Boundry condition x,y : ");
    x=s.nextFloat();
   y=s.nextFloat();
   System.out.println("Enter Interval ,h : ");
   h=s.nextFloat();
   
   System.out.println("Enter Value of X at which Y is required : ");
   xf=s.nextFloat();
   n=(xf-x)/h;
       System.out.println("\n  x\t  y\n");

   for(i=1;i<=(int)n;i++)
   {
      y=y+h*f(x,y);
      x=x+h;
      System.out.println(""+x+"    "+y);
   }
   System.out.println("----------------------------------------------------------\n");
System.out.println("Value of y @ "+xf+" is "+y);
 
  
   
}
   
}