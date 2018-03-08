import java.util.function.Supplier;

public class RunTimeCalculator {

    // benchmarking code to calculate the running time for the smallest method.
    public static <T> T time (Supplier<T> thunk) {
        System.out.println();
        try {
            long t0 = System.currentTimeMillis();
            T result = thunk.get();
            long t1 = System.currentTimeMillis();
            long t = t1 - t0;
            System.out.println ( "Program Runs in " + t + " milliseconds!");
            return result;
        }
        catch (Error e) {
            System.out.println ("\nERROR: " + e);
            return null;
        }
    }
}
