package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] numbers = new int[]{3, 5, 1, 2, 5};
        int[] sortedNumbers = new int[] {1, 2, 3, 5, 5};

        Bubble.sort(numbers);

        Assert.assertArrayEquals(sortedNumbers, numbers);
    }

}