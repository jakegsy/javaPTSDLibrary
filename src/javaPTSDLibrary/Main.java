package javaPTSDLibrary;

import javaPTSDLibrary.Books.*;
import javaPTSDLibrary.Exceptions.*;
import javaPTSDLibrary.LibraryTypes.Customer;
import javaPTSDLibrary.LibraryTypes.Library;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ItemUnavailableException {
        ArrayList<Library> libraries = new ArrayList<Library>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Library program initialized.");
        while(true){
            System.out.print("Please enter your command(for command list, enter 42): ");
                    int command = parseIntErrorWrap(input);
                    switch (command) {
                        case 0:
                            System.out.println("Why are you leaving me?");
                            System.exit(0);
                        case 1:
                            System.out.println("Create Library option selected.");
                            createLibrary(libraries, input);
                            break;

                        case 2:
                            System.out.println("Create Customer option selected.");
                            createCustomer(customers, input);
                            break;

                        case 3:
                            System.out.println("Create Book option selected.");
                            createBook(libraries,input);
                            break;

                        case 4:
                            System.out.println("Add Customer to Library option selected");
                            break;
                        case 5:
                            printCustomers(customers);
                            break;
                        case 6:
                            printLibraries(libraries);
                            break;

                        case 42:
                            System.out.println("1: Create Library\n" +
                                    "2: Create Customer\n" +
                                    "3: Create Book\n" +
                                    "4: Add Customer to Library\n" +
                                    "5: List all Customers\n" +
                                    "6: List all libraries\n" +
                                    "7: Customer to borrow book\n" +
                                    "8: Customer to read book\n" +
                                    "9: Customer to return book\n"+
                                    "0: Quit Program");
                            break;
                        default:
                            System.out.println("Invalid command, please try again.");

                    }
                }



        }



    private static void createLibrary(ArrayList<Library> libraries, Scanner input) {
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
    private static void createCustomer(ArrayList<Customer> customers, Scanner input) {
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
                        + " and address: " + customerAddress +" added.");
                return;
            } else continue;
        }
    }

    private static void createBook(ArrayList<Library> libraries, Scanner input){
        if(libraries.size()==0){
            System.out.println("There are no libraries available for you to put books into, stop wasting my time.");
            return;
        }
        while(true) {
            System.out.print("Please enter Book name: ");
            String bookName = input.nextLine();
            System.out.print("Please enter Book author: ");
            String bookAuthor = input.nextLine();
            System.out.print("Please enter Book number of pages: ");
            int numPages = parseIntErrorWrap(input);
            while(true){
            System.out.print("Please enter Book type: ");
            String bookType = input.nextLine();

            if (comicRoute(input, libraries, bookName, bookAuthor, numPages, bookType)) return;
            else if (sciFiRoute(input,libraries,bookName,bookAuthor,numPages,bookType)) return;
            else if (textbookRoute(input,libraries,bookName,bookAuthor,numPages,bookType)) return;
            else{
                System.out.println("Invalid response to book type, please try again.");
            }
            }
        }
    }
    private static boolean comicRoute(Scanner input, ArrayList<Library> libraries, String bookName, String bookAuthor, int numPages, String bookType) {
        if(bookType.toLowerCase().equals("comic")||bookType.toLowerCase().equals("comics")) {
            System.out.println("Please enter price of comic: ");
            int price = parseIntErrorWrap(input);
            String question = "Confirm Comic |Name: " + bookName + " |Author: " + bookAuthor + " |Pages: " +
                    numPages + " |Price: $" + price + "? (y/n)";
            if (isInputCorrect(question, input)) {
                while (true) {
                    System.out.println("Which library do you want to place this in?");
                    printLibraries(libraries);
                    int libraryIndex = parseIntErrorWrap(input) - 1;
                    if (libraryIndex + 1 > libraries.size()) {
                        System.out.println("Library not found. Try again.");
                        continue;
                    } else {
                        libraries.get(libraryIndex).addBook(new Comic(bookName, bookAuthor, numPages, price));
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean sciFiRoute(Scanner input, ArrayList<Library> libraries, String bookName, String bookAuthor, int numPages, String bookType) {
        if (bookType.toLowerCase().equals("scifi") || bookType.toLowerCase().equals("scifis")) {
            System.out.println("Please enter rating of Sci-Fi(1-5): ");
            boolean ifWithinBounds = false;
            while (!ifWithinBounds) {
                int rating = parseIntErrorWrap(input);
                if (rating <= 5 && rating >= 1) {
                    ifWithinBounds = true;
                } else {
                    System.out.println("Please enter values within 1-5 only.");
                }
                String question = "Confirm Sci-Fi |Name: " + bookName + " |Author: " + bookAuthor + " |Pages: " +
                        numPages + " |Rating: " + rating + "? (y/n)";
                if (isInputCorrect(question, input)) {
                    while (true) {
                        System.out.println("Which library do you want to place this in?");
                        printLibraries(libraries);
                        int libraryIndex = parseIntErrorWrap(input) - 1;
                        if (libraryIndex + 1 > libraries.size()) {
                            System.out.println("Library not found. Try again.");
                            continue;
                        } else {
                            libraries.get(libraryIndex).addBook(new SciFi(bookName, bookAuthor, numPages, rating));
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    private static boolean textbookRoute(Scanner input, ArrayList<Library> libraries, String bookName, String bookAuthor, int numPages, String bookType) {
        if (bookType.toLowerCase().equals("textbook") || bookType.toLowerCase().equals("textbooks")) {
            System.out.println("Please enter module required for: ");
            String module = input.nextLine();
            String question = "Confirm Textbook |Name: " + bookName + " |Author: " + bookAuthor + " |Pages: " +
                    numPages + " |Module: " + module + "? (y/n)";
            if (isInputCorrect(question, input)) {
                while (true) {
                    System.out.println("Which library do you want to place this in?");
                    printLibraries(libraries);
                    int libraryIndex = parseIntErrorWrap(input) - 1;
                    if (libraryIndex + 1 > libraries.size()) {
                        System.out.println("Library not found. Try again.");
                        continue;
                    } else {
                        libraries.get(libraryIndex).addBook(new Textbook(bookName, bookAuthor, numPages, module));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int parseIntErrorWrap(Scanner input){
        while(true){
            try{
                int parsedInput = Integer.parseInt(input.nextLine());
                return parsedInput;
            } catch(NumberFormatException e){
                System.out.println("Please enter integer value only.");
            }
        }
    }
    private static void printLibraries(ArrayList<Library> libraries){
        if(libraries.size()==0) {
            System.out.println("No libraries exist.");
            return;
        }
        for (Library library:libraries){
            System.out.println(library);
        }
    }
    private static void printCustomers(ArrayList<Customer> customers){
        if(customers.size()==0){
            System.out.println("There are no customers.");
            return;
        }
        for (Customer customer:customers){

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


 /*
        Library testLib = new Library("13 College Ave West");
        ItemUnavailableException testException = new ItemUnavailableException(LibraryItem.State.BORROWED);
        Customer cust = new Customer("Jake", "12 College Ave West");
        Customer cust1 = new Customer("Saif", "12 College Ave East");
        System.out.println(cust);
        Comic hulky = new Comic("The Incredible Hulk#1", "Bruce Banner", 42, 326000.00);
        SciFi starTrek = new SciFi("Star Trek", "Picard", 4200, 5);
        Textbook introToAlgo = new Textbook("Introduction to Algorithms", "Cormen", 10000000, "Advanced Algorithms");
        System.out.println(introToAlgo);
        System.out.println(starTrek);
        try {
            hulky.borrow(cust);
            System.out.println("borrowed");
        } catch (ItemUnavailableException e) {
            e.printStackTrace();
        }

        try{
            hulky.borrow(cust1);
            System.out.println("borrowed");
        } catch(ItemUnavailableException e){
            System.out.println(e.getMessage());
        }*/
