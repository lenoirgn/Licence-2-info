import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestBorrow{

    @Test
    public void availableBook()throws BookUnavailableException{
        Book b1=new Book("toto","la paix");
        b1.borrow();
        assertFalse(b1.isBorrowed());
    }
    @Test
    public void unavailableBook()throws BookUnavailableException,BookNotBorrowedException{
        Book b1=new Book("toto","la paix");
        b1.borrow();
        b1.returnBook();
        assertTrue(b1.isBorrowed());

    }

    @Test
    public void unavailableBookNotBorrow()throws BookNotBorrowedException{
        Book b1=new Book("toto","la paix");
        assertThrows(BookNotBorrowedException.class,()->b1.returnBook());

    }

     @Test
    public void unavailableBookSecond()throws BookUnavailableException{
        Book b1=new Book("toto","la paix");
        b1.borrow();
        assertThrows(BookUnavailableException.class,()->b1.borrow());
    }


}
