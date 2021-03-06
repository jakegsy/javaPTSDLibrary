package javaPTSDLibrary.LibraryTypes;

import javaPTSDLibrary.Exceptions.ItemNotYoursException;
import javaPTSDLibrary.Exceptions.ItemUnavailableException;


public abstract class LibraryItem {
    public enum State{
        BORROWED{
            @Override
            public String toString() {
                return "borrowed";
            }
        },READ{
            @Override
            public String toString() {
                return "read";
            }
        },RETURNED{
            @Override
            public String toString() {
                return "returned";
            }
        }
    }

    public State state;
    private Customer borrowedBy;

    public LibraryItem(){
        this.state = State.RETURNED;
    }

    public void borrow(Customer customer) throws ItemUnavailableException {
        if(this.state!= State.RETURNED) {
            throw new ItemUnavailableException(this.state);
        } else {
            setCustomer(customer);
            this.state = State.BORROWED;
        }
    }

    public void read(Customer customer) throws ItemUnavailableException{
        if(this.state!=State.RETURNED) {
            throw new ItemUnavailableException(this.state);
        } else {
            setCustomer(customer);
            this.state = State.READ;
        }
    }

    private void setCustomer(Customer customer){
        this.borrowedBy = customer;
    }

    public void returnItem(Customer customer) throws ItemNotYoursException {
        if(customer.equals(this.borrowedBy) && this.state != State.RETURNED){
            this.state = State.RETURNED;
            this.setCustomer(null);
        } else{
            throw new ItemNotYoursException(); //Should not be happening, but just to be pedantic about it.
        }
    }

    public void printBorrowedBy(){ //For debugging and verification purposes.
        if(this.borrowedBy != null){
            System.out.println(this.borrowedBy);
        } else {
            System.out.println("Item is currently not borrowed.");
        }
    }

}
