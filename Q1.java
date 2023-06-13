import java.util.Scanner;

public class Q1 extends Thread {
    private int number;

    public Q1(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        Q1 primeThread = new Q1(number);
        primeThread.start();
    }
}
