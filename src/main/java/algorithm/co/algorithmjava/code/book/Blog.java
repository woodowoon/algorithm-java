package algorithm.co.algorithmjava.code.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Blog {
    public static void blog() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int day = scanner.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        logic(numbers, day);
    }

    private static void logic(List<Integer> numbers, Integer day) {
        int start = 0;
        int currentSum = 0;
        int max = 0;
        int count = 0;

        for (int end = 0; end < numbers.size(); end++) {
            currentSum += numbers.get(end);

            while (end - start + 1 == day) {
                if (max == currentSum) {
                    count++;
                }
                if (max < currentSum) {
                    max = currentSum;
                    count = 1;
                }

                currentSum -= numbers.get(start);
                start++;
            }
        }

        if (max != 0) {
            System.out.println(max);
            System.out.println(count);
        } else {
            System.out.println("SAD");
        }
    }
}
