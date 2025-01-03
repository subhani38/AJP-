package Library;
	import java.util.Scanner;

	public class LibraryApp {
	    public static void main(String[] args) {
	        LibraryManager manager = new LibraryManager();
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nLibrary Management System");
	            System.out.println("1. Add a Book");
	            System.out.println("2. View All Books");
	            System.out.println("3. Remove a Book");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter book title: ");
	                    String title = scanner.nextLine();
	                    System.out.print("Enter book author: ");
	                    String author = scanner.nextLine();
	                    System.out.print("Enter book ISBN: ");
	                    String isbn = scanner.nextLine();
	                    manager.addBook(title, author, isbn);
	                    break;

	                case 2:
	                    manager.viewBooks();
	                    break;

	                case 3:
	                    System.out.print("Enter book ISBN to remove: ");
	                    String isbnToRemove = scanner.nextLine();
	                    manager.removeBook(isbnToRemove);
	                    break;

	                case 4:
	                    System.out.println("Exiting system. Goodbye!");
	                    scanner.close();
	                    System.exit(0);

	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }
	    }
	}



