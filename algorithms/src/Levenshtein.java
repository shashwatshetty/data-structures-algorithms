public class Levenshtein {
    public static void main(String args[]){
        String a = args[0];
        String b = args[1];
        EditDistance ed = new EditDistance(a,b);
        int ans = ed.calculateLevenshtein(a.length(), b.length());
        System.out.println("The Levenshtein Edit Distance is: "+ans);
    }
}

class EditDistance{
    String s1;
    String s2;

    public EditDistance(String s1, String s2){
        this.s1 = s1;
        this.s2 = s2;
    }

    public int calculateLevenshtein(int i, int j){
        if( i == 0)
            return j;
        else if(j == 0)
            return i;
        else if(this.s1.charAt(i - 1) == this.s2.charAt(j - 1)){
            return Math.min(calculateLevenshtein((i - 1), (j - 1)),
                                1 + Math.min(calculateLevenshtein(i, (j - 1)),
                                                calculateLevenshtein((i - 1), j)));
        }
        else{
            return Math.min(1 + calculateLevenshtein((i - 1), (j - 1)),
                                1 + Math.min(calculateLevenshtein(i, (j - 1)),
                                        calculateLevenshtein((i - 1), j)));
        }
    }
}