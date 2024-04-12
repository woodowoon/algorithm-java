package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 11725번 트리의 부모찾기
public class FindParentOfTree {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i < N + 1; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            int number1 = scanner.nextInt();
            int number2 = scanner.nextInt();

            map.get(number1).add(number2);
            map.get(number2).add(number1);
        }

        List<Integer> logic = logic(map);

        scanner.close();

        for (Integer value : logic) {
            sb.append(value).append("\n");
        }

        System.out.println(sb);
    }

    private static List<Integer> logic(Map<Integer, List<Integer>> map) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[map.size() + 1];
        visited[1] = 1;
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int next : map.getOrDefault(poll, new ArrayList<>())) {
                if (visited[next] == 0) {
                    visited[next] = visited[poll] + 1;
                    queue.offer(next);
                }
            }
        }

        for (int i = 2; i < map.size() + 1; i++) {
            answer.add(findParent(visited, map.get(i)));
        }

        return answer;
    }

    private static int findParent(int[] visited, List<Integer> value) {
        int size = Integer.MAX_VALUE;
        int answer = 0;

        for (Integer integer : value) {
            if (visited[integer] < size) {
                size = visited[integer];
                answer = integer;
            }
        }

        return answer;
    }

}
