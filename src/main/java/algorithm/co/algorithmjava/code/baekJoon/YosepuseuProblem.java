package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 11866번 요세푸스 문제0
public class YosepuseuProblem {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            numbers.add(i);
        }

        scanner.close();

        List<Integer> answers = logic(numbers, k);

        for (int i = 0; i < answers.size(); i++) {
            if (i == answers.size() -1) {
                sb.append(answers.get(i)).append(">");
            } else {
                sb.append(answers.get(i)).append(", ");
            }
        }

        System.out.println(sb);
    }

    private static List<Integer> logic(List<Integer> numbers, int k) {
        List<Integer> answers = new ArrayList<>();

        int index = 0;  // 시작 위치 설정

        while (!numbers.isEmpty()) {
            index = (index + k - 1) % numbers.size();  // k번째 요소의 인덱스를 찾음
            int removed = numbers.remove(index);  // k번째 요소를 제거하고 반환
            answers.add(removed);  // 제거된 요소를 결과 리스트에 추가
        }

        return answers;
    }
}
