package Library;
	import java.io.*;
	import java.util.ArrayList;
	import java.util.List;

	public class LibraryManager {
	    private static final String FILE_PATH = "src/main/resources/books.txt";

	    public void addBook(String title, String author, String isbn) {
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
	            writer.write(String.format("%s,%s,%s%n", title, author, isbn));
	            System.out.println("Book added successfully!");
	        } catch (IOException e) {
	            System.err.println("Error while adding book: " + e.getMessage());
	        }
	    }

	    public void viewBooks() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	            String line;
	            System.out.println("Books in Library:");
	            while ((line = reader.readLine()) != null) {
	                String[] details = line.split(",");
	                System.out.printf("Title: %s, Author: %s, ISBN: %s%n", details[0], details[1], details[2]);
	            }
	        } catch (IOException e) {
	            System.err.println("Error while reading books: " + e.getMessage());
	        }
	    }

	    public void removeBook(String isbn) {
	        List<String> books = new ArrayList<>();
	        boolean bookRemoved = false;

	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                if (!line.contains(isbn)) {
	                    books.add(line);
	                } else {
	                    bookRemoved = true;
	                }
	            }
	        } catch (IOException e) {
	            System.err.println("Error while reading books: " + e.getMessage());
	        }

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
	            for (String book : books) {
	                writer.write(book + System.lineSeparator());
	            }
	        } catch (IOException e) {
	            System.err.println("Error while updating books: " + e.getMessage());
	        }

	        if (bookRemoved) {
	            System.out.println("Book removed successfully!");
	        } else {
	            System.out.println("Book with ISBN " + isbn + " not found.");
	        }
	    }
	}

	


