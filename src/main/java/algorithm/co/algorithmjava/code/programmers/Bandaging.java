package algorithm.co.algorithmjava.code.programmers;

// 프로그래머스 붕대감기
public class Bandaging {

    public static void main(String[] args) {
        int[] bandage1 = {
                5, 1, 5
        };
        int health1 = 30;
        int[][] attacks1 = {
                {2, 10}, {9, 15}, {10, 5}, {11, 5}
        };

        int[] bandage2 = {
                3, 2, 7
        };
        int health2 = 20;
        int[][] attacks2 = {
                {1, 15}, {5, 16}, {8, 6}
        };

        int[] bandage3 = {
                4, 2, 7
        };
        int health3 = 20;
        int[][] attacks3 = {
                {1, 15}, {5, 16}, {8, 6}
        };

        int[] bandage4 = {
                1, 1, 1
        };
        int health4 = 5;
        int[][] attacks4 = {
                {1, 2}, {3, 2}
        };

        System.out.println("solution(bandage1, health1, attacks1) = " + solution(bandage1, health1, attacks1));
        System.out.println("solution(bandage2, health2, attacks2) = " + solution(bandage2, health2, attacks2));
        System.out.println("solution(bandage3, health3, attacks3) = " + solution(bandage3, health3, attacks3));
        System.out.println("solution(bandage4, health4, attacks4) = " + solution(bandage4, health4, attacks4));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int mainHellTime = bandage[0];
        int mainHell = bandage[1];
        int addHell = bandage[2];
        int mainHealth = health;

        int min = attacks[attacks.length - 1][0];

        int hellTime = 0;
        for (int i = 1; i <= min; i++) {
            boolean is = true;
            for (int[] attack : attacks) {
                int attackTime = attack[0];
                int damage = attack[1];

                if (attackTime == i) {
                    health -= damage;

                    if (health <= 0) {
                        return -1;
                    }

                    if (min == attackTime) {
                        return health;
                    }
                    hellTime = 0;
                    is = false;
                    break;
                }
            }

            if (is) {
                if (mainHealth > health) {
                    hellTime++;
                    if (mainHealth < health + mainHell) {
                        health = mainHealth;
                    } else {
                        health += mainHell;
                    }

                    if (hellTime == mainHellTime) {
                        if (mainHealth < health + addHell) {
                            health = mainHealth;
                        } else {
                            health += addHell;
                        }

                        hellTime = 0;
                    }
                }
            }
        }

        return health;
    }

}
