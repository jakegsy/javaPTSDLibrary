package javaPTSDLibrary.libraryFactory;

import javaPTSDLibrary.Books.*;
import javaPTSDLibrary.LibraryTypes.Customer;
import javaPTSDLibrary.LibraryTypes.Library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 * Created by jakegsy on 25/10/16.
 */
public class util {

    public static void createLibrary(ArrayList<Library> libraries, Scanner input) {
        while(true) {
            System.out.print("Please enter Library address: ");
            String libraryAddress = input.nextLine();
            String question = "Confirm Library address: " + libraryAddress
                        + "? (y/n)";
            if(isInputCorrect(question,input)){
                libraries.add(new Library(libraryAddress));
                System.out.println("Library of address " + libraryAddress + " added.");
                return;
            } else continue;
        }
    }
    public static void createCustomer(ArrayList<Customer> customers, Scanner input) {
        while(true) {
            System.out.print("Please enter Customer name: ");
            String customerName = input.nextLine();
            System.out.print("Please enter Customer address: ");
            String customerAddress = input.nextLine();
            String question = "Confirm Customer name: " + customerName + " and address: " + customerAddress
                    + "? (y/n)";
            if(isInputCorrect(question, input)){
                customers.add(new Customer(customerName,customerAddress));
                System.out.println("Customer of name: " + customerName
                        + " |Address: " + customerAddress +" added.");
                return;
            } else continue;
        }
    }
    public static void createBook(ArrayList<Library> libraries, Scanner input){
        while(true) {
            System.out.println("Please enter book type: "); String bookType = input.nextLine();
            System.out.println("Please enter book name: "); String bookName = input.nextLine();
            System.out.println("Please enter book author: "); String bookAuthor = input.nextLine();
            System.out.println("Please enter book pages: "); int bookPages = parseIntErrorWrap(input);
            if(bookType.toLowerCase().equals("comic")){
                System.out.println("Please enter Comic price: "); int comicPrice = parseIntErrorWrap(input);
                String question = "Confirm Comic |Name: " + bookName + " |Author: " + bookAuthor + " |Pages: " +
                        bookPages + " |Price: $" + comicPrice + "? (y/n)";
                if(isInputCorrect(question,input)){
                    placeBookInLibrary(new Comic(bookName,bookAuthor,bookPages,comicPrice), libraries, input);
                    System.out.println("Book successfully added to library");
                }
            }
            else if(bookType.toLowerCase().equals("textbook")){
                System.out.println("Please enter Textbook module: "); String module = input.nextLine();
                String question = "Confirm Textbook |Name: " + bookName + " |Author: " + bookAuthor + " |Pages: " +
                        bookPages + " |Module: " + module + "? (y/n)";
                if(isInputCorrect(question,input)){
                    placeBookInLibrary(new Textbook(bookName,bookAuthor,bookPages,module), libraries, input);
                    System.out.println("Book successfully added to library");
                }
            }
            else if(bookType.toLowerCase().equals("scifi")){
                System.out.println("Please enter rating of Sci-Fi(1-5): ");
                boolean ifWithinBounds = false;
                int rating = 0;
                while (!ifWithinBounds) {
                    rating = parseIntErrorWrap(input);
                    if (rating <= 5 && rating >= 1) {
                        ifWithinBounds = true;
                    } else {
                        System.out.println("Please enter values within 1-5 only.");
                    }
                }
                String question = "Confirm Sci-Fi |Name: " + bookName + " |Author: " + bookAuthor + " |Pages: " +
                        bookPages + " |Rating: " + rating + "? (y/n)";
                if(isInputCorrect(question,input)){
                    placeBookInLibrary(new SciFi(bookName,bookAuthor,bookPages,rating), libraries,input);
                    System.out.println("Book successfully added to library");
                }
            }
            else {
                System.out.println("Invalid book type. Please try again.");
            }
        }
    }
    private static void placeBookInLibrary(Book book, ArrayList<Library> libraries, Scanner input){
        while (true) {
            System.out.println("Which library do you want to place this in?");
            printLibraries(libraries);
            int libraryIndex = parseIntErrorWrap(input) - 1;
            if (libraryIndex + 1 > libraries.size()) {
                System.out.println("Library not found. Try again.");
                continue;
            } else {
                libraries.get(libraryIndex).addBook(book);
            }
        }
    }
    public static int parseIntErrorWrap(Scanner input){
        while(true){
            try{
                int parsedInput = Integer.parseInt(input.nextLine());
                return parsedInput;
            } catch(NumberFormatException e){
                System.out.println("Please enter integer value only.");
            }
        }
    }
    public static void printLibraries(ArrayList<Library> libraries){
        if(libraries.size()==0) {
            System.out.println("No libraries exist.");
            return;
        }
        for (Library library:libraries){
            System.out.println(library);
        }
    }
    public static void printCustomers(ArrayList<Customer> customers){
        if(customers.size()==0){
            System.out.println("There are no customers.");
            return;
        }
        System.out.println("==========================");
        for (Customer customer:customers){
            System.out.println(customer);
            System.out.println("==========================");
        }
    }
    public static void printCustomersNonVerbose(ArrayList<Customer> customers){
        for (int i=0; i<customers.size(); i++){
            Customer customer = customers.get(i);
            System.out.println((i+1) + ". Customer Name:" + customer.getName()
            + " |Address: " + customer.getAddress());
        }
    }
    public static void addCustomersToLibrary(ArrayList<Customer> customers, ArrayList<Library> libraries, Scanner input){
        while(true){
            System.out.println("Choose customer to add");
            printCustomersNonVerbose(customers);
            int customerChoice = parseIntErrorWrap(input) - 1;
            if(customerChoice <= customers.size() && customerChoice > 0){
                Customer customer = customers.get(customerChoice);
                while(true){
                    System.out.println("Choose library to add customer to");
                    printLibraries(libraries);
                    int libraryIndex = parseIntErrorWrap(input) - 1;
                    if(libraryIndex + 1 > libraries.size()){
                        System.out.println("Library not found. Try again.");
                        continue;
                    }else{
                        if(customer.addLibrary(libraries.get(libraryIndex))){
                            System.out.println("Customer successfully added to Library " + (libraryIndex + 1));
                            return;
                        }
                    }
                }
            } else {
                System.out.println("Choice out of range. Try again.");
                continue;
            }
        }
    }
    public static void borrowBooks(ArrayList<Customer> customers, Scanner input){
        while(true){
            System.out.println("Choose customer to borrow for");
            printCustomers(customers);
            int customerIndex = parseIntErrorWrap(input) - 1;
            if(customerIndex >=0 && customerIndex < customers.size()){
                Customer customer = customers.get(customerIndex);
                ArrayList<Library> libraries = customer.getLibraries();
                printLibraries(libraries);
                System.out.println("Choose a library to borrow from: ");
                int libraryIndex = parseIntErrorWrap(input) - 1;
                if(libraryIndex >=0 && libraryIndex < customer.getLibraries().size()){
                    Library library = libraries.get(libraryIndex);

                }
            }
        }
    }

    private static boolean isInputCorrect(String question, Scanner input){
        while(true){
            System.out.println(question);
            String confirmation = input.nextLine();
            if(confirmation.toLowerCase().equals("y")){
                return true;
            } else if (!confirmation.toLowerCase().equals("n")){
                System.out.println("Please enter only (y/n) for confirmation");
                continue;
            }
            else{
                return false;
            }
        }
    }
}
