package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 2003 수들의 합 2
public class SumOfNumber2 {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        logic(numbers, m);
    }

    private static void logic(List<Integer> numbers, int m) {
        int count = 0;
        int start = 0;
        int currentSum = 0;

        for (Integer number : numbers) {
            currentSum += number;

            while (currentSum >= m) {
                if (currentSum == m) {
                    count++;
                }

                currentSum -= numbers.get(start);
                start++;
            }
        }

        System.out.println(count);
    }

}
