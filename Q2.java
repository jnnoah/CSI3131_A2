import java.util.Scanner;

public class Q2 {

    public static class FibonacciThread extends Thread {
        private int[] fibSequence;
    
        public FibonacciThread(int[] fibSequence) {
            this.fibSequence = fibSequence;
        }
    
        @Override
        public void run() {
            int n = fibSequence.length;
            if (n > 0) {
                fibSequence[0] = 0;
            }
            if (n > 1) {
                fibSequence[1] = 1;
            }
            for (int i = 2; i < n; i++) {
                fibSequence[i] = fibSequence[i - 1] + fibSequence[i - 2];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to generate: ");
        int count = scanner.nextInt();
        scanner.close();

        int[] fibSequence = new int[count];

        FibonacciThread fibonacciThread = new FibonacciThread(fibSequence);
        fibonacciThread.start();

        try {
            fibonacciThread.join(); // Wait for the child thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Fibonacci sequence:");
        for (int num : fibSequence) {
            System.out.print(num + " ");
        }
    }
}
