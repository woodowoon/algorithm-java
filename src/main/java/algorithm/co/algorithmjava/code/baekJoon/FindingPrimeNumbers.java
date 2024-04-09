package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 1929번 소수 구하기
public class FindingPrimeNumbers {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();

        for (int i = n1; i < n2 + 1 ; i++) {
            if (isPrimeNumber(i)) {
                sb.append(i).append("\n");
            }
        }

        scanner.close();

        System.out.println(sb);
    }

    private static Boolean isPrimeNumber(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
