import java.util.Scanner;

public class CommandLineEditor {
	
	public static void clearScreen() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}

	public static void main(String[] args) {
		
		
		Scanner input = new Scanner(System.in);
		TextEditor textEditor = new TextEditor();
		
		int choice;
		
		//System.out.println("\n==== Command-Line Text Editor ====");
		System.out.println("");
        System.out.println("1. Create New File    2. Open Existing File  3. Edit Current File  4. Save Current File  5. Exit");
		
		do {
			
            System.out.print("\nEnter your choice: ");
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
