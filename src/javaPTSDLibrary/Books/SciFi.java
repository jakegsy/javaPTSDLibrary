package javaPTSDLibrary.Books;

import javaPTSDLibrary.Books.Book;

/**
 * Created by jakegsy on 14/10/16.
 */
public class SciFi extends Book {

    public int rating;

    public SciFi(String _name, String _author, int _numPages, int _rating){
        super(_name,_author,_numPages);
        this.rating = _rating;
    }

    public int getRating(){
        return this.rating;
    }

    @Override
    public String toString(){
        return "Type: Comic\nName: " + super.getName() + "\nAuthor: " + super.getAuthor()
                + "\nNumber of Pages: " + super.getNumPages() + "\nRating: " + prettyPrintRating();
    }

    private String prettyPrintRating(){
        String returnString = "";
        for(int i = 0; i<this.rating; i++){
            returnString += '*';
        }
        return returnString;
    }

}
