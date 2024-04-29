package algorithm.co.algorithmjava.code.book.codingTest.greedy;

import java.util.Scanner;

// 1이 될 때까지
public class UntilItBecomes1 {

    public static void main(String[] args) {
        mySolution();
    }

    private static void mySolution() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int count = 0;

        while (n != 1) {
            if (n % k == 0) {
                n = n / k;
            } else {
                n -= 1;
            }

            count++;
        }

        scanner.close();

        System.out.println(count);
    }

}
