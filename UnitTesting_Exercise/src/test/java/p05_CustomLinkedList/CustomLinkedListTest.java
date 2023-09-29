package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {

    private CustomLinkedList<String> list;

    @Before
    public void prepare() {
        list = new CustomLinkedList<>();
        list.add("Alex");
        list.add("George");
        list.add("Mike");
    }

    @Test
    public void testAdd() {
        int previousSize = list.getCount() + 1;
        list.add("Andi");

        int currentSize = list.getCount();
        Assert.assertEquals(list.indexOf("Andi"), list.getCount() - 1);
        Assert.assertEquals(previousSize, currentSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsWhenNegativeIndex() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsWhenIndexIsGreaterThanOrEqualsSize() {
        list.get(list.getCount());
    }

    @Test
    public void testGetWhenReturnsValue() {
        String expectedElement = "George";
        Assert.assertEquals(expectedElement, list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowsWhenNegativeIndex() {
        list.set(-1, "Alex");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowsWhenIndexIsGreaterThanOrEqualsSize() {
        list.set(list.getCount() + 1, "Mike");
    }

    @Test
    public void testSetWhenSetsValue() {
        String expectedElement = "Michelle";
        list.set(1, expectedElement);
        Assert.assertEquals(expectedElement, list.get(1));
    }

    @Test
    public void testIndexOfShouldNotFindIndexOfElement() {
        Assert.assertEquals(-1, list.indexOf("Arnold"));
    }

    @Test
    public void testIndexOfShouldFindIndexOfElement() {
        Assert.assertEquals(1, list.indexOf("George"));
    }

    @Test
    public void testContains() {
        Assert.assertTrue(list.contains("George"));
        Assert.assertFalse(list.contains("Arnold"));
    }

    @Test
    public void testRemoveShouldNotReturnIndexOfNonExistentElement() {
        Assert.assertEquals(-1, list.remove("Arnold"));
    }

    @Test
    public void testRemoveShouldReturnIndexOfRemovedElement() {
        int listCountBeforeRemoval = list.getCount();

        Assert.assertEquals(0 ,list.remove("Alex"));

        int listCountAfterRemoval = list.getCount();

        Assert.assertEquals(listCountBeforeRemoval - 1, listCountAfterRemoval);

        Assert.assertEquals(-1, list.indexOf("Alex"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsWhenNegativeIndex() {
        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsWhenIndexIsGreaterThanOrEqualsSize() {
        list.removeAt(list.getCount() + 1);
    }

    @Test
    public void testRemoveAtReturnsElement() {
        Assert.assertEquals("Mike", list.removeAt(2));
        Assert.assertEquals(-1, list.indexOf("Mike"));
    }

}