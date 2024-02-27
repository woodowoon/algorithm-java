package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

public class SushiRotation {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt(); // 회전 초밥 벨트에 놓인 접시의 수
        int d = scanner.nextInt(); // 초밥의 가짓수
        int k = scanner.nextInt(); // 연속해서 먹는 접시의 수
        int c = scanner.nextInt(); // 쿠폰 번호

        List<Integer> belt = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            belt.add(scanner.nextInt());
        }

        scanner.close();

        int maxVariety = calculateMaxVariety(n, k, c, belt);
        System.out.println(maxVariety);
    }

    private static int calculateMaxVariety(int n, int k, int c, List<Integer> belt) {
        int maxVariety = 0;
        Map<Integer, Integer> sushiCount = new HashMap<>();

        for (int i = 0; i < k; i++) {
            sushiCount.put(belt.get(i), sushiCount.getOrDefault(belt.get(i), 0) + 1);
        }

        int kindCount = sushiCount.size(); // 초기 가짓수 계산
        if (!sushiCount.containsKey(c)) {
            kindCount++; // 쿠폰 초밥이 없는 경우 추가로 가짓수 증가
        }

        maxVariety = kindCount;

        // 초밥 창구를 한 칸씩 이동하며 최대 가짓수 계산
        for (int i = 0; i < n; i++) {
            // 창구에서 나간 초밥 처리
            int removedSushi = belt.get(i); // 벨트에서 나가는 초밥
            sushiCount.put(removedSushi, sushiCount.get(removedSushi) - 1);

            if (sushiCount.get(removedSushi) == 0) {
                sushiCount.remove(removedSushi);
            }

            // 새로운 초밥 추가
            int newSushi = belt.get((i + k) % n); // 새로운 초밥
            sushiCount.put(newSushi, sushiCount.getOrDefault(newSushi, 0) + 1);

            // 새로운 가짓수 계산
            int newKindCount = sushiCount.size();
            if (!sushiCount.containsKey(c)) {
                newKindCount++; // 쿠폰 초밥이 없는 경우 추가로 가짓수 증가
            }

            // 최대 가짓수 갱신
            maxVariety = Math.max(maxVariety, newKindCount);
        }

        return maxVariety;
    }

    private static void logic(Integer k, Integer c, List<Integer> numbers) {
        int uniqueStart = 0;
        int start = 0;
        Set<Integer> newNumbers = new HashSet<>();
        List<Integer> listNumbers = new ArrayList<>();

        for (Integer number : numbers) {
            if (!Objects.equals(number, c)) {
                if (newNumbers.add(number)) {
                    listNumbers.add(number);
                } else {
                    newNumbers.remove(numbers.get(uniqueStart));
                    listNumbers.remove(numbers.get(uniqueStart));

                    if (newNumbers.add(number)) {
                        listNumbers.add(number);
                    }

                    uniqueStart++;
                }
            }
        }

        System.out.println(listNumbers.size() + 1);
    }

}
