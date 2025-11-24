
import java.util.Scanner;
public class SafeInput {

    /**
     *
     * @param pipe a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }
    public static int getInt(Scanner pipe, String prompt)
    {
        int retInt = 0;
        boolean loop = true;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                loop = false;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid integer. Try again. You entered: " + trash);
            }
        } while (loop);

        return retInt;

    }


    public static double getDouble(Scanner pipe, String prompt) {
        double retDouble = 0;
        boolean loop = true;

        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine();
                loop = false;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid double. Try again. You entered: " + trash);
            }
        } while (loop);

        return retDouble;
    }


    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retRangeInt = 0;
        boolean loop = true;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retRangeInt = pipe.nextInt();
                pipe.nextLine();
                if (retRangeInt >= low && retRangeInt <= high) {
                    loop = false;
                } else {
                    System.out.println("Input out of range. Try again.");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid integer. Try again. You entered: " + trash);
            }
        } while (loop);

        return retRangeInt;
    }


    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retRangeDouble = 0;
        boolean loop = true;

        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retRangeDouble = pipe.nextDouble();
                pipe.nextLine();
                if (retRangeDouble >= low && retRangeDouble <= high) {
                    loop = false;
                } else {
                    System.out.println("Input out of range. Try again.");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid double. Try again. You entered: " + trash);
            }
        } while (loop);

        return retRangeDouble;
    }


    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean loop = true;
        boolean retYN = false;

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String response = pipe.nextLine().trim();

            if (response.equalsIgnoreCase("Y")) {
                retYN = true;
                loop = false;
            } else if (response.equalsIgnoreCase("N")) {
                retYN = false;
                loop = false;
            } else {
                System.out.println("Invalid response. Enter Y or N.");
            }
        } while (loop);

        return retYN;
    }


    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        boolean loop = true;
        String retString = "";

        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine().trim();

            if (retString.matches(regEx)) {
                loop = false;
            } else {
                System.out.println("Input does not match the required format. Try again.");
            }
        } while (loop);

        return retString;
    }

    public static void prettyHeader(String msg) {
        int totalWidth = 60;
        int stars = 3;

        for (int i = 0; i < totalWidth; i++) System.out.print("*");
        System.out.println();

        int spaces = (totalWidth - 2 * stars - msg.length()) / 2;
        for (int i = 0; i < stars; i++) System.out.print("*");
        for (int i = 0; i < spaces; i++) System.out.print(" ");
        System.out.print(msg);
        for (int i = 0; i < totalWidth - 2 * stars - spaces - msg.length(); i++) System.out.print(" ");
        for (int i = 0; i < stars; i++) System.out.print("*");
        System.out.println();

        for (int i = 0; i < totalWidth; i++) System.out.print("*");
        System.out.println();
    }



}
