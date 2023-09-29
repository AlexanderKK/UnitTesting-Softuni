package p03_IteratorTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

//Omg
public class ListIteratorTest {

    private static final String[] ELEMENTS = new String[] {"Alex", "Goose", "Mike", "Tyson"};
    private ListIterator iterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        iterator = new ListIterator(ELEMENTS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWhenElementsAreNull() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testConstructorWithValidParameters() throws OperationNotSupportedException {
        int index = 0;
        while(iterator.hasNext()) {
            assertEquals(ELEMENTS[index++], iterator.print());
            iterator.move();
        }
        assertEquals(ELEMENTS[index], iterator.print());
    }

    @Test
    public void testMove() {
        while(iterator.hasNext()) {
            assertTrue(iterator.move());
        }
        assertFalse(iterator.move());
    }

    @Test
    public void testHasNext() {
        while(iterator.hasNext()) {
            assertTrue(iterator.hasNext());
            iterator.move();
        }
        assertFalse(iterator.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWhenListIsEmpty() throws OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }

    @Test
    public void testPrintWhenListReturns() {
        assertEquals(ELEMENTS[0], iterator.print());
        iterator.move();
        assertEquals(ELEMENTS[1], iterator.print());
    }
}