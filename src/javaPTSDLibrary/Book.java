package javaPTSDLibrary;

/**
 * Created by jakegsy on 14/10/16.
 */
public class Book {

    private enum State{
        BORROWED,READ,RETURNED
    }

    public String name;
    public String author;
    public int numPages;
    public State state;

    private Customer borrowedBy;


    public void borrow(Customer customer){
        if(this.state==State.RETURNED){
            this.borrowedBy = customer;
            this.state = State.BORROWED;
        }
    }

    public void read(Customer customer){
        if(this.state==State.RETURNED){

        }
    }

}


