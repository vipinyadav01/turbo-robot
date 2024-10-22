import java.util.HashMap;
import java.util.Map;

public class FibonacciDP {

    private static Map<Integer, Long> memo = new HashMap<>();

    public static long fibMemo(int n) {
        if (n <= 1) return n;
        
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        
        long result = fibMemo(n - 1) + fibMemo(n - 2);
        memo.put(n, result);
        
        return result;
    }

    
    public static long fibTabulation(int n) {
        if (n <= 1) return n;
        
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 50; 
        
        long startTime = System.nanoTime();
        long resultMemo = fibMemo(n);
        long endTime = System.nanoTime();
        System.out.println("Memoization result: " + resultMemo);
        System.out.println("Memoization time: " + (endTime - startTime) / 1_000_000.0 + " ms");
        
        startTime = System.nanoTime();
        long resultTab = fibTabulation(n);
        endTime = System.nanoTime();
        System.out.println("Tabulation result: " + resultTab);
        System.out.println("Tabulation time: " + (endTime - startTime) / 1_000_000.0 + " ms");
    }
}
