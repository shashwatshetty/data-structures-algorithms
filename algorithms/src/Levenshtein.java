import java.util.function.Supplier;

public class Levenshtein {
    public static void main(String args[]){
        String a = args[0];
        String b = args[1];
        EditDistance ed = new EditDistance(a,b);
        time(() -> ed.calculateLevenshtein(a.length(), b.length()));
    }

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

class EditDistance{
    String s1;
    String s2;
    int[][] memo;

    public EditDistance(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
        this.memo = new int[s1.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                this.memo[i][j] = -1;
            }
        }
    }

    public int calculateLevenshtein(int i, int j){
        if(this.memo[i][j] != -1)
            return this.memo[i][j];
        if( i == 0){
            this.memo[i][j] = j;
            return j;
        }
        else if(j == 0){
            this.memo[i][j] = i;
            return i;
        }
        else if(this.s1.charAt(i - 1) == this.s2.charAt(j - 1)){
            this.memo[i][j] = Math.min(calculateLevenshtein((i - 1), (j - 1)),
                                1 + Math.min(calculateLevenshtein(i, (j - 1)),
                                                calculateLevenshtein((i - 1), j)));
            return this.memo[i][j];
        }
        else{
            this.memo[i][j] = Math.min(1 + calculateLevenshtein((i - 1), (j - 1)),
                                1 + Math.min(calculateLevenshtein(i, (j - 1)),
                                        calculateLevenshtein((i - 1), j)));
            return this.memo[i][j];
        }
    }
}