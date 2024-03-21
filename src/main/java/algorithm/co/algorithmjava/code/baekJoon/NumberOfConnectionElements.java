package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 11724번 연결 요소의 개수
public class NumberOfConnectionElements {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt(); // 정점의 개수
        int M = scanner.nextInt(); // 간선의 개수
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        // 간선 정보 입력 받기
        for (int i = 0; i < M; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향 그래프이므로 양방향으로 추가
        }

        scanner.close();

        System.out.println(logic(graph, N));
    }

    private static int logic(Map<Integer, List<Integer>> graph, int N) {
        int[] visited = new int[N + 1];
        int count = 0;

        for (int i = 1; i <= N; i++) { // 모든 노드에 대해 BFS 실행
            if (visited[i] == 0) {
                bfs(visited, i, graph); // graph 전체를 인자로 전달
                count++; // 새로운 연결 요소 발견
            }
        }

        return count;
    }

    private static void bfs(int[] visited, int currentNum, Map<Integer, List<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNum);
        visited[currentNum] = 1; // 방문 처리

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer neighbor : graph.get(current)) { // 인접 노드 탐색
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1; // 방문 처리
                    queue.offer(neighbor);
                }
            }
        }
    }

}
