package javaPTSDLibrary;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Library testLib = new Library("13 College Ave West");
        ItemUnavailableException testException = new ItemUnavailableException(LibraryItem.State.BORROWED);
        Customer cust = new Customer("Jake", "12 College Ave West");
        System.out.println(cust);
    }
}
