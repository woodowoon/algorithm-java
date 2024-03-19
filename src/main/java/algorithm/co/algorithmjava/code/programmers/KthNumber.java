package algorithm.co.algorithmjava.code.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthNumber {

    public static void input() {
        int[] array = {
                1, 5, 2, 6, 3, 7, 4
        };

        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3}
        };

        int[] solution = solution(array, commands);

        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for (int[] command: commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] arr1 = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(arr1);

            answerList.add(arr1[k - 1]);
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int[] array, int[][] commands) {
        int[] answer = new int[commands.length]; // commands.length 만큼 배열을 초기화
        int a = 0;

        for (int[] command: commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];

            int[] arr1 = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(arr1);

            answer[a] = arr1[k-1]; // 배열에 arr1[k-1] 값 넣기
            a++; // 다음 수도 넣어야되기 때문에 ++
        }

        return answer;
    }

}
