package javaPTSDLibrary.Exceptions;

/**
 * Created by jakegsy on 19/10/16.
 */
public class ItemNotYoursException extends Exception{
    @Override
    public String getMessage() {
        return "You don't own this book, why are you trying to return it?";
    }
}
