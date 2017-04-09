/* Gauss Jocobi Method */

import java.util.*;
import java.io.*;

class GaussJacobi
{
	float a[][]=new float[20][20]; /*Array for Taking Co-Efficients */
	float x[]=new float[20]; /* To Show Solution */
	float e; /* User-Input to accept Error */
	float big;
	float relerror; /* Variable to store Relative Error */
	float temp; /* To store Temorary Value */
	float sum; /* Variable to Calculate Solution */
	int n; /* To store Size of the Equation */
	int maxit; /* to store Maximum Iteration Size from the User's perspective */
	int itr;
	
	Scanner s=new Scanner(System.in);
	BufferedReader ad=new BufferedReader(new InputStreamReader(System.in));
	
	public void checkGaussJ()
	{
		System.out.print("\nEnter the Size of the Equation:- ");
		n=s.nextInt();
		try
		{
			for(int i=1;i<=n;i++)
			{
				System.out.println("\nEnter the coefficints of equation "+i+" and R.H. Side Row-Wise:- ");
				for(int j=1;j<=n+1;j++)
				{
					a[i][j]=Float.valueOf(ad.readLine());
				}
			} /* for loop closed */
			System.out.println("\nEnter Relative Error and Number of Iterations:- ");
			e=s.nextFloat();
			maxit=s.nextInt();
			for(int i=1;i<=n;i++)
				x[i]=0;
			for(itr=1;itr<=maxit;itr++) /* 'itr' refers 'Iteration' */
			{
				big=0;
				for(int i=1;i<=n;i++)
				{
					sum=0;
					for(int j=1;j<=n;j++)
					{
					if(i!=j)
	                  sum=sum+a[i][j]*x[j];
					}
					temp=((a[i][n+1]-sum)/a[i][i]);
					relerror=Math.abs((x[i]-temp)/temp);
					if(relerror>big)
						big=relerror;
					x[i]=temp;
				}
				if(big<=e)
				{
					System.out.print("\nConverges to a solution in "+itr+ " iterations\n");
					for(int i=1;i<=n;i++)
					System.out.println();
					System.out.println(" "+x[i]);
					System.exit(0);
				}
			}
			System.out.print("\nDoes not Converge in "+maxit+" iteration \n");
		} /* try-b;ock ends here */
		catch(Exception e)
		{}
		
	}
}

class GaussJacobiMethod
{
	public static void main(String[] h)
	{
		GaussJacobi obj=new GaussJacobi();
		obj.checkGaussJ();
	}
}
	
	