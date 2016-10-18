package javaPTSDLibrary;
import java.util.HashSet;
import java.util.ArrayList;
/**
 * Created by jakegsy on 14/10/16.
 */
public class Customer {

    private static int numCustomer = 0;

    private String name;
    private String address;
    private int cardNum;
    private ArrayList<LibraryItem> itemsBorrowed;
    private HashSet<Library> librariesAllowed;

    public Customer(String _name, String _address){
        this.cardNum = numCustomer++; //starting from 0 as a design choice.
        this.name = _name;
        this.address = _address;
        this.itemsBorrowed = new ArrayList<LibraryItem>();
        this.librariesAllowed = new HashSet<Library>();
    }

    public boolean addLibrary(Library _library){
        return (this.librariesAllowed.add(_library));
    }

    public boolean removeLibrary(Library _library){
        return (this.librariesAllowed.remove(_library));
    }

    public boolean readItem(LibraryItem _item) throws ItemUnavailableException{
        try {
            _item.read(this);
            return true;
        } catch(ItemUnavailableException e){
            e.getMessage();
            return false;
        }
    }

    public boolean borrowItem(LibraryItem _item) throws ItemUnavailableException{
        try {
            _item.borrow(this);
            return true;
        } catch(ItemUnavailableException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public String toString(){
        return "Name: " + this.name + "\nAddress: " + this.address + "\nCard Number: " + this.cardNum;
    }

}
