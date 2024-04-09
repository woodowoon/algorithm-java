package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 2606번 바이러스
public class Virus {

    public static void main(String[] args) {
        input();
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);

        int computerCount = scanner.nextInt();
        int connectionCount = scanner.nextInt();
        Map<Integer, List<Integer>> network = new HashMap<>();

        for (int i = 0; i < connectionCount; i++) {
            int computer1 = scanner.nextInt();
            int computer2 = scanner.nextInt();

            network.putIfAbsent(computer1, new ArrayList<>());
            network.putIfAbsent(computer2, new ArrayList<>());
            network.get(computer1).add(computer2);
            network.get(computer2).add(computer1);
        }

        scanner.close();

        System.out.println(logic(network));
    }

    private static int logic(Map<Integer, List<Integer>> map) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        queue.offer(1);
        visited.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : map.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(next);
                }
            }
        }

        return visited.size() - 1; // 1번 컴퓨터를 제외한 감염된 컴퓨터 수
    }
}
