package algorithm.co.algorithmjava.code.programmers;

import java.util.*;

// 프로그래머스 힙 > 이중우선순위큐
public class DoublePriorityQueue {

    public static void input() {
        List<String> inputList = Arrays.asList("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1");

        String[] inputArray = inputList.toArray(new String[0]);

        solution(inputArray);
    }

    public static List<Integer> solution(String[] operations) {
        List<Integer> answer = new ArrayList<>();

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.contains("I")) {
                String[] parts = operation.split(" ");
                int num = Integer.parseInt(parts[1]);

                minQueue.add(num);
                maxQueue.add(num);
            } else if (operation.equals("D 1")) {
                if (!maxQueue.isEmpty()) {
                    int max = maxQueue.poll();
                    minQueue.remove(max);
                }
            } else if (operation.equals("D -1")) {
                if (!minQueue.isEmpty()) {
                    int min = minQueue.poll();
                    maxQueue.remove(min);
                }
            }
        }

        // 큐가 비어있지 않으면 최댓값과 최솟값을 추출하여 리스트에 추가
        if (!maxQueue.isEmpty() && !minQueue.isEmpty()) {
            answer.add(maxQueue.poll());
            answer.add(minQueue.poll());
        } else {
            // 큐가 비어있으면 [0, 0] 반환
            answer.add(0);
            answer.add(0);
        }

        return answer;
    }
}
