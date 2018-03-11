import java.util.ArrayList;
import java.util.List;

/*
Performs Naive String Matching between two strings and prints the Shifts of Occurences.
    Pseudocode:
        NAIVE-STRING-MATCHER(T, P)
            n = T.length
            m = P.length
            for s = 0 to n - m
                if T[s + 1..s + m] == P[1..m]
                    print "Pattern occurs with shift" s
 */
public class NaiveStringMatching {

    /*
    Given: two strings, a text and a pattern
    Returns: an integer array of all the shifts where the pattern occurs in the given text
    Run-Time: Big-O((n - m + 1).m) in worst case.
     */
    public static int[] naiveStringMatcher(String t, String p){
        // text length
        int n = t.length();
        // pattern length
        int m = p.length();
        // List to store the shifts
        List<Integer> occurences = new ArrayList<>();
        // run for loop upto n - m
        for(int s = 0; s <= n - m; s++){
            // extract substring of length m and compare with pattern
            if(t.substring(s, s + m).equals(p)){
                // add to list if match found
                occurences.add(s);
            }
        }
        // code to convert the list to integer array
        int[] result = new int[occurences.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = occurences.get(i);
        }
        return result;
    }

    public static void printArray(int[] res){
        System.out.print("Pattern Occurs at following Shifts: ");
        for(int e : res) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        String text = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
        String pat1 = "AA";
        String pat2 = "GCC";
        int[] pat1_res = naiveStringMatcher(text, pat1);
        int[] pat2_res = naiveStringMatcher(text, pat2);
        printArray(pat1_res);
        printArray(pat2_res);
    }
}
