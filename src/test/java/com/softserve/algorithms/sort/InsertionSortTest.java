package java.com.softserve.algorithms.sort;

import com.softserve.algorithms.sort.InsertionSort;
import com.softserve.algorithms.sort.Sort;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTest {
    private int[] unsortedNumbers;
    private int[] expectedElementsOrdering;

    @Before
    public void setUp() {
        unsortedNumbers = new int[] {0, 5, 1100, -1, 10, 8};
        expectedElementsOrdering = new int[] {-1, 0, 5, 8, 10, 1100};
    }

    @Test
    public void testInsertionSortInAscendingOrder() {
        Sort insertionSort = new InsertionSort();
        insertionSort.sort(unsortedNumbers);
        assertArrayEquals(expectedElementsOrdering, unsortedNumbers);
    }
}
