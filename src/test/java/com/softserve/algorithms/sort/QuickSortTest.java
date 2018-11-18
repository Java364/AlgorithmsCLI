package java.com.softserve.algorithms.sort;

import com.softserve.algorithms.sort.QuickSort;
import com.softserve.algorithms.sort.Sort;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    private Sort sort;
    private int[] before;
    private int[] sorted;

    @Before
    public void setUp() throws Exception {
        before = new int[1000];
        for (int i = 0; i < before.length; i++) {
            before[i] = (int) (Math.random() * 1000);
        }
        sorted = Arrays.copyOf(before, before.length);
        Arrays.sort(sorted);
        sort = new QuickSort();
    }

    @Test
    public void sort() {
        assertArrayEquals(sorted, sort.sort(before));
    }

}