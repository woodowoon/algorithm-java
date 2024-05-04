package algorithm.co.algorithmjava.code.programmers;

import java.util.*;

// 프로그래머스 달리기 경주
public class RunningRace {

    public static void main(String[] args) {
        String[] players = {
                "mumu", "soe", "poe", "kai", "mine"
        };
        String[] callings = {
                "kai", "kai", "mine", "mine"
        };

        System.out.println("solution(players, callings) = " + Arrays.toString(solution(players, callings)));
    }

    public static String[] solution(String[] players, String[] callings) {
        List<String> ranking = new ArrayList<>(Arrays.asList(players));
        Map<String, Integer> indexMap = new HashMap<>();


        for (int i = 0; i < ranking.size(); i++) {
            indexMap.put(ranking.get(i), i);
        }


        for (String calling : callings) {
            int index = indexMap.get(calling);
            if (index > 0) {
                Collections.swap(ranking, index, index - 1);

                indexMap.put(ranking.get(index), index);
                indexMap.put(ranking.get(index - 1), index - 1);
            }
        }


        return ranking.toArray(new String[0]);
    }

}
