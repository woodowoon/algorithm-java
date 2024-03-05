package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// [10025] 게으른 백곰
public class LazyWhiteBear {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Map<Integer, Integer> map = new HashMap<>();
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt(); // 얼음 입력
            int key = scanner.nextInt(); // 위치 입력

            maxValue = Math.max(maxValue, key); // 최대 index 값 계산

            map.put(key, value);
        }

        scanner.close();

        logic(map, k, maxValue);

    }

    private static void logic(Map<Integer, Integer> map, int k, int maxValue) {
        int maxSum = 0;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end <= maxValue; end++) {
            windowSum += map.getOrDefault(end, 0); // end 값이 map 에 없으면 0 을 더하고 있다면 value 를 더한다.

            maxSum = Math.max(maxSum, windowSum); // 이걸 밖에 두는 이유는 (k * 2 + 1) 이상일 경우에도 Max 값은 업데이트 되어야하기때문에,
            if (end >= (k * 2) + 1) {
                windowSum -= map.getOrDefault(start, 0); // start 값이 map 에 있으면 0을 빼주고 있다면 value 를 뺀다.
                start++; // start 는 ++
            }
        }

        System.out.println(maxSum);
    }

    private static void logic2(Map<Integer, Integer> map, int k, int maxValue) {
        int maxSum = 0;
        int windowSum = 0;
        int start = 0;

        for (int end = 0; end < (k * 2) + 1; end++) {
            windowSum += map.getOrDefault(end, 0);
        }
        maxSum = windowSum;

        for (int end = (k * 2) + 1; end <= maxValue; end++) {
            windowSum += map.getOrDefault(end, 0);
            windowSum -= map.getOrDefault(start, 0);
            start++;
            maxSum = Math.max(maxSum, windowSum);
        }

        System.out.println(maxSum);
    }

}
