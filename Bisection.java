import java.util.Scanner;
class Bisection {
	
	static final double EPSILON = 0.000006;                                         /*EPSILON being the prescribed accuracy*/
	
	void CalcBisectionRoot()                                                                /*Function definition to calculating the root by the method of Bisection*/
	{
		 double  interval1 = 0.0,interval2 = 0.0,root=0.0,k = 0;
		 Scanner s=new Scanner(System.in);
		
		   
		   System.out.println("Enter The Value Of interval1 :");        /*Taking the value from first interval of the function from user*/
		   interval1=s.nextFloat();
		   System.out.println("Enter The Value Of interval2 :");      /*Taking the value from second interval of the function from user*/		   
                                   interval2=s.nextFloat();
		   if((f(interval1)*f(interval2))<0)                                      /*Multiplication of the function of two interverals where the root lies between, must be less than zero*/
		   {
			   while(Math.abs(interval1-interval2)>EPSILON)       
			   {
				   root=(interval1+interval2)/2;         /*iterative formula of Bisection method*/
				   k=f(root);
				   if(f(interval1)*k>0)
					   interval1=root;
				   else
					   interval2=root;
			   }
			   System.out.println("The Calculated Root Is::"+root);      /*printing the desired root*/ 
		   }
		   else
			   System.out.println("No real roots on this interval. OPERATION ABORTED.");       /*print when  root doesn't found*/
	}
		   
	float f(float x)                                                 /*Function definition to take a default polynomial to test the above function*/  
	{
	   return((x*x*x)-(4*x)-9);
	}
}
class Driver10                       /*Mainclass open*/
{
	public static void main(String args[])
	{
		Bisection p=new Bisection();
		p.CalcBisectionRoot();
	}
}                              /*Main class closed*/
