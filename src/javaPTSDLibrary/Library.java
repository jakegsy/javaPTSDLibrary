package javaPTSDLibrary;

import java.util.ArrayList;

/**
 * Created by jakegsy on 14/10/16.
 */
public class Library {


    public static final String OPENINGHOUR = "0800";  //assuming all libraries operate at this time
    public static final String CLOSINGHOUR = "1900";  //assuming all libraries close at this time
    private static int numOfLibraries = 0;
    //======================================//

    private int id = 0; //To discern between different libraries
    public String address;
    public ArrayList<Book> books;

    public Library(String address){
        this.id = ++numOfLibraries;
        this.address = address;
        this.books = new ArrayList<Book>();
        System.out.format("Welcome to Library #%d, located at %s. We operate from %s to %s.",
                this.id, this.address, OPENINGHOUR, CLOSINGHOUR);
    }




}
