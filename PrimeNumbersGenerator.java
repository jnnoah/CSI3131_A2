import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// this code is not perfect, I am still figuring out how to show the multithreads 
public class PrimeNumbersGenerator {
    public static class PrimeNumFinder extends Thread {
        private int num;
        int threadNumber = 1;

        // constructor
        public PrimeNumFinder(int number) {
            num = number;

        }

        /*
         * public Multithreading (int threadNum){
         * threadNumber= threadNum;
         * }
         */

        @Override
        public void run() {

            List<Integer> prime_numbers = new ArrayList<>();
            threadNumber = 1;
            for (int checked_num = 2; checked_num <= num; checked_num++) {
                boolean isPrime = true;
                for (int factor = 2; factor <= checked_num / 2; factor++) {
                    if (checked_num % factor == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    prime_numbers.add(checked_num);

                }

            }

            System.out.println(
                    " Prime numbers less than or equal to " + num + "are : ");

            for (int a : prime_numbers) {
                System.out.println(a + " in thread " + threadNumber);

            }
            threadNumber++;
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());

        // we start the thread

        PrimeNumFinder primeThread = new PrimeNumFinder(n);
        primeThread.start();

    }

}
