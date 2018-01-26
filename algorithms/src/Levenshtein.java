import java.util.function.Supplier;
/*
Class to Test the computation of the Levenshtein Edit Distance between two strings.
Input is taken as command line arguments.
 */

public class Levenshtein {
    public static void main(String args[]){
        String a = args[0];         // first string input from the command line
        String b = args[1];         // second string input from the command line
        EditDistance ed = new EditDistance(a,b);
        time(() -> ed.calculateLevenshtein(a.length(), b.length()));
    }

    // benchmarking code to calculate the running time for the calculateLevenshtein method.
    public static <T> T time (Supplier<T> thunk) {
        System.out.println();
        try {
            long t0 = System.currentTimeMillis();
            T result = thunk.get();
            long t1 = System.currentTimeMillis();
            long t = t1 - t0;
            System.out.println (result
                    + " (in " + t + " milliseconds)");
            return result;
        }
        catch (Error e) {
            System.out.println ("\nERROR: " + e);
            return (T) null;
        }
    }
}

/*
Calculates the Levenshtein Distance between two strings.
The Levenshtein Edit Distance allows 3 operations to mutate a string,
    1. Insert a character
    2. delete a character
    3. Replace a character with another
*/
class EditDistance{
    String s1;      // first string
    String s2;      // second string
    int[][] memo;   // 2-D array to store previous calculations

    public EditDistance(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;

        // initialising the memo with s1.length() + 1 rows and s2.length() + 1 columns
        this.memo = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                // initialise array values to be -1 since edit Distance cannot be negative
                this.memo[i][j] = -1;
            }
        }
    }

    public int calculateLevenshtein(int i, int j){

        // Check if calculation has been done previously for given sizes
        if(this.memo[i][j] != -1)
            return this.memo[i][j];

        // base case when string 1 has been checked for the whole length
        if( i == 0){
            this.memo[i][j] = j;
            return j;
        }
        // base case when string 2 has been checked for the whole length
        else if(j == 0){
            this.memo[i][j] = i;
            return i;
        }
        // Case when characters at index i & j are equal
        else if(this.s1.charAt(i - 1) == this.s2.charAt(j - 1)){
            // calculate the edit distance and store in the memo
            this.memo[i][j] = Math.min(calculateLevenshtein((i - 1), (j - 1)),
                                1 + Math.min(calculateLevenshtein(i, (j - 1)),
                                                calculateLevenshtein((i - 1), j)));
            return this.memo[i][j];     // return computed value
        }
        // Case when characters at index i & j are not equal
        else{
            // calculate the edit distance and store in the memo
            this.memo[i][j] = Math.min(1 + calculateLevenshtein((i - 1), (j - 1)),
                                1 + Math.min(calculateLevenshtein(i, (j - 1)),
                                        calculateLevenshtein((i - 1), j)));
            return this.memo[i][j];     // return computed value
        }
    }
}