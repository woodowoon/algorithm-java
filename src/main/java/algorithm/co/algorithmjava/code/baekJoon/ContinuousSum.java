package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 연속합 1912번
public class ContinuousSum {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        logic(numbers);
    }

    private static void logic(List<Integer> numbers) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (Integer number : numbers) {
            currentSum = Math.max(number, currentSum + number);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }

}
