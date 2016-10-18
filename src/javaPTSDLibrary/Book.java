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
        if(this.state != State.RETURNED) {
            throw new ItemUnavailableException(this.state);
        } else {
            setCustomer(customer);
            this.state = State.RETURNED;
        }
    }

    public void read(Customer customer) throws ItemUnavailableException{
        if(this.state!=State.RETURNED) {
            throw new ItemUnavailableException(this.state);
        } else {
            setCustomer(customer);
            this.state = State.RETURNED;
        }
    }

    public void returnItem(Customer customer){
        if(customer.equals(this.borrowedBy) && this.state != State.RETURNED){
            this.state = State.RETURNED;
            //this.setCustomer();
        }
    }

    private void setCustomer(Customer customer){
        this.borrowedBy = customer;
    }

}


