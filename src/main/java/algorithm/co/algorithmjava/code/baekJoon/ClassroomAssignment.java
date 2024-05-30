package algorithm.co.algorithmjava.code.baekJoon;

import java.util.*;

// 11000번 강의실 배정
public class ClassroomAssignment {
    static class ClassRoom {
        int startTime;
        int endTime;

        public ClassRoom(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) {
        input();
    }

    public static void input() {
        Scanner scanner = new Scanner(System.in);

        List<ClassRoom> classRooms = new ArrayList<>();

        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();

            classRooms.add(new ClassRoom(startTime, endTime));
        }

        sortClassRoom(classRooms);

        scanner.close();

        System.out.println(logic(classRooms));
    }

    private static void sortClassRoom(List<ClassRoom> classRooms) {
        classRooms.sort((c1, c2) -> {
            if (c1.startTime == c2.startTime) {
                return Integer.compare(c1.endTime, c2.endTime);
            } else {
                return Integer.compare(c1.startTime, c2.startTime);
            }
        });
    }

    private static int logic(List<ClassRoom> classRooms) {
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();

        for (ClassRoom classRoom : classRooms) {
            if (!endTimeQueue.isEmpty() && endTimeQueue.peek() <= classRoom.startTime) {
                endTimeQueue.poll();
            }
            endTimeQueue.add(classRoom.endTime);
        }

        return endTimeQueue.size();
    }
}
