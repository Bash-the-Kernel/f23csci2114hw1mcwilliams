public class TwoMcWilliams {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Please enter n. ");
            return;
        }
        int n = Integer.parseInt(args[0]);

        long[] fibonacciArray = new long[n];
        fibonacciArray[0] = 0;
        if (n > 1) {
            fibonacciArray[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }

        System.out.println("Fibonacci Array:");
        int digits = ((int)Math.log10(fibonacciArray[fibonacciArray.length-1]))+1;
        for (int i = 0; i < n; i++) {
            System.out.printf("%"+digits+"d",fibonacciArray[i]);
            if((i+1) % 7 ==0)System.out.println();
        }

    }

}
