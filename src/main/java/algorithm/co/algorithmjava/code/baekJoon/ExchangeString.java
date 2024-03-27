package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 1522번 문자열 교환
// 고려해야될 사항
    // 1. 문자열을 원형의 형태로 되어있다.

public class ExchangeString {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        String value = scanner.nextLine();

        scanner.close();

        System.out.println(minSwapsToMakeAContinuous(value));
    }

    // 총 A 의 개수를 구하고 해당 A 의 개수 슬라이딩 마다 최대의 A 개수를 구한 뒤 총 A - 슬라이딩 A 개수
    private static int minSwapsToMakeAContinuous(String s) {
        int n = s.length();
        int totalA = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') totalA++;
        }

        if (totalA == 0) return 0;

        int maxAInWindow = 0, currentA = 0;
        int start = 0;
        String extended = s + s;

        for (int i = 0; i < extended.length(); i++) {
            if (extended.charAt(i) == 'a') {
                currentA++;
            }
            if (i >= totalA) {
                if (extended.charAt(start) == 'a') {
                    currentA--;
                }
                start++;
            }

            maxAInWindow = Math.max(maxAInWindow, currentA);
        }

        return totalA - maxAInWindow;
    }

}
