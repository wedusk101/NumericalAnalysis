import java.util.Scanner; /*importing the Scanner class of the 'util' package to accept necessary inputs from the user*/


public class BackwardDriver 
{    
    public static void main(String[] args)     // start of main 
    {    
	Scanner sc=new Scanner(System.in);   //creating object of the scanner class
	/*Decalaration of array to store all the interpolationg points, and matrix to store differeence table*/
        double x[],y[][];
        /*Declaration of variable to store the pivot element and other variables to store the spacing of points*/
        double pivot=0,h,space;
	int n;         //Varaible to store the number of nodes required
	boolean check=true;     
	System.out.println("\nPlease enter number of nodes...\n");
	n=sc.nextInt();      // accepting from the user the number of nodes to be inserted
	/*Initializing arrays with the desired length*/ 
	x=new double[n];
	y=new double[n][n];     
	
        /*Accepting the interpolationg points and the corresponding functional values*/
        
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
            System.out.println(x+" does not lies between ["+x[0]+","+x[n-1]+"]");
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
    }    //End of main()
}    //End of class