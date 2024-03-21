package algorithm.co.algorithmjava.code.gpt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void main(String[] args) {
        inputTreasureIsland();
    }

    public static void inputMazeSearchProblem() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] maze = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = scanner.next();

            for (int j = 0; j < input.length(); j++) {
                maze[i][j] = Character.getNumericValue(input.charAt(j));
            }
        }

        scanner.close();

        int i = logicMazeSearchProblem(maze, n, m);
        System.out.println("i = " + i);
    }

    private static int logicMazeSearchProblem(int[][] maze, int n, int m) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] visited = new int[n][m];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0][0] = 1; // 방문 확인

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int x = current / m;
            int y = current % m;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 미로 정보에 부합하고 maze[x][y] 가 접근할 수 있는 위치이고 접근한 적 없으면 접근해서 +1 해주기
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(nx * m + ny);
                }
            }
        }

        return visited[n-1][m-1] > 0 ? visited[n-1][m-1] : -1;
    }

    private static int logicMaze(int[][] maze, int n, int m) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Integer> queue = new LinkedList<>();
        int[][] visited = new int[n][m];

        queue.add(0);
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int x = poll / n;
            int y = poll % m;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maze[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.offer(nx * n + ny);
                }
            }
        }

        return visited[n-1][m-1] > 0 ? visited[n-1][m-1] : -1;
    }

    public static void inputTreasureIsland() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[][] island = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] value = scanner.next().split("");
            for (int j = 0; j < value.length; j++) {
                // 1은 이동 가능한 육지 : 0은 이동 불가능한 물
                island[i][j] = value[j].equals("L") ? 1 : 0;
            }
        }

        scanner.close();

        System.out.println(logicTreasureIsland2(island, N, M));
    }

    private static int logicTreasureIsland(int[][] island, int N, int M) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Integer> queue = new LinkedList<>();
        int[][] visited = new int[N][M];

        queue.offer(0);
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Integer currentNum = queue.poll();

            int x = currentNum / N;
            int y = currentNum % M;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == 0 && island[nx][ny] != 0) {
                    queue.offer(nx * N + ny);
                    visited[nx][ny] = visited[x][y] + 1;
                }
            }
        }

        return visited[N-1][M-1] != 0 ? visited[N-1][M-1] -1 : -1;
    }

    private static int logicTreasureIsland2(int[][] island, int N, int M) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int maxDistance = 0;

        for (int startX = 0; startX < N; startX++) {
            for (int startY = 0; startY < M; startY++) {
                if (island[startX][startY] == 1) { // 육지에서만 BFS 시작
                    Queue<Integer> queue = new LinkedList<>();
                    int[][] visited = new int[N][M]; // 방문 배열 초기화

                    queue.offer(startX * M + startY);
                    visited[startX][startY] = 1;

                    while (!queue.isEmpty()) {
                        Integer currentNum = queue.poll();
                        int x = currentNum / M; // M으로 나누어야 정확한 x 값 계산
                        int y = currentNum % M;

                        for (int i = 0; i < 4; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && visited[nx][ny] == 0 && island[nx][ny] == 1) {
                                queue.offer(nx * M + ny); // nx * M + ny가 올바른 1차원 인덱스
                                visited[nx][ny] = visited[x][y] + 1;
                                maxDistance = Math.max(maxDistance, visited[nx][ny] - 1); // 최대 거리 갱신
                            }
                        }
                    }
                }
            }
        }

        return maxDistance; // 모든 육지를 시작점으로 한 BFS 탐색 후의 최대 거리 반환
    }

}
