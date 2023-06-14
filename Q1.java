import java.util.Scanner;

public class Q1 extends Thread {
    private int number;

    public Q1(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // Iterate from 2 to the given number
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                // Print the prime number
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int number) {
        // Check if the number is less than or equal to 1, it's not prime
        if (number <= 1) {
            return false;
        }

        // Iterate from 2 to the square root of the number
        for (int i = 2; i <= Math.sqrt(number); i++) {
            // If the number is divisible by any other number, it's not prime
            if (number % i == 0) {
                return false;
            }
        }

        // If the number is not divisible by any other number, it's prime
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Create an instance of Q1 thread with the given number
        Q1 primeThread = new Q1(number);
        // Start the thread, which will execute the run() method
        primeThread.start();
    }
}
