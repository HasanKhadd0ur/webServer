package task;

import java.util.ArrayList;
import java.util.List;

public class TaskPrimeNumbers extends TaskImpl {

    @Override
    public void execute() {
        try {

	    // The input will be the upper limit for prime generation		
            int upperLimit = Integer.parseInt(input); 
            List<Integer> primes = generatePrimes(upperLimit);

            // Write the result as string
            result = "Found " + primes.size() + " prime numbers up to " + upperLimit;
        } catch (NumberFormatException e) {
            result = "Invalid input, Please provide a valid number as the upper limit of the interval.";
        }
    }

    // this function to generate prime numbers up to a certain limit
    private List<Integer> generatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    // this function to check if a number is prime
    private boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
