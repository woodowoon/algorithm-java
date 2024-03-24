package algorithm.co.algorithmjava.code.programmers;

import java.util.*;

// 우선탐색 > 단어변환
public class WordConversion {

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        int targetIndex = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                targetIndex = i;
            }
        }

        if (targetIndex == -1) {
            return 0;
        }

        Map<String, Integer> visitedMap = new HashMap<>();
        visitedMap.put(begin, 0);

        for (String word : words) {
            visitedMap.put(word, 0);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);

        while (!queue.isEmpty()) {
            String startWord = queue.poll();

            List<String> oneWords = new ArrayList<>();

            for (String word : words) {
                if (isOneLetterOff(startWord, word)) {
                    oneWords.add(word);
                }
            }

            for (String word : oneWords) {
                if (visitedMap.get(word) == 0 && !word.equals(target)) {
                    queue.offer(word);
                    visitedMap.put(word, visitedMap.get(startWord) + 1);
                } else if (word.equals(target)) {
                    answer = visitedMap.get(startWord) + 1;
                }
            }

        }

        return answer;
    }

    private static Boolean isOneLetterOff(String word, String target) {
        int dif = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != target.charAt(i)) {
                dif++;
            }
        }

        return dif == 1;
    }

}
