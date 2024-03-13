package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 이상한 곱셈 1225번
public class StrangeMultiplication {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        scanner.close();

        logic(a, b);
    }

    private static void logic(String a, String b) {
        long sum = 0;

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                sum += (long) Integer.parseInt(String.valueOf(a.charAt(i))) * Integer.parseInt(String.valueOf(b.charAt(j) - '0'));
            }
        }

        System.out.println(sum);
    }
}
