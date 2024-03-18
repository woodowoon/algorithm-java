package algorithm.co.algorithmjava.code.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 프로그래머스 > 해시 > 의상
public class Clothes {
    public static void input() {
        String[][] clothes = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "headgear"},
                {"green_turban", "headgear"}
        };

        int solution = solution(clothes);

        System.out.println("solution = " + solution);
    }

    public static int solution(String[][] clothes) {
        Map<String, List<String>> map = new HashMap<>();

        for (String[] cloth : clothes) {
            String type = cloth[1];
            List<String> list = map.getOrDefault(type, new ArrayList<>());

            list.add(cloth[0]);
            map.put(type, list);
        }

        int answer = 1;

        for (List<String> value : map.values()) {
            // 각 종류별 옵션 개수 = 옷의 개수 + 옷을 입지 않는 경우
            answer = answer * (value.size() + 1);
        }

        // 모든 종류의 옷을 입지 않는 경우를 제외
        return answer - 1;
    }

}
