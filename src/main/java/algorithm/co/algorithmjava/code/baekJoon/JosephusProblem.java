package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 11866번 요세푸스 문제0
public class JosephusProblem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        scanner.close();

        System.out.println(inputUseNotQueue(n, k));
        System.out.println(josephusSequenceUseQueue(n, k));
    }

    public static String inputUseNotQueue(int n, int k) {
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            numbers.add(i);
        }

        List<Integer> answers = useNotQueueLogic(numbers, k);

        for (int i = 0; i < answers.size(); i++) {
            if (i == answers.size() -1) {
                sb.append(answers.get(i)).append(">");
            } else {
                sb.append(answers.get(i)).append(", ");
            }
        }

        return sb.toString();
    }

    private static List<Integer> useNotQueueLogic(List<Integer> numbers, int k) {
        List<Integer> answers = new ArrayList<>();

        int index = 0;  // 시작 위치 설정

        while (!numbers.isEmpty()) {
            index = (index + k - 1) % numbers.size();  // k번째 요소의 인덱스를 찾음
            int removed = numbers.remove(index);  // k번째 요소를 제거하고 반환
            answers.add(removed);  // 제거된 요소를 결과 리스트에 추가
        }

        return answers;
    }

    public static String josephusSequenceUseQueue(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            queue.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                int temp = queue.poll();
                queue.offer(temp);
            }

            sb.append(queue.poll());

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");

        return sb.toString();
    }
}
