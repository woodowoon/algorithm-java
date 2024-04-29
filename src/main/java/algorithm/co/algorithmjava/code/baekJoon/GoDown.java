package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Arrays;
import java.util.Scanner;

// 2096번 내려가기
public class GoDown {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] preMax = new int[3];
        int[] preMin = new int[3];

        for (int i = 0; i < 3; i++) {
            preMin[i] = preMax[i] = scanner.nextInt();
        }

        for (int i = 1; i < n; i++) {
            int[] currentMax = new int[3];
            int[] currentMin = new int[3];
            int[] row = new int[3];

            for (int j = 0; j < 3; j++) {
                row[j] = scanner.nextInt();
            }

            currentMax[0] = Math.max(preMax[0], preMax[1]) + row[0];
            currentMax[1] = Math.max(Math.max(preMax[0], preMax[1]), preMax[2]) + row[1];
            currentMax[2] = Math.max(preMax[1], preMax[2]) + row[2];

            currentMin[0] = Math.min(preMin[0], preMin[1]) + row[0];
            currentMin[1] = Math.min(Math.min(preMin[0], preMin[1]), preMin[2]) + row[1];
            currentMin[2] = Math.min(preMin[1], preMin[2]) + row[2];

            preMax = currentMax;
            preMin = currentMin;
        }

        scanner.close();

        int maxScore = Math.max(Math.max(preMax[0], preMax[1]), preMax[2]);
        int minScore = Math.min(Math.min(preMin[0], preMin[1]), preMin[2]);

        System.out.println(maxScore + " " + minScore);
    }

    // dp 로 풀었을때 메모리 초과
    public static void dpLogic() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] numbers = new int[n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                numbers[i][j] = scanner.nextInt();
            }
        }

        scanner.close();

        // 초기 최대/최소 점수 설정
        int[] maxDp = Arrays.copyOf(numbers[0], 3);
        int[] minDp = Arrays.copyOf(numbers[0], 3);

        // 각 행에 대해 최대 점수와 최소 점수 계산
        for (int i = 1; i < n; i++) {
            int[] currentMax = new int[3];
            int[] currentMin = new int[3];

            currentMax[0] = Math.max(maxDp[0], maxDp[1]) + numbers[i][0];
            currentMax[1] = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + numbers[i][1];
            currentMax[2] = Math.max(maxDp[1], maxDp[2]) + numbers[i][2];

            currentMin[0] = Math.min(minDp[0], minDp[1]) + numbers[i][0];
            currentMin[1] = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + numbers[i][1];
            currentMin[2] = Math.min(minDp[1], minDp[2]) + numbers[i][2];

            maxDp = Arrays.copyOf(currentMax, 3);
            minDp = Arrays.copyOf(currentMin, 3);
        }

        // 결과 출력
        Arrays.sort(maxDp);
        Arrays.sort(minDp);
        System.out.println(maxDp[2] + " " + minDp[0]);
    }

}
