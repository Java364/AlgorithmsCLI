package java.com.softserve.algorithms.sort;

import static org.junit.Assert.assertArrayEquals;
import com.softserve.algorithms.sort.CountingSort;
import com.softserve.algorithms.sort.Sort;
import org.junit.Before;
import org.junit.Test;

public class CountingSortTest {
	
	private int[] unsortedNumbers;
    private int[] expectedElementsOrdering;

    @Before
    public void setUp() {
        unsortedNumbers = new int[] {0, 5, 1100, -1, 10, 8};
        expectedElementsOrdering = new int[] {-1, 0, 5, 8, 10, 1100};
    }

    @Test
    public void testCountingSortInAscendingOrder() {
        Sort countingSort = new CountingSort();
        countingSort.sort(unsortedNumbers);
        assertArrayEquals(expectedElementsOrdering, unsortedNumbers);
    }
}
