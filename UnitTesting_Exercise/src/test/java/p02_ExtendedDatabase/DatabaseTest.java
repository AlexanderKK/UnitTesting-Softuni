package p02_ExtendedDatabase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {

    private static final Person MIKE = new Person(1, "Mike");
    private static final Person RYAN = new Person(2, "Ryan");

    private Database db;

    @Before
    public void setUp() throws OperationNotSupportedException {
        db = new Database(MIKE, RYAN);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonThrowsWhenMultipleUsersAreWithSameId() throws OperationNotSupportedException {
        db.add(MIKE);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonThrowsWhenNegativeNorNullIdPresent() throws OperationNotSupportedException {
        Person andi = new Person(-1, "Andi");
        db.add(andi);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsWhenUserIsNotPresent() throws OperationNotSupportedException {
        String username = "Orange";
        db.findByUsername(username);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameThrowsWhenUserNameIsNull() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test
    public void testFindByUsernameReturnsUser() throws OperationNotSupportedException {
        Person existingPerson = db.findByUsername(MIKE.getUsername());

        assertEquals(MIKE, existingPerson);
        assertEquals(MIKE.getUsername(), existingPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdThrowsWhenUserIsNotPresent() throws OperationNotSupportedException {
        int id = 0;
        db.findById(id);
    }

    @Test
    public void testFindByIdReturnsUser() throws OperationNotSupportedException {
        Person existingPerson = db.findById(RYAN.getId());
        assertEquals(RYAN, existingPerson);
        assertEquals(RYAN.getId(), existingPerson.getId());
    }
}