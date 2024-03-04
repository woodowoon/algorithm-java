package algorithm.co.algorithmjava.code.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 1655번 가운데를 말해요
public class SayAboutMiddle {

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // 최대 힙

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(br.readLine());
            maxHeap.offer(number);
            minHeap.offer(maxHeap.poll());

            if (maxHeap.size() < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 중간값 출력
            sb.append(maxHeap.peek()).append("\n");
        }

        br.close();

        System.out.println(sb);
    }

    private static void logic(List<Integer> numbers) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Integer number : numbers) {
            queue.add(number);
            List<Integer> sortingNumbers = new ArrayList<>();

            while (!queue.isEmpty()) { // 큐가 비어있을 때까지 반복
                sortingNumbers.add(queue.poll());
            }

            queue.addAll(sortingNumbers);

            if (sortingNumbers.size() % 2 == 0) { // 짝수일때
                System.out.println(sortingNumbers.get((sortingNumbers.size() / 2) - 1));
            } else { // 홀수 일때
                System.out.println(sortingNumbers.get((sortingNumbers.size() / 2)));
            }

        }
    }

    private static void logic2(List<Integer> numbers) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (Integer number : numbers) {
            queue.add(number);
            PriorityQueue<Integer> copy = new PriorityQueue<>(queue); // 현재 상태를 복사

            int size = copy.size();
            int middleIndex = size / 2;

            for (int i = 0; i < middleIndex; i++) {
                copy.poll(); // 중간값 이전의 요소들을 제거
            }

            if (size % 2 == 0) { // 짝수일때
                System.out.println(copy.peek()); // 중간값 반환
            } else { // 홀수 일때
                copy.poll(); // 중간값 제거
                System.out.println(copy.peek()); // 다음 중간값 반환
            }
        }
    }

}
