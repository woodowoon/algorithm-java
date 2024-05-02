package algorithm.co.algorithmjava.code.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 프로그래머스 수 조작하기2
public class ManipulationNumbers2 {

    public static void main(String[] args) {
        int[] numLog = {
                0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1
        };

        String solution = solution(numLog);
        System.out.println("solution = " + solution);
    }

    public static String solution(int[] numLog) {
        Map<Integer, String> directionMap = new HashMap<>();
        directionMap.put(1, "w");
        directionMap.put(-1, "s");
        directionMap.put(10, "d");
        directionMap.put(-10, "a");

        List<String> result = new ArrayList<>();
        for (int i = 1; i < numLog.length; i++) {
            int diff = numLog[i] - numLog[i - 1];
            if (directionMap.containsKey(diff)) {
                result.add(directionMap.get(diff));
            }
        }

        return String.join("", result);
    }

}
