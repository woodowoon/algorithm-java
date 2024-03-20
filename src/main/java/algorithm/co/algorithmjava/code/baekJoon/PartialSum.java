package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1806번 부분합
public class PartialSum {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        System.out.println(logic(s, numbers));
    }

    private static int logic(int s, List<Integer> numbers) {
        int minSize = Integer.MAX_VALUE;
        int currentSum = 0;
        int start = 0;

        for (int i = 0; i < numbers.size(); i++) {
            currentSum += numbers.get(i);

            while (currentSum >= s) {
                minSize = Math.min(minSize, (i - start + 1));

                currentSum -= numbers.get(start);
                start++;
            }
        }

        if (minSize == Integer.MAX_VALUE) {
            return 0;
        } else {
            return minSize;
        }

    }

}
