package algorithm.co.algorithmjava.code.programmers;

// 프로그래머스 예상 대진표
public class ExpectedBracket {
    public static void main(String[] args) {
        int solution = solution(8, 2, 3);
        // 3 예상
        System.out.println(solution);
    }

    public static int solution(int n, int a, int b) {
        int round = 0;

        while (a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }
}
