import static java.lang.System.*;
import java.util.Scanner;
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
	 	    	out.println("Enter the coefficient");
	 	    	coef[index]=s.nextInt();
	 	    	out.println("Enter the respective exponent");
	 	    	exp[index] =s.nextInt();		
	 	    }
	    }
	    
}
