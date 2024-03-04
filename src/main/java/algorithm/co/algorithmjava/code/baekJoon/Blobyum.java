package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// blobyum 24499번
public class Blobyum {
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

    // 고려해야할 사항
    //     1. 배열은 원의 형태로 연결되어있다.
    private static void logic(List<Integer> numbers, Integer k) {
        int start = 0;
        int initStart = 0;
        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);

            if (i >= k-1) {
                maxSum = Math.max(maxSum, sum);

                sum -= numbers.get(start);
                start++;
            }

            if (i == numbers.size() - 1) {
                while (initStart < k - 1 && start < numbers.size()) {
                    sum += numbers.get(initStart);
                    initStart++;

                    maxSum = Math.max(maxSum, sum);

                    sum -= numbers.get(start);
                    start++;

                }
            }
        }

        System.out.println(maxSum);
    }
}
