
import java.io.*;
import java.util.*;

public class TextEditor extends EditorFeatures{
	
	private Scanner input;
	private String currentFileName;
	private StringBuilder content;  
	
	TextEditor() {
		input = new Scanner(System.in);
		content = new StringBuilder();
		
	}

	@Override
	public void createNewFile(String fileName) {
		 currentFileName = fileName;
	     content = new StringBuilder();
	     System.out.println("New file created: " + currentFileName);
		
	}

	@Override
	public void openFile(String fileName) {
		
		currentFileName = fileName;
	    content = new StringBuilder();

	    File file = new File(fileName);
	    if (!file.exists()) {
	        System.out.println("File not found: " + fileName);
	        return;
	    }

	    // Prevent reading files larger than 10 MB
	    if (file.length() > 10 * 1024 * 1024) {
	        System.out.println("Error: File too large to open (limit: 10MB).");
	        return;
	    }

	    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	        String line;
	        while ((line = reader.readLine()) != null) {
	            content.append(line).append("\n");
	        }
	        System.out.println("\nFile opened successfully. Content:\n");
	        System.out.println(content);
	    } catch (IOException e) {
	        System.out.println("Error opening file: " + e.getMessage());
	    } catch (OutOfMemoryError e) {
	        System.out.println("Error: File too large to load into memory.");
	    }
		
		
	}

	@Override
	public void editFile(String fileName) {
		
		 if (currentFileName == null) {
	            System.out.println("No file is currently open. Please create or open a file first.");
	            return;
	        }

	        int choice;
	        
	        System.out.println("\n--- Edit Menu ---");
            System.out.println("1. Append Text");
            System.out.println("2. Delete All Text");
            System.out.println("3. Replace Entire Text");
            System.out.println("4. Show Current Content");
            System.out.println("5. Exit Edit Mode");
            
	        do {
	            
	            System.out.print("Enter your choice: ");
	            choice = input.nextInt();
	            input.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter text to append: ");
	                    String appendText = input.nextLine();
	                    content.append(appendText).append("\n");
	                    System.out.println("Text appended.");
	                    break;
	                case 2:
	                    content = new StringBuilder();
	                    System.out.println("All text deleted.");
	                    break;
	                case 3:
	                    System.out.print("Enter new text: ");
	                    content = new StringBuilder(input.nextLine() + "\n");
	                    System.out.println("Text replaced.");
	                    break;
	                case 4:
	                    System.out.println("\n--- Current File Content ---\n" + content);
	                    break;
	                case 5:
	                    System.out.println("Exiting edit mode...");
	                    break;
	                default:
	                    System.out.println("Invalid option! Try again.");
	            }
	        } while (choice != 5);
	        
		
	}

	@Override
	public void saveFile(String fileName, String contentToSave) { 
			
			// To save file into the system
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(contentToSave);
            System.out.println("File saved successfully as " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
	}
	
	 // Getter for content 
    public String getContent() {
        return content.toString();
    }

    // Polymorphism 
    @Override
    public String toString() {
        return "TextEditor handling file: " + currentFileName;
    }
	
    

}
