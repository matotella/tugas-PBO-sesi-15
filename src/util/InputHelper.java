package util;

import java.util.Scanner;

public class InputHelper {

    private static Scanner input = new Scanner(System.in);

    public static int inputInt(String pesan) {
        System.out.print(pesan);
        return Integer.parseInt(input.nextLine());
    }

    public static double inputDouble(String pesan) {
        System.out.print(pesan);
        return Double.parseDouble(input.nextLine());
    }

    public static String inputString(String pesan) {
        System.out.print(pesan);
        return input.nextLine();
    }

}