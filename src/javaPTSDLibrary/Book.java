package javaPTSDLibrary;

/**
 * Created by jakegsy on 14/10/16.
 */
public class Book implements LibraryItem{

    public String name;
    public String author;
    public int numPages;
    public State state;

    private Customer borrowedBy;


    public void borrow(Customer customer) throws ItemUnavailableException{
        if(this.state != State.RETURNED){
            throw new ItemUnavailableException(this.state);
        }
    }

    public void read(Customer customer) throws ItemUnavailableException{
        if(this.state!=State.RETURNED){

        }
    }

}


