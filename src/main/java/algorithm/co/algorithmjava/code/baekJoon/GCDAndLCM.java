package algorithm.co.algorithmjava.code.baekJoon;

import java.util.Scanner;

// 2609번 최대공약수와 최소공배수
public class GCDAndLCM {

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();

        scanner.close();

        int gcd = getGreatestCommonDivisor(number1, number2);
        int lcm = getLeastCommonMultiple(number1, number2, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }

    // 최대공약수
    private static int getGreatestCommonDivisor(int number1, int number2) {
        while (number2 != 0) {
            int temp = number2;
            number2 = number1 % number2;
            number1 = temp;
        }
        return number1;
    }

    // 최소공배수
    private static int getLeastCommonMultiple(int number1, int number2, int gcd) {
        return (number1 * number2) / gcd;
    }

}
