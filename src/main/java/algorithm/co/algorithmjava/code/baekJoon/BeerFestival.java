package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 17503번 맥주축제
public class BeerFestival {

    static class Beer {
        int prefer, alcohol;

        public int getPrefer() {
            return prefer;
        }

        public Beer(int prefer, int alcohol) {
            this.prefer = prefer;
            this.alcohol = alcohol;
        }
    }

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        List<Beer> beers = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            int v = scanner.nextInt();
            int c = scanner.nextInt();

            beers.add(new Beer(v, c));
        }

        beers.sort((o1, o2) -> {
            if (o1.alcohol == o2.alcohol) {
                return Integer.compare(o1.prefer, o2.prefer); // 내림차순
            }
            return Integer.compare(o1.alcohol, o2.alcohol); // 오름차순
        });

        scanner.close();

        System.out.println(findFirstHighPreference(beers, n, m));
    }

    public static int findFirstHighPreference(List<Beer> beers, int maxBeers, int minPreferenceSum) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 선호도가 낮은 맥주부터 제거하기 위한 우선순위 큐
        int currentPreferenceSum = 0; // 현재 선택된 맥주들의 선호도 합
        int result = -1; // 조건을 만족하는 첫 맥주의 알코올 도수를 저장

        for (Beer beer : beers) {
            minHeap.add(beer.getPrefer()); // 현재 맥주의 선호도를 우선순위 큐에 추가
            currentPreferenceSum += beer.getPrefer(); // 선호도 합 업데이트

            // 우선순위 큐의 크기가 maxBeers 보다 크면, 가장 낮은 선호도를 가진 맥주를 제거
            if (minHeap.size() > maxBeers) {
                currentPreferenceSum -= minHeap.poll(); // 가장 낮은 선호도를 합계에서 제거
            }

            // 정확히 maxBeers 만큼의 맥주가 선택되었고, 선호도 합이 minPreferenceSum 이상인 경우
            if (minHeap.size() == maxBeers && currentPreferenceSum >= minPreferenceSum) {
                return beer.alcohol; // 조건을 만족하는 경우, 해당 맥주의 알코올 도수를 결과로 설정
            }
        }

        return result; // 결과 반환
    }

}
