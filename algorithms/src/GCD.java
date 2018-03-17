import java.math.BigInteger;
/*
Calculates the Greatest Common Divisor of any two numbers.
 */
public class GCD {
    /*
    Pseudocode:
        EUCLID(a, b)
            if b == 0
                return a
            else
                return EUCLID(b, a mod b)
     */

    /*
    Given: Two numbers
    Returns: the Greatest Common Divisor of the two numbers
     */
    public static BigInteger euclid(BigInteger a, BigInteger b){
        // compareTo returns -1 if less or 0 if equal
        if(b.compareTo(new BigInteger("0")) <= 0){
            // returns the gcd since gcd(a, 0) = |a|
            return a;
        }else{
            // based on the theorem that gcd(a, b) = gcd(b, a mod b)
            return euclid(b, a.mod(b));
        }
    }

    public static void main(String args[]){
        BigInteger a = new BigInteger("996258377182845111222");
        BigInteger b = new BigInteger("21701961903082978934739");
        BigInteger gcd = euclid(a, b);
        System.out.println("The GCD Using the Euclid method is: " + gcd);
    }
}
