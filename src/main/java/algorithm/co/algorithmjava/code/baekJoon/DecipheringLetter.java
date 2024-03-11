package algorithm.co.algorithmjava.code.baekJoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 문자 해독 1593 번
public class DecipheringLetter {

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int g = scanner.nextInt();
        int sSize = scanner.nextInt();

        scanner.nextLine();

        String w = scanner.nextLine();
        String s = scanner.nextLine();

        scanner.close();

        System.out.println(countPermutations(w, s));
    }

    private static int countPermutations(String w, String s) {
        int count = 0;

        Map<Character, Integer> wMap = new HashMap<>();
        for (char c : w.toCharArray()) {
            wMap.put(c, wMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < w.length(); i++) {
            char c = s.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
        }

        if (windowMap.equals(wMap)) {
            count++;
        }

        int start = 0;
        for (int i = w.length(); i < s.length(); i++) {
            char addChar = s.charAt(i);
            char removeChar = s.charAt(start);

            windowMap.put(addChar, windowMap.getOrDefault(addChar, 0) + 1);

            if (windowMap.get(removeChar) == 1) {
                windowMap.remove(removeChar);
            } else {
                windowMap.put(removeChar, windowMap.get(removeChar) - 1);
            }

            if (windowMap.equals(wMap)) {
                count++;
            }

            start++;
        }

        return count;
    }

}
