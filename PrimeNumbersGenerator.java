/* ------------------------------------------------------------
File: PrimeNumbersGenerator.java
---------
Group 62 
---------
Names: Nadege Uwurukundo Mpore ; SI: 300088681
Names: Noah Ndahirwa;  SI:300152285


a multithreaded Java program that outputs prime numbers. 
The user will run the program and will enter a number on the command line. 
The program will then create a separate thread that outputs all the prime numbers 
less than or equal to the number entered by the user.
----------------------------------------------*/

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

            // Iterate from 2 to the given number
            for (int checked_num = 2; checked_num <= num; checked_num++) {
                boolean isPrime = true;
                for (int factor = 2; factor <= checked_num / 2; factor++) {
                    if (checked_num % factor == 0) {
                        // If the number is not divisible by any other number, it's prime
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    prime_numbers.add(checked_num);

                }

            }

            for (int a : prime_numbers) {

                System.out.println(a);

            }

        }

    }

    public static void main(String[] args) {
        System.out.println("Enter a number:");
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        // we start the thread
        System.out.println("\nPrime numbers less than " + n + " is :");
        // Start the thread, which will execute the run() method
        PrimeNumFinder primeThread = new PrimeNumFinder(n);
        primeThread.start();

        // System.out.println("print 2nd thread to see parallalism in threads");
        // PrimeNumFinder primeThread2 = new PrimeNumFinder(n);
        // primeThread2.start();

    }

}
