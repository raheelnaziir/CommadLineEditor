import java.util.Scanner;

public class CommandLineEditor {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        TextEditor textEditor = new TextEditor();

        int choice = 0;

        do {
            clearScreen(); // clear console
            System.out.println("");
            System.out.println("Current File: " +
                    (textEditor.getCurrentFileName() != null ? textEditor.getCurrentFileName() : "None"));
            System.out.println("1. Create New File    2. Open Existing File  3. Edit Current File  4. Save Current File  5. Delete File    6. Exit");

            System.out.print("\nEnter your choice: ");
            try {
                choice = Integer.parseInt(input.nextLine()); // safely parse input
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue; // go to next loop iteration
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter new file name: ");
                    String newFile = input.nextLine();
                    textEditor.createNewFile(newFile);
                    break;

                case 2:
                    System.out.print("Enter file name to open: ");
                    String openFile = input.nextLine();
                    textEditor.openFile(openFile);
                    break;

                case 3:
                    textEditor.editFile("");
                    break;

                case 4:
                    System.out.print("Enter file name to save: ");
                    String saveName = input.nextLine();
                    textEditor.saveFile(saveName, textEditor.getContent());
                    break;

                case 5:
                    System.out.print("Enter file name to delete: ");
                    String deleteFileName = input.nextLine();
                    textEditor.deleteFile(deleteFileName);
                    break;

                case 6:
                    System.out.print("Do you want to save before exiting? (yes/no): ");
                    String saveChoice = input.nextLine();
                    if (saveChoice.equalsIgnoreCase("yes")) {
                        System.out.print("Enter file name to save: ");
                        String saveFile = input.nextLine();
                        textEditor.saveFile(saveFile, textEditor.getContent());
                    }
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }

            System.out.println("\nPress Enter to continue...");
            input.nextLine(); // pause for user to read messages

        } while (choice != 6); // exit on option 6

        input.close();
    }
}
