package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 4375번 1
public class One {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int number = scanner.nextInt();

            int answer = logic(number);
            System.out.println(answer);
        }

        scanner.close();
    }

    private static int logic(Integer n) {
        int number = 1;
        int length = 1;

        while (number % n != 0) {
            number = (number * 10 + 1) % n;
            length++;
        }

        return length;
    }

}
