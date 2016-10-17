package javaPTSDLibrary;

/**
 * Created by jakegsy on 17/10/16.
 */
public interface LibraryItem {
    enum State{
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
    void borrow(Customer customer) throws ItemUnavailableException;
    void read(Customer customer) throws ItemUnavailableException;
}
/*
DE {
    @Override
    public String toString() {
      return "Germany";
    }
  },
  IT {
    @Override
    public String toString() {
      return "Italy";
    }
  },
  US {
    @Override
    public String toString() {
      return "United States";
    }
  }

}
 */