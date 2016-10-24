package javaPTSDLibrary.Books;

import javaPTSDLibrary.Books.Book;

/**
 * Created by jakegsy on 14/10/16.
 */
public class Textbook extends Book {

    public String module;

    public Textbook(String _name, String _author, int _numPages, String _module){
        super(_name,_author,_numPages);
        this.module = _module;
    }


    public String getModule(){
        return this.module;
    }
    @Override
    public String toString(){
        return "Type: Textbook\nName: " + super.getName() + "\nAuthor: " + super.getAuthor()
                + "\nNumber of Pages: " + super.getNumPages() + "\nModule: " + getModule();
    }
}
