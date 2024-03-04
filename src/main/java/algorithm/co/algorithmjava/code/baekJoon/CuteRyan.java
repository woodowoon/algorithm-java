package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 귀여운 라이언 15565 (투포인터)
public class CuteRyan {

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

    public static void logic(List<Integer> numbers, Integer k) {
        int ryanCount = 0;
        int minCount = numbers.size() + 1;
        int start = 0, end = 0;

        while (end < numbers.size()) {
            // 라이언 인형일 경우 카운트 증가
            if (numbers.get(end) == 1) {
                ryanCount++;
            }

            // 조건을 만족하는 동안, 최소 길이 업데이트하며 start 포인터 이동
            while (ryanCount >= k) {
                minCount = Math.min(minCount, end - start + 1);
                if (numbers.get(start) == 1) {
                    ryanCount--;
                }
                start++;
            }

            end++;
        }

        // 조건을 만족하는 집합이 없는 경우
        if (minCount == numbers.size() + 1) {
            System.out.println(-1);
        } else {
            System.out.println(minCount);
        }
    }


}
