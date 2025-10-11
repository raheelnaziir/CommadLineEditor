import java.util.Scanner;

public class CommandLineEditor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		TextEditor textEditor = new TextEditor();
		
		int choice;
		
		do {
			System.out.println("\n==== Command-Line Text Editor ====");
            System.out.println("1. Create New File");
            System.out.println("2. Open Existing File");
            System.out.println("3. Edit Current File");
            System.out.println("4. Save Current File");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine(); // consume newline
			
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
    } while (choice != 5);

		input.close();
            
	

	}

}
