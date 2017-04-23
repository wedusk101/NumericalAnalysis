/********************************************************************************************************************** 	
    The following code implements the Newton Forward Interpolation. It is implemented as apart of the java package "com.numerical" 
    This piece of code has the following components and dependencies.
	
    inputParameters() - Returns void - This method is used by the user to input the parameters
	
    differenceCal() - Returns void - 
    
    showDifferences() - Returns void -  
    
    fact() - Returns integer - This method is used to calculate factorial of a number recursively.
     
    forwardCal() - Returns void -  
     
    main() - Returns void - Provided for testing the code. Commented out over here.
	
    Implementation Details
    ----------------------
	
	
**********************************************************************************************************************/

package com.numerical;

import java.util.Scanner;

public class Forward 
{
    double x[];     // array to hold interpolating points of the interpolating polynomial
    double y[][];   // two-dimensional array to hold the functional values of the interpolating polynomial at the respective nodes
    int n;         // variable to store number of nodes
    double pivot;   // variable to store the node at which the functional value is to be found out
    
    /*Method to input all the parameters required to solve a problem using ForwardInterpolation*/
    
    public void inputParameters()
    {
        /*Declaration of variable to store the spacing of points*/
        double initialSpace,currentSpace;
        
        /*Creating object of Scanner Class*/
        Scanner obj=new Scanner(System.in);     
	System.out.println("\nPlease enter number of nodes...\n");
        try
        {
            n=obj.nextInt();      // accepting from the user the number of nodes to be inserted
            
            /*Initializing arrays with desired length*/ 
            
            x=new double[n];
            y=new double[n][n];
            
            /*Accepting the interpolationg points and the corresponding functional values*/
            
            for(int i=0;i<n;++i)
            {
                System.out.print("\nEnter the value of x"+i+": ");
                x[i]=obj.nextDouble();     //Interpolating Points
                
                /*Checking for Unequal Spaced Interpolating Points*/
                if(i>1)
                {
                    initialSpace=x[i-1]-x[i-2];
                    currentSpace=x[i]-x[i-1];
                    if(initialSpace!=currentSpace)
                    {
                        System.out.println("Not equal spaced Interpolating  points.");
                        System.out.println("Please try again with correct values.");
                        System.exit(1);
                    }
                }
                System.out.print("\nEnter the value of y"+i+": ");
                y[0][i]=obj.nextDouble();  // Corresponding functional values
            }
            
            System.out.println("\nEnter x for finding f(x): ");
            pivot=obj.nextDouble();   // Accepting the point at which the functional value is required
            
            /*Condition to check if the user given point is an extrapolating point*/
            if(pivot<x[0] || pivot>x[n-1])
            {
                System.out.println("The value of x "+pivot+" does not lies between ["+x[0]+","+x[n-1]+"]");
                System.out.println("Please try again with correct values.");
                System.exit(1);
            }
	}
        catch(Exception e)
        {
            System.out.println("Exception Occured.\nPlease Try Again with other values.");
            System.exit(1);
        }
    }

    /*Method to calculate differences and store it in a matrix 'y'*/

    public void differencesCal()      //  function definition to calculate differences
    {
	for(int loop1=1;loop1<n;++loop1)     // outer loop running from the second node to the last node
            for(int loop2=0;loop2<n-loop1;++loop2)    // inner loop running from the first node
		y[loop1][loop2]=y[loop1-1][loop2+1]-y[loop1-1][loop2];   // calculating the differences and storing it to the functional value arrays
    }

    /*Method to display the User Input and the Difference Table*/
    
    public void showDifferences()       //  function definition to show the differences
    {
	System.out.print("\n\n_____________________________________________\n\n");
	System.out.print("\n x(i)\t y(i)\t y1(i)\t y2(i)\t y3(i)\t y4(i)");
	System.out.print("\n\n_____________________________________________\n\n");
	for(int loop1=0;loop1<n;++loop1)
	{
            System.out.print("\n "+x[loop1]);
            for(int loop2=0;loop2<n-loop1;++loop2)
            {
		System.out.printf("   %.3f",y[loop2][loop1]);
            }
            System.out.print("\n");
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
    
    /*Method to calculate the functional value at 'pivot' using Newton Forward Interpolation concept*/
    
    public void forwardCal()      // function definition to calculate the functional value at 'pivot'
    {
        /*Variables to store the phase,sum & temporary values*/
        
        double u,sum=0,temp;
        
        /*Necessary variables declaration*/
	
	int i,f,k=0,m,l;   
        
        /*Method Call to input the parameters, store the differences and to display it to the user*/
        
        inputParameters();
	differencesCal();
	showDifferences();
	i=0;       // initializing a counter variable
	do
	{
            if(x[i]<pivot && pivot<x[i+1])   // condition to reach the point where 'pivot' is exactly between to given nodes
		k=1;                         // initializing to stop the loop; required point is reached
            else
		++i;                         // keep on increasing the index by 1 to reach the next node
	}while(k!=1);                        // stopping condition

	f=i;                                 // storing the index of the node immediately after which, 'pivot' is present
	u=(pivot-x[f])/(x[f+1]-x[f]);        // calculating phase
        
        /*Newton's Forward requires this phase, u to belong in (0,1)*/
	if(u<0.0 || u>1.0)
	{
            System.out.println("Error");
            System.exit(1);
	}
	System.out.println("\n\n u="+u);     // Print phase
	l=n-i+1;  // an attempt to avoid "noise-level"    
	if(l>n)   // condition to avoid StringIndexOutOfBoundsException
            l=n;  // initializing accordingly
	else 
            n=l;    // initializing accordingly
	
        /*initializing sum to its initial value*/
	sum=0;
	for(int loop1=0;loop1<n;++loop1)     // outer loop
	{
            temp=1;    // variable used to calculate coefficients
            for(int loop2=0;loop2<loop1;++loop2)  // inner loop to find the successive products 
            {
		temp=temp*(u-loop2);
            }   // end of inner loop
            m=fact(loop1);   // denominator of the coefficients
            sum=sum+temp*(y[loop1][f]/m);    // multiplying the coefficients and the multipliers and storing the desired sum
	}  // end of outer loop
	System.out.println("\n\n f("+pivot+")="+sum+".");    // printing sum	
    }   // end of method
//}

}

/*For Testing*/
/*    public static void main(String[] args) 
    {        
        Forward fwd=new Forward();
        fwd.forwardCal();
    }

}*/
