package javaPTSDLibrary;

import javaPTSDLibrary.Exceptions.*;
import javaPTSDLibrary.LibraryTypes.Customer;
import javaPTSDLibrary.LibraryTypes.Library;
import javaPTSDLibrary.libraryFactory.util;

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
                    int command = util.parseIntErrorWrap(input);
                    switch (command) {
                        case 0:
                            System.out.println("Why are you leaving me?");
                            System.exit(0);
                        case 1:
                            System.out.println("Create Library option selected.");
                            util.createLibrary(libraries, input);
                            break;

                        case 2:
                            System.out.println("Create Customer option selected.");
                            util.createCustomer(customers, input);
                            break;

                        case 3:
                            System.out.println("Create Book option selected.");
                            util.createBook(libraries,input);
                            break;

                        case 4:
                            System.out.println("Add Customer to Library option selected");
                            break;
                        case 5:
                            util.printCustomers(customers);
                            break;
                        case 6:
                            util.printLibraries(libraries);
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
