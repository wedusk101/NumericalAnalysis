import com.numerical.*;
import java.util.Scanner;
public class TestNumerical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); // this is just to test the successful creation of a Scanner class object
		System.out.println("Please enter your name.");
		String name = in.nextLine();
		System.out.println(name);
		System.out.println("Regula Falsi Method");
		RegulaFalsiMethod rf = new RegulaFalsiMethod();
		rf.calcFalseRoot();
		System.out.println("Bisection Method");
		BisectionMethod obj = new BisectionMethod();
		obj.calcBisectionRoot();
		in.close();
		}

}
