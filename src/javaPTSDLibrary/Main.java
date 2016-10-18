package javaPTSDLibrary;

import javaPTSDLibrary.Books.*;
import javaPTSDLibrary.Exceptions.*;
import javaPTSDLibrary.LibraryTypes.Customer;
import javaPTSDLibrary.LibraryTypes.Library;
import javaPTSDLibrary.LibraryTypes.LibraryItem;

public class Main {

    public static void main(String[] args) throws ItemUnavailableException {
	// write your code here
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
        }
    }
}
