package algorithm.co.algorithmjava.code.baekJoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 수열 2491번
public class Sequence {
    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(scanner.nextInt());
        }

        scanner.close();

        logic(numbers);
    }

    private static void logic(List<Integer> numbers) {
        int maxLength = 1; // 최소 길이는 1로 시작
        int incLength = 1; // 증가하는 수열의 길이
        int decLength = 1; // 감소하는 수열의 길이

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                incLength++; // 증가 수열 길이 증가
                decLength = 1; // 감소 수열 길이 초기화
            } else if (numbers.get(i) < numbers.get(i - 1)) {
                decLength++; // 감소 수열 길이 증가
                incLength = 1; // 증가 수열 길이 초기화
            } else {
                // 숫자가 이전 숫자와 같은 경우, 둘 다 증가
                incLength++;
                decLength++;
            }
            // 최대 길이 업데이트
            maxLength = Math.max(maxLength, Math.max(incLength, decLength));
        }

        System.out.println(maxLength);
    }
}
