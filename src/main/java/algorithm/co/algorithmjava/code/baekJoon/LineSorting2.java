package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 7570번 줄세우기
public class LineSorting2 {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        solution(numbers);
    }

    public static void solution(List<Integer> numbers) {
        List<Integer> dp = new ArrayList<>();

        // DP 리스트를 0으로 초기화합니다. 이 때, n+1 크기로 초기화합니다. (왜냐면 인덱스를 그대로 활용하기 위해서)
        for (int i = 0; i <= numbers.size(); i++) {
            dp.add(0);
        }

        for (int now : numbers) {
            dp.set(now, dp.get(now - 1) + 1);
        }

        System.out.println(numbers.size() - Collections.max(dp));
    }
}
