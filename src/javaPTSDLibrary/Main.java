package javaPTSDLibrary;

import javaPTSDLibrary.Books.*;
import javaPTSDLibrary.Exceptions.*;
import javaPTSDLibrary.LibraryTypes.Customer;
import javaPTSDLibrary.LibraryTypes.Library;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ItemUnavailableException {
	// write your code here
        ArrayList<Library> libraries = new ArrayList<Library>();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        Scanner input = new Scanner(System.in);
        System.out.println("Library program initialized.");
        while(true){
            System.out.print("Please enter your command(for command list, enter 42): ");
                String rawCommand = input.nextLine();
                try{
                    int command = Integer.parseInt(rawCommand);
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

                        case 6:
                            printLibraries(libraries);
                            break;

                        case 42:
                            System.out.println("1: Create Library\n" +
                                    "2: Create Customer\n" +
                                    "3: Create Book\n" +
                                    "0: Quit Program");
                            break;
                        default:
                            System.out.println("Invalid command, please try again.");

                    }
                } catch(NumberFormatException e){
                    System.out.println("Please enter integer value only. As punishment for being naughty, you're gonna start over again.");
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


    private static void createLibrary(ArrayList<Library> libraries, Scanner input) {
        while(true) {
            System.out.print("Please enter Library address: ");
            String libraryAddress = input.nextLine();
            while (true) {
                System.out.println("Confirm Library address: " + libraryAddress
                        + "? (y/n)");
                String confirmation = input.nextLine();
                if (confirmation.toLowerCase().equals("y")) {
                    libraries.add(new Library(libraryAddress));
                    System.out.println("Library of address " + libraryAddress + " added.");
                    return;
                }
                else if (!confirmation.toLowerCase().equals("n")){
                    System.out.println("Please enter only (y/n) for confirmation");
                } else {break;}
            }
        }
    }
    private static void createCustomer(ArrayList<Customer> customers, Scanner input) {
        while(true) {
            System.out.print("Please enter Customer name: ");
            String customerName = input.next();
            System.out.print("Please enter Customer address: ");
            String customerAddress = input.next();
            while (true) {
                System.out.println("Confirm Customer name: " + customerName + " and address: " + customerAddress
                        + "? (y/n)");
                String confirmation = input.next();
                if (confirmation.toLowerCase().equals("y")) {
                    customers.add(new Customer(customerName,customerAddress));
                    System.out.println("Customer of name: " + customerName
                            + " and address: " + customerAddress +" added.");
                    return;
                }
                else if (!confirmation.toLowerCase().equals("n")){
                    System.out.println("Please enter only (y/n) for confirmation");
                } else {break;}
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
            int numPages = Integer.parseInt(input.nextLine());
            System.out.print("Please enter Book type: ");
            String bookType = input.nextLine();
            if(bookType.toLowerCase().equals("comic")||bookType.toLowerCase().equals("comics")){
                System.out.println("Please enter price of comic: ");
                int price = Integer.parseInt(input.nextLine());
                System.out.println("naught me");
            }
           /* while (true) {
                System.out.println("Confirm Library address: " + libraryAddress
                        + "? (y/n)");
                String confirmation = input.next();
                if (confirmation.toLowerCase().equals("y")) {
                    libraries.add(new Library(libraryAddress));
                    System.out.println("Library of address " + libraryAddress + " added.");
                    return;
                }
                else if (!confirmation.toLowerCase().equals("n")){
                    System.out.println("Please enter only (y/n) for confirmation");
                } else {break;}
            }*/
        }

    }
}
