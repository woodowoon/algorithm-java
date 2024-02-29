package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 수열 2559번 문제
public class Sequence2 {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        logic(numbers, k);
    }

    private static void logic(List<Integer> numbers, int k) {
        int start = 0;
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.size(); i++) {
            currentSum += numbers.get(i);

            if (i >= k-1) {
                maxSum = Math.max(maxSum, currentSum);

                currentSum -= numbers.get(start);
                start++;
            }
        }

        System.out.println(maxSum);
    }
}
