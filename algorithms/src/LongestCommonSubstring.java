/*
Extracts the Longest Common Substring among two strings.
    Pseudocode:
        LCSUBSTR(S, T)
            Let L be an array L[1..r, 1..n]
            z = 0
            ret = {}
            for i = 1 to r
                for j = 1 to n
                    if S[i] == T[i]
                        if i == 1 or j == 1
                            L[i, j] = 1
                        else
                            L[i, j] = L[i - 1, j - 1] + 1
                            if L{i, j] > z
                                z = L[i, j]
                                ret = S[i - z + 1..i]
                            else
                                if L[i, j] == z
                                    ret = ret U S[i - z + 1..i]
                    else
                        L[i, j] = 0
            return ret
 */
public class LongestCommonSubstring {
    public static String longestSubstringLength(String X, String Y){
        // table to store the indexes of where the characters match
        int[][] L = new int[X.length()][Y.length()];
        // stores the length of the longest substring
        int max = 0;
        // stores the last index of the longest common substring
        int lastIndex = 0;
        // outer loop checks for every character of first string
        for(int i = 0; i < X.length(); i++){
            // inner loop checks for every character of second string
            for(int j =0; j < Y.length(); j++){
                // when character matches
                if(X.charAt(i) == Y.charAt(j)){
                    // check if it is the first row or column
                    if(i == 0 || j == 0){
                        L[i][j] = 1;
                    }else{
                        // use earlier calculated longest length and add one
                        L[i][j] = L[i - 1][j - 1] + 1;
                        // check which is greater
                        if(L[i][j] > max){
                            // store length of the longest substring
                            max = L[i][j];
                            // index of the last character of the common substring
                            lastIndex = i;
                        }
                    }
                }
                // when characters do not match
                else{
                    // assign length as 0
                    L[i][j] = 0;
                }
            }
        }
        // extract substring which will be the longest
        String longSubstring = X.substring(lastIndex - max + 1, lastIndex + 1);
        return longSubstring;
    }

    public static void main(String args[]){
        String s1 = "shashwat";
        String s2 = "quizgeeksare";
        String r = longestSubstringLength(s1, s2);
        System.out.println("LCS: "+r);
    }
}
