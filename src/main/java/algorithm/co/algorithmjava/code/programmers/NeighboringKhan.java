package algorithm.co.algorithmjava.code.programmers;

// 프로그래머스 이웃한 칸
public class NeighboringKhan {

    public static void main(String[] args) {
        String[][] board1 = {
                {
                    "blue", "red", "orange", "red"
                },
                {
                    "red", "red", "blue", "orange"
                },
                {
                    "blue", "orange", "red", "red"
                },
                {
                    "orange", "orange", "red", "blue"
                }
        };
        int h1 = 1;
        int w1 = 1;

        String[][] board2 = {
                {
                    "yellow", "green", "blue"
                },
                {
                    "blue", "green", "yellow"
                },
                {
                    "yellow", "blue", "blue"
                }
        };
        int h2 = 0;
        int w2 = 1;

        System.out.println("solution(board1, h1, w1) = " + solution(board1, h1, w1));
        System.out.println("solution(board2, h2, w2) = " + solution(board2, h2, w2));
    }

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];

            String mainColor = board[h][w];

            if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && mainColor.equals(board[nx][ny])) {
                answer++;
            }
        }

        return answer;
    }

}
