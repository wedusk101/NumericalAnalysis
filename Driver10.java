import java.util.Scanner;
class Bisection {
	
	void CalcBisectionRoot()
	{
		 float interval1,interval2,root=0,k;
		 Scanner s=new Scanner(System.in);
		
		   
		   System.out.println("Enter The Value Of interval1 :");
		   interval1=s.nextFloat();
		   System.out.println("Enter The Value Of interval2 :");
		   interval2=s.nextFloat();
		   if((f(interval1)*f(interval2))<0)
		   {
			   while(Math.abs(interval1-interval2)>0.00001)
			   {
				   root=(interval1+interval2)/2;
				   k=f(root);
				   if(f(interval1)*k>0)
					   interval1=root;
				   else
					   interval2=root;
			   }
			   System.out.println("The Calculated Root Is::"+root);
		   }
		   else
			   System.out.println("too many roots");
	}
		   
	float f(float x)
	{
	   return((x*x*x)-(4*x)-9);
	}
}
class Driver10
{
	public static void main(String args[])
	{
		Bisection p=new Bisection();
		p.CalcBisectionRoot();
	}
}
