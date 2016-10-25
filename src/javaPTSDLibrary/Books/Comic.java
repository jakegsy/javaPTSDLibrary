package javaPTSDLibrary.Books;

import javaPTSDLibrary.Books.Book;

/**
 * Created by jakegsy on 14/10/16.
 */
public class Comic extends Book {

    public int price;

    public Comic(String _name, String _author, int _numPages, int _price){
        super(_name,_author,_numPages);
        this.price = _price;
    }

    public double getPrice(){
        return this.price;
    }

    @Override
    public String toString(){
        return "Type: Comic |Name: " + super.getName() + " |Author: " + super.getAuthor()
                + " |Number of Pages: " + super.getNumPages() + " |Price: $" + getPrice()
                + "\n";
    }
}
