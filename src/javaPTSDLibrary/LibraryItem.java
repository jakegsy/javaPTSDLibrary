package javaPTSDLibrary;

/**
 * Created by jakegsy on 17/10/16.
 */
public interface LibraryItem {
    enum State{
        BORROWED,READ,RETURNED
    }
    void borrow(Customer customer) throws ItemUnavailableException;
    void read(Customer customer) throws ItemUnavailableException;
}