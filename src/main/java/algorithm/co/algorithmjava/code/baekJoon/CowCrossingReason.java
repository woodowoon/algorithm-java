package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 14465 소가 길을 건너간 이유5
public class CowCrossingReason {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 총 신호등 개수
        int k = scanner.nextInt(); // 수리되어야할 신호등 개수
        int b = scanner.nextInt(); // 망가진 신호등 개수

        List<Integer> brokenTrafficLights = new ArrayList<>();

        for (int i = 0; i < b; i++) {
            brokenTrafficLights.add(scanner.nextInt());
        }

        scanner.close();

        logic(n, k, brokenTrafficLights);
    }


    private static void logic(Integer n, Integer k, List<Integer> brokenTrafficLights) {
        Map<Integer, Boolean> trafficLights = new HashMap<>();

        for (int i = 1; i < n+1; i++) {
            trafficLights.put(i, brokenTrafficLights.contains(i));
        }

        int start = 1;
        int minSize = Integer.MAX_VALUE;
        int count = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < trafficLights.size()+1; i++) {
            // 추가
            list.add(i);
            if (trafficLights.get(i)) {
                count++;
            }


            if (list.size() >= k) {
                minSize = Math.min(minSize, count);
                // 삭제
                list.remove(Integer.valueOf(start));

                if (trafficLights.get(start)) {
                    count--;
                }

                start++;
            }
        }

        System.out.println(minSize);
    }
}
