package javaPTSDLibrary;

/**
 * Created by jakegsy on 17/10/16.
 */
public class ItemUnavailableException extends Exception {
    private LibraryItem.State reason;

    public ItemUnavailableException(LibraryItem.State _reason){
        this.reason = _reason;
    }

    @Override
    public String getMessage() {
        return "The item is currently " + this.reason + " by another customer. Please try again later.";
    }
}
