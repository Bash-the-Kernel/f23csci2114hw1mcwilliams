public class ThreeMcWilliams {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java ThreeMcWilliams <n>");
            return;
        }

        int n = Integer.parseInt(args[0]);
        if (n <= 1) {
            System.out.println("Please provide an integer greater than 1 for n.");
            return;
        }

        boolean[] isPrime = new boolean[n];

        // Initialize the array assuming all numbers are prime
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        
        long startTime = System.currentTimeMillis();
        // Apply the Sieve of Eratosthenes algorithm
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        long endTime = System.currentTimeMillis();
        double elapsedMinutes = (endTime - startTime) / (1000.0 * 60.0);  // Convert milliseconds to minutes
        System.out.println("\nTime taken: " + elapsedMinutes + " minutes");
   

        System.out.println("Prime Numbers:");
        int c = 0;
        for (int i = n-1; i > 0; i--) {
            if (isPrime[i] && c < 5) {
                c++;
                System.out.println(i);
            }
        }
    }
}
