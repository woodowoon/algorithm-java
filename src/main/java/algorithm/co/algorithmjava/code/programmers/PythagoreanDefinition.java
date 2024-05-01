package algorithm.co.algorithmjava.code.programmers;

import java.util.Scanner;

// 프로그래머스 피타고라스의 정의
public class PythagoreanDefinition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = sc.nextInt();

        int b_square = (int) Math.pow(c, 2) - (int) Math.pow(a, 2);

        System.out.println(b_square);
    }

}
