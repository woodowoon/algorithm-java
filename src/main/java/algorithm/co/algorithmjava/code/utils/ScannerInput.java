package algorithm.co.algorithmjava.code.utils;

import java.util.Scanner;

public class ScannerInput {
    private static Scanner scanner;

    private ScannerInput() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    public static int nextInt() {
        return scanner.nextInt();
    }

    public static boolean hasNextInt() {
        return scanner.hasNextInt();
    }

    public static void close() {
        if (scanner != null) {
            scanner.close();
            scanner = null;
        }
    }

    private static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
