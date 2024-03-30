package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// 9012번 괄호
// 스택의 성질을 이용해서 풀이
public class Bracket {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();

            String value = logic(string);

            sb.append(value).append("\n");

        }

        scanner.close();

        System.out.println(sb);
    }

    private static String logic(String value) {
        Deque<Character> deque = new LinkedList<>();

        for (Character c : value.toCharArray()) {
            if (c == '(') {
                deque.offer(c);
            } else {
                if (deque.isEmpty()) return "NO";

                deque.pollLast();
            }
        }

        return deque.isEmpty() ? "YES" : "NO";
    }
}
