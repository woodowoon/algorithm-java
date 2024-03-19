package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 10211번 Maximum Subarray
public class MaximumSubarray {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int size = scanner.nextInt();
            List<Integer> numbers = new ArrayList<>();

            for (int j = 0; j < size; j++) {
                numbers.add(scanner.nextInt());
            }

            sb.append(logic(numbers)).append("\n");
        }

        scanner.close();

        System.out.println(sb);
    }

    private static int logic(List<Integer> list) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (Integer number : list) {
            currentSum = Math.max(number, currentSum + number);
            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

}
