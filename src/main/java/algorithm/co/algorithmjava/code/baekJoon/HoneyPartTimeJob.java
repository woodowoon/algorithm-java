package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 꿀 아르바이트 12847
public class HoneyPartTimeJob {

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
        int start = 0;
        int currentSum = 0;
        int max = 0;

        for (int i = 0; i < numbers.size(); i++) {
            currentSum += numbers.get(i);

            if (i >= m-1) {
                max = Math.max(max, currentSum);

                currentSum -= numbers.get(start);
                start++;
            }
        }

        System.out.println(max);
    }

}
