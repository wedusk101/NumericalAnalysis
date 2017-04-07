import java.util.*;
public class Main 
{
    private static int[] coef;      // array of coefficients
    static int degree;            // highest power of the polynomial
    
    void initalise(int degree1)
    {
    	Scanner s=new Scanner(System.in);
    	degree=degree1;
    	coef=new int[degree+1];
 	    for(int index=degree;index>=0;index--)
 	    {
 	    	coef[index]=0;
 	    }
 	    for(int index=degree;index>=0;index--)
 	    {
 	    	System.out.println("Enter the coefficient of x to the power "+index);
 	    	coef[index]=s.nextInt();
 	    			
 	    }
    }
    public static double secant(int n,double x,double x1)
    {
    	int k = 0;
    	double x2=0;
	    while(n!=k)
	    	{
	    		
	    		double d = f(x1)-f(x);
	        	x2 = x1-((f(x1)*(x1-x))/d);
	        	x  = x1;
	        	x1 = x2;
	        	k++;
	    	}
    	return x1;
    }
	public static double f(double x) 
	{
			//return 230*x*x*x*x+18*x*x*x+9*x*x-221*x-9;
		double s=1.0,sum=0.0;
		
			for(int index=degree;index>=0;index--)
			{
				if(coef[index]!=0)
				{
					for(int i=0;i<index;i++)
					{
						s=s*x;
					}
					s=s*coef[index];
					sum=sum+s;
					s=1.0;
				}
			}
			return sum;
	}
	public static void main(String args[])
	{
		Main obj=new Main();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the highest degree:");
		int highDeg=s.nextInt();
		obj.initalise(highDeg);
		double del = 1e-6;
		System.out.println("Enter x0:");
		double X0=s.nextDouble();
		System.out.println("Enter x1:");
		double X1=s.nextDouble();
		double dx = 1, x =X0, x1=X1;
		System.out.println("Enter the no of iterations:");
		int n=s.nextInt();
	    x = secant(n,x,x1);
	    System.out.println("Root obtained: " + x);
		
		
		//double d=obj.f(X);
		//System.out.println("The value of the function:"+d);
	}
}
