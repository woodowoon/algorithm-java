package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 1978번 소수찾기
public class FindPrimeNumbers {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            if (logic(scanner.nextInt())) count++;
        }

        scanner.close();

        System.out.println(count);
    }

    private static boolean logic(Integer number) {
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
