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

        System.out.println("sushiCount1 = " + sushiCount);

        // 초밥 창구를 한 칸씩 이동하며 최대 가짓수 계산
        // i 가 0 부터 시작하는 이유는 회전하기때문에 첫번째와 마지막초밥이 붙어있다.
        for (int i = 0; i < n; i++) {
            // 창구에서 나간 초밥 처리
            int removedSushi = belt.get(i); // 벨트에서 나가는 초밥
            System.out.println("removedSushi = " + removedSushi);
            sushiCount.put(removedSushi, sushiCount.get(removedSushi) - 1); // 첫번째 개수를 하나 줄이고

            System.out.println("removedSushi1 = " + removedSushi);
            System.out.println("sushiCount2 = " + sushiCount);

            if (sushiCount.get(removedSushi) == 0) { // 만약 개수를 줄인게 0이라면
                sushiCount.remove(removedSushi); // 해당 초밥을 삭제해.
            }

            System.out.println("sushiCount3 = " + sushiCount);

            // 새로운 초밥 추가
            int newSushi = belt.get((i + k) % n); // 새로운 초밥 (회전하는 회전초밥이기때문에 %n 을 추가했다.)
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
