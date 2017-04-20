package com.numerical; 
import java.util.Scanner; /*importing the Scanner class of the 'util' package to accept necessary inputs from the user*/


class Backward
{
    double x[];     // array to hold interpolating points
    double y[][];   // two-dimensional array to hold the functional values of the interpolating polynomial
    int n;         // variable to store number of nodes
    double pivot;   // variable to store the node at which the functional value is to be found out
    public Backward(double x[],double y[][],int n,double pivot)   // parameterized constructor passing all the instance variables 
    {
	/*Array Creation of desired length creating array*/
	this.x=new double[n];			
	this.y=new double[n][n];     
	this.x=x;
	this.y=y;
	this.n=n;
	this.pivot=pivot;       
    }
    
    /*Method to calculate differences and store it in a matrix 'y'*/
    
    
    public void differencesCal()
    {
        int k=1;
        for(int i=0;i<n;i++) 
        {
            for(int j=0;(i+j)<(n-1);j++)
                y[i+j+1][k]=y[i+j+1][i]-y[i+j][i];
            k++;
        }
    }
    
    /*Method to display the User Input and the Difference Table*/
    
    
    public void showDifferences()
    {
        System.out.print("\n x(i)\t\t   y(i)\t\t             y1\t\t              y2\t\t        y3\t\t      y4");
        for(int i=0;i<n;i++)
        {
            System.out.print("\n "+x[i]);
            for(int j=0;j<n;j++)
            {
                if(y[i][j]!=0)
                    System.out.printf("               %.5f",y[i][j]);
            }
            System.out.println();
        }
    }
    
    /*Method to calculate Factorial of Number*/
    
    
    int fact(int num)
    {
        if(num==0)
            return 1;
        else
            return num*(fact(num-1));
    }
    
    /*Method to calculate the functional value at 'pivot' using Newton Backward Interpolation concept*/
    
    
    public void backwardCal()
    {
        /*Variables to store the phase,sum & temporary values*/
        double u,sum=0,temp;
        /*Necessary variables declaration*/
	int i,k=0,m,l,pos;   
        /*Method Call to store the differences and to display it to the user*/
	differencesCal();
	showDifferences();
        
	i=(n-1);       // initializing a counter variable
	do
	{
            if(x[i]>pivot && pivot>x[i-1])   // condition to reach the point where 'pivot' is exactly in between two given nodes
		k=1;                         // initializing to stop the loop; required point is reached
            else
		i--;                         // attempt to fetch value of previous node
	}while(k!=1);                        // stopping condition
        pos=i;                               // storing the index of the node immediately after which, 'pivot' is present
	u=(pivot-x[pos])/(x[1]-x[0]);        // calculating phase
        if((Math.abs(u))<0.0 || (Math.abs(u))>1.0)
        {
            System.out.println("Error");
            System.exit(1);
        }
	System.out.println("\n\n Phase (u)="+u);     // Prints phase value
        l=0;
	for(int loop1=0;loop1<n;++loop1)     // outer loop
        {
            temp=1;    // variable used to calculate coefficients
            for(int loop2=0;loop2<loop1;++loop2)  // inner loop to find the successive products 
		temp=temp*(u+loop2);
            m=fact(loop1);   // denominator of the coefficients
            sum=sum+temp*(y[pos][l++]/m);    // multiplying the coefficients and the multipliers and storing the desired sum
	}  // end of outer loop
	System.out.println("\n\n f("+pivot+")=");
        System.out.printf("%.5f.",sum);    // printing sum	
    }   // end of method
} // end of class







/*Definition Of Class named "BackwardDriver" that will contain the main() method to run the code for generating functional value at a given point using the process of Backward Interpolation.*/




class BackwardDriver 
{    
    public static void main(String[] args)     // start of main 
    {    
	Scanner sc=new Scanner(System.in);   //creating object of the scanner class
	/*Declaration of array to store all the interpolating points, and matrix to store difference table*/
        double x[],y[][];
        /*Declaration of variable to store the pivot element and other variables to store the spacing of points*/
        double pivot=0,h,space;
	int n;         //Variable to store the number of nodes required
	boolean check=true;     
	System.out.println("\nPlease enter number of nodes...\n");
	n=sc.nextInt();      // accepting from the user the number of nodes to be inserted
	/*Initializing arrays with the desired length*/ 
	x=new double[n];
	y=new double[n][n];     
	
        /*Accepting the interpolating points and the corresponding functional values*/
        
	for(int i=0;i<n;i++)
	{
            System.out.print("\nEnter the value of x"+i+": ");
            x[i]=sc.nextDouble();   // Interpolating Points
            System.out.print("\nEnter the value of y"+i+": ");
            y[i][0]=sc.nextDouble();  // Corresponding functional values
	}
	h=x[1]-x[0];  // calculating step-length
	h=Double.parseDouble(String.format("%.1f",h));   // for some inputs the floating point representations can hamper the desires result; so setting precision for such floating point numbers
	
        /*Checking for Unequally spaced Interpolating Points and condition where Pivot element is out of range */
        for(int i=0;i<n-1;i++)
	{
            space=x[i+1]-x[i];
            space=Double.parseDouble(String.format("%.1f",space));        // for some inputs the floating point representations can hamper the desires result; so setting precision for such floating point numbers
            if(space!=h)  // if condition to check if the interpolating points are not equi-space
		check=false;   // changing the value of the check variable to keep a note that an exception has taken place   
	}
        if(check==false)
        {
            System.out.println("Not equal spaced Interpolating  points.");
            System.out.println("Please try again with correct values.");
            System.exit(1);
        }
        System.out.println("\nEnter x for finding f(x): ");
	pivot=sc.nextDouble();   // accepting the point at which the functional value is required
        if(pivot<x[0] || pivot>x[n-1])  // condition to check if the user given point is an extrapolating point
	{
            check=false;  // changing the value of the check variable to keep a note that an exception has taken place
            System.out.println(x+" does not lie between ["+x[0]+","+x[n-1]+"]");
            System.out.println("Please try again with correct values.");
            System.exit(1);
        }
        
        /*Object creation of "Backward" Class if all condition evaluates to be TRUE*/
        
	if(check)
	{
            Backward back=new Backward(x,y,n,pivot);
            back.backwardCal();
	}
	else  // if exception has occurred
	{
            System.out.println("\nINHERENT ERROR.\n");    // there are some errors in the entered entries
	}
	sc.close();
    }    //End of main()
}    //End of class