import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean quit = false;

        System.out.println("Welcome to ListMaker");



        //main loop

        while (!quit) {
            funniMenu();
            String input = in.nextLine().trim();


            if (input.length() == 0 || !"AaDdIiPpQq".contains(input)) {
                System.out.println("Invalid input. You entered: " + input);
            } else {
                char choice = Character.toUpperCase(input.charAt(0));

                switch (choice) {
                    case 'A':
                        addItem(list, in);
                        break;
                    case 'D':
                        deleteItem(list, in);
                        break;
                    case 'I':
                        insertItem(list, in);
                        break;
                    case 'P':
                        printList(list);
                        break;
                    case 'Q':
                        quit = quitProgram(in);
                        break;
                }
            }
        }

    }






    //wacky wee functions so that things run

    private static void addItem(ArrayList<String> list, Scanner in) {
        String item = SafeInput.getNonZeroLenString(in, "Enter item to add");
        list.add(item);
        System.out.println("'" + item + "' added to the list.");
    }




    private static void insertItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            addItem(list, in);
            return;
        }

        printNumberedList(list);
        int index = SafeInput.getRangedInt(in, "Enter position to insert", 1, list.size() + 1) - 1;
        String item = SafeInput.getNonZeroLenString(in, "Enter item to insert");
        list.add(index, item);
        System.out.println("'" + item + "' inserted at position " + (index + 1) + ".");
    }




    private static void deleteItem(ArrayList<String> list, Scanner in) {
        if (list.isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        printNumberedList(list);
        int index = SafeInput.getRangedInt(in, "Enter item number to delete", 1, list.size()) - 1;
        String removed = list.remove(index);
        System.out.println("'" + removed + "' removed from the list.");
    }




    private static void printList(ArrayList<String> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        System.out.println("Current list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }




    private static boolean quitProgram(Scanner in) {
        return SafeInput.getYNConfirm(in, "Are you sure you want to quit?");
    }




    private static void printNumberedList(ArrayList<String> list) {
        System.out.println("Current list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }




    private static void funniMenu() {
        System.out.println("\nMenu:");
        System.out.println("[A] Add an item");
        System.out.println("[D] Delete an item");
        System.out.println("[I] Insert an item");
        System.out.println("[P] Print the list");
        System.out.println("[Q] Quit");
        System.out.print("Enter command: ");
    }
}
