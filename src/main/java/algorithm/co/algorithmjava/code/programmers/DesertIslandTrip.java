package algorithm.co.algorithmjava.code.programmers;

import java.util.*;

// 프로그래머스 무인도여행 TODO : **재도전예정**
public class DesertIslandTrip {

    public static void main(String[] args) {
        String[] maps1 = {
                "X591X",
                "X1X5X",
                "X231X",
                "1XXX1"
        };

        String[] maps2 = {
                "XXX","XXX","XXX"
        };

        System.out.println("solution(maps1) = " + Arrays.toString(solution(maps1)));
        System.out.println("solution(maps1) = " + Arrays.toString(solution(maps2)));
    }

    public static int[] solution(String[] maps) {
        int[][] island = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; i++) {
            char[] chars = maps[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == 'X') {
                    island[i][j] = 0;
                } else {
                    island[i][j] = Integer.parseInt(String.valueOf(chars[j]));
                }
            }
        }

        return bfs(island, maps.length, maps[0].length());
    }

    public static int[] bfs(int[][] island, int n, int m) {
        List<Integer> days = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Integer> initQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                initQueue.offer(i * m + j);
            }
        }

        while (!initQueue.isEmpty()) {
            int pos = initQueue.poll();
            int x = pos / m;
            int y = pos % m;

            if (island[x][y] != 0 && !visited[x][y]) {
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[] {x, y});
                visited[x][y] = true;
                int totalSupply = 0;

                while (!queue.isEmpty()) {
                    int[] current = queue.poll();
                    totalSupply += island[current[0]][current[1]];

                    for (int k = 0; k < 4; k++) {
                        int nx = current[0] + dx[k];
                        int ny = current[1] + dy[k];
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && island[nx][ny] != 0 && !visited[nx][ny]) {
                            queue.add(new int[] {nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
                days.add(totalSupply);
            }
        }

        if (days.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(days);
        return days.stream().mapToInt(i -> i).toArray();
    }
}
