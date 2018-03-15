/*
Implementation of the Longest Common Subsequence between two strings.
Problem is solved using Dynamic Programming by taking advantage
of the overlapping sub-problems and optimal substructure of the LCS.
 */
public class LongestCommonSubsequence {

    public static void main(String args[]){
        // correctness & timing examples
        Utilities.time(() -> lcsLength("HELLO", "AERLKO"));
        Utilities.time(() -> lcsLength("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
    }


    /*
    Pseudocode:
        LCS-LENGTH(X, Y)
            m = X.length
            n = Y.length
            Let b[1..m, 1..n] and c[o..m, 0..n] be new tables
            for i = 1 to m
                c[i, 0] = 0
            for j = 1 to n
                c[0, j] = 0
            for i = 1 to m
                for j = 1 to n
                    if x[i] == y[j]
                        c[i, j] = c[i - 1, j - 1] + 1
                        b[i, j] = "\"
                    elseif c[i - 1, j] >= c[i, j - 1]
                        c[i, j] = c[i - 1, j]
                        b[i, j] = "|"
                    else
                        c[i, j] = c[i, j - 1]
                        b[i, j] = "--"
            return c and b
     */

    /*
    Given: two strings
    Effect: prints the longest common subsequence of the given two strings.
     */
    public static int lcsLength(String X, String Y){
        // length of string 1
        int m = X.length();
        // length of string 2
        int n = Y.length();
        // table to store the length of the common subsequence seen so far.
        int[][] c = new int[m + 1][n + 1];
        // table to store how to traverse the path containing the LCS.
        char[][] b = new char[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                // when characters match,
                if(X.charAt(i - 1) == Y.charAt(j - 1)){
                    // add 1 to the length of the common subsequence so far
                    c[i][j] = c[i - 1][j - 1] + 1;
                    // symbol to indicate that last chars match
                    b[i][j] = '/';
                }
                // when common subsequence is longer when one char is removed from string 1
                else if(c[i - 1][j] >= c[i][j - 1]){
                    c[i][j] = c[i - 1][j];
                    // symbol to indicate that one char from string 1 should be deleted
                    b[i][j] = '|';
                }
                // when common subsequence is longer when one char is removed from string 2
                else{
                    c[i][j] = c[i][j - 1];
                    // symbol to indicate that one char from string 2 should be deleted
                    b[i][j] = '-';
                }
            }
        }
        // method to print the LCS
        printLCS(b, X, m, n);
        System.out.println();
        return c[m][n];
    }

    /*
    Pseudocode:
        PRINT-LCS(b, X, i, j)
            if i == 0 or j == 0
                return
            elseif b[i, j] == "\"
                PRINT-LCS(b, X, i - 1, j - 1)
                print x[i]
            elseif b[i, j] == "|"
                PRINT-LCS(b, X, i - 1, j)
            else
                PRINT-LCS(b, X, i, j - 1)
     */

    /*
    Given: the table for the traversal, one string, and index to check the characters
    Effect: prints the longest common subsequence as per the table.
     */
    public static void printLCS(char[][] b, String X, int i, int j){
        // base case
        if(j == 0 || i == 0){
            return;
        }
        // when characters match
        else if(b[i][j] == '/'){
            // recursively call with one character less from both indexes
            printLCS(b, X, i - 1, j - 1);
            // print the character
            System.out.print(X.charAt(i - 1));
        }
        // when one character needs to be removed from string 1
        else if(b[i][j] == '|'){
            // recursively call with one character less from first index
            printLCS(b, X, i - 1, j);
        }
        // when one character needs to be removed from string 2
        else{
            // recursively call with one character less from second index
            printLCS(b, X, i, j - 1);
        }
    }
}
