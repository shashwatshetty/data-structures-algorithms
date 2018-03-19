import java.math.BigInteger;
/*
Calculates the Greatest Common Divisor of any two numbers.
 */
public class GCD {
    private final static BigInteger ZERO = new BigInteger("0");
    /*
    Pseudocode:
        EUCLID(a, b)
            if b == 0
                return a
            else
                return EUCLID(b, a mod b)
     */

    /*
    Given: Two non negative integers
    Returns: the Greatest Common Divisor of the two integers
     */
    public static BigInteger euclid(BigInteger a, BigInteger b){
        // compareTo returns -1 if less or 0 if equal
        if(b.compareTo(ZERO) <= 0){
            // returns the gcd since gcd(a, 0) = |a|
            return a;
        }else{
            // based on the theorem that gcd(a, b) = gcd(b, a mod b)
            return euclid(b, a.mod(b));
        }
    }

    /*
    Below pseudo-code is to calculate co-efficient for only one number
    Pseudocode:
        INVERSE(a, b)
            t = 0
            newt = 1
            r = b
            newr = a
            while newr != 0
                quotient = floor(r/newr)
                (t, newt) = (newt, t - quotient * newt)
                (r, newr) = (newr, r - quotient * newr)
            return t
     */

    /*
    Given: Two non negative integers
    Returns: an array of two values which are the co-efficients of Bezout's Identity
     */
    public static BigInteger[] extendedEuclid(BigInteger a, BigInteger b){
        // initially, a = a * s0 + b * t0, since s0 = 1 & t0 = 0
        BigInteger s0 = new BigInteger("1");
        BigInteger t0 = new BigInteger("0");

        // initially, b = a * s1 + b * t1, since s1 = 0 & t1 = 1
        BigInteger s1 = new BigInteger("0");
        BigInteger t1 = new BigInteger("1");
        // initial remainder values
        BigInteger r0 = a, r1 = b;
        // variables that will be calculated iteratively
        BigInteger newR, newS, newT, q;

        // run till remainder is 0
        while(!r1.equals(ZERO)){
            // calculate quotient
            q = r0.divide(r1);
            // new value for r
            newR = r0.mod(r1);
            // new value for s
            newS = s0.subtract(q.multiply(s1));
            // new value for t
            newT = t0.subtract(q.multiply(t1));

            // make r0 as r1 and r1 as newR
            r0 = r1;
            r1 = newR;
            // make s0 as s1 and s1 as newS
            s0 = s1;
            s1 = newS;
            // make t0 as t1 and t1 as newT
            t0 = t1;
            t1 = newT;
        }
        BigInteger res[] = {s0, t0};
        return res;
    }

    public static void main(String args[]){
        BigInteger a = new BigInteger("996258377182845111222");
        BigInteger b = new BigInteger("21701961903082978934739");
        BigInteger gcd = Utilities.time(() -> euclid(a, b));
        System.out.println("The GCD Using the Euclid method is: " + gcd);
        BigInteger[] coeffs = extendedEuclid(a, b);
        BigInteger x = coeffs[0];
        BigInteger y = coeffs[1];
        System.out.println("The Co-Efficients of Bezout's Identity are: " + x + " " + y);
        System.out.println("The GCD Using Bezout's Identity is: " + a.multiply(x).add(b.multiply(y)));
    }
}
