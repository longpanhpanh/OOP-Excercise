package Ex14.UI;

import java.util.Scanner;

public class ScannerFactory {
    private static Scanner SCANNER;

    public static Scanner getScanner() {
        if (SCANNER == null) {
            SCANNER = new Scanner(System.in);
        }
        return SCANNER;
    }
}
