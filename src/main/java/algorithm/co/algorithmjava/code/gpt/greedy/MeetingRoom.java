package algorithm.co.algorithmjava.code.gpt.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// GPT 회의실
public class MeetingRoom {

    static class Room{
        int startT;
        int endT;

        public Room(int startT, int endT) {
            this.startT = startT;
            this.endT = endT;
        }
    }

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            rooms.add(new Room(start, end));
        }

        scanner.close();

        int logic = logic(rooms);
        System.out.println("logic = " + logic);
    }

    private static int logic(List<Room> rooms) {
        if (rooms.isEmpty()) return 0; // 회의가 없는 경우 0을 반환

        rooms.sort(
            Comparator.comparingInt(room -> room.endT));

        int meetingCount = 1;
        int lastEnd = rooms.get(0).endT; // 첫 회의의 끝나는 시간을 초기 값으로 설정

        // 첫 번째 회의를 제외하고 순회
        for (int i = 1; i < rooms.size(); i++) {
            if (rooms.get(i).startT >= lastEnd) { // 다음 회의의 시작 시간이 현재 회의의 끝나는 시간보다 크거나 같다면
                meetingCount++;
                lastEnd = rooms.get(i).endT; // 마지막으로 종료된 회의 시간 업데이트
            }
        }

        return meetingCount;
    }

}
