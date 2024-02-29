package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 수열 2491번
public class Sequence1 {
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
        int addCount = 1;
        int minusCount = 1;
        int maxLength = 1;

        for (int i = 1; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                addCount++;
                minusCount = 1;
            } else if (numbers.get(i) < numbers.get(i - 1)) {
                addCount = 1;
                minusCount++;
            } else {
                addCount++;
                minusCount++;
            }

            maxLength = Math.max(maxLength, Math.max(addCount, minusCount));
        }

        System.out.println(maxLength);
    }
}
