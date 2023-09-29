package p01_Database;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.stream.IntStream;

public class DatabaseTest {

    private static final Integer[] ELEMENTS = IntStream.range(1, 4).boxed().toArray(Integer[]::new);
    private Database db;

    @Before
    public void setUp() throws OperationNotSupportedException {
        //Arrange
        db = new Database(ELEMENTS);
    }

    //1. Базата се създава успешно
    @Test
    public void testConstructorCreatesValidDB() throws OperationNotSupportedException {
        //Act
        Integer[] dbElements = db.getElements();

        //Assert
        assertArrayEquals(ELEMENTS, dbElements);

//        for (int i = 0; i < elements.length; i++) {
//            assertEquals(elements[i], dbElements[i]);
//        }
    }

    //2. Exception при > 16 елемента
    /**
     * Exception при > 16 елемента
     */
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenElementsMoreThan16() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);
    }

    //3. Exception при < 1 елемент
    /**
     * Exception при < 1 елемент
     */
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWhenElementsLessThan1() throws OperationNotSupportedException {
        Integer[] emptyArray = new Integer[0];
        new Database(emptyArray);
    }

    //4. Exception при null
    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementThrowsWhenElementIsNull() throws OperationNotSupportedException {
        db.add(null);
    }

    //5. Успешно добавяне на елемент на края
    @Test
    public void testAddElementToDB() throws OperationNotSupportedException {
        Integer expectedElement = 7;
        db.add(expectedElement);

        Integer[] dbElements = db.getElements();
        Integer dbElement = dbElements[db.getElements().length - 1];

        assertEquals(expectedElement, dbElement);
        assertEquals(ELEMENTS.length + 1, dbElements.length);
    }

    //6. Exception при празен масив
    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementThrowsWhenEmptyDatabase() throws OperationNotSupportedException {
//        for (int i = 0; i < ELEMENTS.length; i++) {
//            db.remove();
//        }

        for (Integer element : db.getElements()) {
            db.remove();
        }

        db.remove();
    }

    //7. Успешно премахване на елемент от края
    @Test
    public void testRemoveElementFromDB() throws OperationNotSupportedException {
        Integer[] dbElementsBeforeRemove = db.getElements();
        db.remove();
        Integer[] dbElementsAfterRemove = db.getElements();

        //Провери дали последния елемент го няма
        assertEquals(dbElementsBeforeRemove.length - 1, dbElementsAfterRemove.length);

        Integer lastElementBeforeRemoval = dbElementsBeforeRemove[dbElementsBeforeRemove.length - 2];
        Integer lastElementAfterRemoval = dbElementsAfterRemove[dbElementsAfterRemove.length - 1];

        //Провери дали последния елемент е друг
        assertEquals("Op", lastElementBeforeRemoval, lastElementAfterRemoval);
    }

}
