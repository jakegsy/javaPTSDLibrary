package javaPTSDLibrary;

import javaPTSDLibrary.Books.*;
import javaPTSDLibrary.Exceptions.*;
import javaPTSDLibrary.LibraryTypes.Customer;
import javaPTSDLibrary.LibraryTypes.Library;
import javaPTSDLibrary.LibraryTypes.LibraryItem;

import java.util.InputMismatchException;
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
            System.out.print("Please enter your command: ");

            if(input.hasNextInt()){
                int command = input.nextInt();
                switch (command) {
                    case 1:
                        System.out.println("Create Library option selected.");
                        createLibrary(libraries, input);
                        break;

                    case 2:
                        System.out.println("Create Customer option selected.");
                        createCustomer(customers, input);
                        break;
                    default:
                        System.out.println("Invalid command, please try again.");

                }
            }
            else {
                System.out.println("Please enter only integer commands.");
                input.next();
                continue;
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
    }

    private static void createLibrary(ArrayList<Library> libraries, Scanner input) {
        while(true) {
            System.out.print("Please enter Library address: ");
            String libraryAddress = input.next();
            System.out.println("");
            while (true) {
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
                    Customer addMe = new Customer(customerName,customerAddress);
                    customers.add(addMe);
                    System.out.println("Customer of " + addMe + " added.");
                    return;
                }
                else if (!confirmation.toLowerCase().equals("n")){
                    System.out.println("Please enter only (y/n) for confirmation");
                } else {break;}
            }
        }
    }
}
