public class Polynomial 
{
 private int[] coef;  // coefficients
 private int deg;     // degree of polynomial (0 for the zero polynomial)


 public Polynomial(int a, int b) // a * x^b
 {
        coef = new int[b+1]; //increase in size of array after each term is added
        coef[b] = a;         //setting the coefficient for respective exponent value here represented by index value
        deg = degree();      //fetching the new degree after the addition of the abpve term
 }

    
 public int degree() // return the degree of this polynomial (0 for the zero polynomial)
 {
        int d = 0;                            
        for (int i = 0; i < coef.length; i++) // traversing the entire array length
            if (coef[i] != 0) d = i;          // calculating the highest degree for which a valid coefficient is form
        return d;                             //highest degree is returned
 }
 public Polynomial times(Polynomial b)
 {
         Polynomial a = this;                                // a is a Polynomial class object which is initialised here by the object instance by which this method was invoked
         Polynomial c = new Polynomial(0, a.deg + b.deg);
         for (int i = 0; i <= a.deg; i++)
             for (int j = 0; j <= b.deg; j++)
                 c.coef[i+j] += (a.coef[i] * b.coef[j]);
         c.deg = c.degree();
         return c;
 }
 
 public Polynomial plus(Polynomial b) // return c = a + b
 {
     Polynomial a = this;
     Polynomial c = new Polynomial(0, Math.max(a.deg, b.deg));
     for (int i = 0; i <= a.deg; i++) c.coef[i] += a.coef[i];
     for (int i = 0; i <= b.deg; i++) c.coef[i] += b.coef[i];
     c.deg = c.degree();
     return c;
 }

    
 public Polynomial eval(Polynomial b) // return a(b(x))  - compute using Horner's method
 {
        Polynomial a = this;
        Polynomial c = new Polynomial(0, 0);
        for (int i = a.deg; i >= 0; i--)
        {
            Polynomial term = new Polynomial(a.coef[i], 0);
            c = term.plus(b.times(c));
        }
        return c;
 }
}
