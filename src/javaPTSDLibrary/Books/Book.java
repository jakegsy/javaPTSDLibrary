package javaPTSDLibrary.Books;

import javaPTSDLibrary.LibraryTypes.LibraryItem;

/**
 * Created by jakegsy on 14/10/16.
 */
public abstract class Book extends LibraryItem {

    public String name;
    public String author;
    public int numPages;
    public String type;

    public Book(String _name, String _author, int _numPages){
        super();
        this.name = _name;
        this.author = _author;
        this.numPages = _numPages;
    }

    public String getName(){
        return this.name;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getNumPages(){
        return this.numPages;
    }

    public boolean isBook(String _name, String _author){
        return (_name.equals(this.name) && _author.equals(this.author));
    }








}


