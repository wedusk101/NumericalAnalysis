import java.util.Scanner;

public class Polynomial 
{
	private int coef[];  // coefficients
	private int deg;     // degree of polynomial (0 for the zero polynomial)
	Scanner s = new Scanner(System.in);
	
	private void getDegree()
	{
		System.out.println("Enter the highest degree for the Polynomial");
		deg = s.nextInt();
	} 
	
	private void getCoef()
	{
		for(int i = coef.length - 1; i >= 0; i--)
		{
			System.out.println("Enter the Coefficient value when exponent of the term is\t"+i);
			coef[i] = s.nextInt();
		}
		s.close();
	}

	public Polynomial()
	{
		getDegree();      
        coef = new int[deg + 1];
        getCoef();       
	}

	public double evaluate(double x)
	{
		double result = 0;
		for (int i = coef.length-1; i >= 0; i--)
			result = coef[i] + (x * result);
		return result;
	}

	/*public static void main(String[] args) //for testing
	{
		Polynomial p1;
		p1=new Polynomial();
		double c=p1.evaluate(2);
		System.out.println(c);

	}*/
}