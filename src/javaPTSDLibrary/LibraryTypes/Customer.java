package javaPTSDLibrary.LibraryTypes;
import javaPTSDLibrary.Exceptions.ItemUnavailableException;
import javaPTSDLibrary.Books.*;

import java.util.Collection;
import java.util.HashSet;
import java.util.ArrayList;

public class Customer {

    private static int numCustomer = 0;
    private String name;
    private String address;
    private int cardNum;
    private ArrayList<LibraryItem> itemsBorrowed;
    private ArrayList<Library> librariesAllowed;

    public Customer(String _name, String _address){
        this.cardNum = ++numCustomer;
        this.name = _name;
        this.address = _address;
        this.itemsBorrowed = new ArrayList<LibraryItem>();
        this.librariesAllowed = new ArrayList<Library>();
    }

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public int getCardNum(){
        return this.cardNum;
    }

    public boolean addLibrary(Library _library){
        return (this.librariesAllowed.add(_library));
    }

    public boolean removeLibrary(Library _library){
        return (this.librariesAllowed.remove(_library));
    }

    public boolean readItem(LibraryItem _item) throws ItemUnavailableException {
        try {
            _item.read(this);
            return true;
        } catch(ItemUnavailableException e){
            e.getMessage();
            return false;
        }
    }
    public ArrayList<Library> getLibraries(){
        return this.librariesAllowed;
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

    public String booksBorrowed(){
        String toReturn = "";
        for (LibraryItem item:itemsBorrowed){
            if (item instanceof Comic){
                toReturn += ((Comic) item).toString();
            }
            if (item instanceof Textbook){
                toReturn += ((Textbook) item).toString();
            }
            if (item instanceof SciFi){
                toReturn += ((SciFi) item).toString();
            }
        }
        return toReturn;
    }


    @Override
    public String toString(){
        return "Name: " + this.name + "\nAddress: "
                + this.address + "\nCard Number: " + this.cardNum
                + booksBorrowed();
    }

}
