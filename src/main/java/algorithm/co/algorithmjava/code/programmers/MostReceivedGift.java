package algorithm.co.algorithmjava.code.programmers;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 가장 많이 받은 선물
public class MostReceivedGift {

    public static void main(String[] args) {
        String[] friends = {
                "muzi", "ryan", "frodo", "neo"
        };
        String[] gifts = {
                "muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"
        };

        String[] friends1 = {
                "joy", "brad", "alessandro", "conan", "david"
        };
        String[] gifts1 = {
                "alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"
        };

        String[] friends2 = {
                "a", "b", "c"
        };
        String[] gifts2 = {
                "a b", "b a", "c a", "a c", "a c", "c a"
        };

        System.out.println("solution(friends, gifts) = " + solution(friends, gifts));
        System.out.println("solution(friends1, gifts1) = " + solution(friends1, gifts1));
        System.out.println("solution(friends2, gifts2) = " + solution(friends2, gifts2));
    }

    public static int solution(String[] friends, String[] gifts) {
        int friendsLength = friends.length;
        Map<String, Integer> friendIndex = new HashMap<>();
        int[] giftDegree = new int[friendsLength];
        int[][] giftGraph = new int[friendsLength][friendsLength];

        // 친구 이름을 인덱스로 매핑
        for (int i = 0; i < friendsLength; i++) {
            friendIndex.put(friends[i], i);
        }

        // 선물 기록을 분석하여 그래프와 선물 지수를 구축
        for (String gift : gifts) {
            String[] parts = gift.split(" ");
            int giverIdx = friendIndex.get(parts[0]);
            int receiverIdx = friendIndex.get(parts[1]);

            giftGraph[giverIdx][receiverIdx]++;
            // 선물지수 계산
            giftDegree[giverIdx]++;
            giftDegree[receiverIdx]--;
        }

        // 다음 달에 각 친구가 받을 선물 수 계산
        int maxGiftsReceived = 0;
        for (int giver = 0; giver < friendsLength; giver++) {
            int giftsReceived = 0;
            for (int receiver = 0; receiver < friendsLength; receiver++) {
                if (giver != receiver) {
                    // giver가 receiver에게 선물을 더 많이 주었거나,
                    // 같은 수를 주고받았지만 giver의 선물 지수가 더 높은 경우
                    if (giftGraph[giver][receiver] > giftGraph[receiver][giver] ||
                            (giftGraph[giver][receiver] == giftGraph[receiver][giver] && giftDegree[giver] > giftDegree[receiver])) {
                        giftsReceived++;
                    }
                }
            }
            maxGiftsReceived = Math.max(maxGiftsReceived, giftsReceived);
        }

        return maxGiftsReceived;
    }

}
