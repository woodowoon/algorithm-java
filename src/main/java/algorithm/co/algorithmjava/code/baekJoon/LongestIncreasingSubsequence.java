package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 가장 긴 증가하는 부분 수열 11053
public class LongestIncreasingSubsequence {

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
        List<Integer> newList = new ArrayList<>();

        for (Integer number : numbers) {
            if (newList.isEmpty() || number > newList.get(newList.size() - 1)) {
                newList.add(number);
            } else {
                int i = 0;
                int j = newList.size() - 1;

                while (i < j) {
                    int mid = (i + j) / 2;

                    if (newList.get(mid) < number) {
                        i = mid + 1;
                    } else {
                        j = mid;
                    }
                }

                newList.set(i, number);
            }
        }

        System.out.println(newList.size());
    }

}
