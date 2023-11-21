public class FibonacciMemoization {
    public static long calculateFibonacci(final int n) {
        if (n <= 1) {
            return n;
        }
        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static long calculateFibonacciWithMemoization(final int n) {
        final long[] memo = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }
        return memoFib(n, memo);
    }
 
    private static long memoFib(final int n, final long[] memo) {
        if (n <= 1) {
            return n;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        memo[n] = memoFib(n - 1, memo) + memoFib(n - 2, memo);
        return memo[n];
    }

    public static void main(final String[] args) {
        final int n = 40;
        long startTime = System.currentTimeMillis();
        long result = calculateFibonacci(n);
        long endTime = System.currentTimeMillis();
        final long timeWithoutMemoization = endTime - startTime;
        System.out.println("Fibonacci without memoization:");
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + timeWithoutMemoization + "ms");
        startTime = System.currentTimeMillis();
        result = calculateFibonacciWithMemoization(n);
        endTime = System.currentTimeMillis();
        final long timeWithMemoization = endTime - startTime;
        System.out.println("\nFibonacci with memoization:");
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + timeWithMemoization + "ms");
    }
}
