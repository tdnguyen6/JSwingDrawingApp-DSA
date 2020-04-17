package sorting;

import java.util.Comparator;


/**
 * Space complexity: O(1) Only 1 var created
 * 
 * Time complexity: O(n^2) based on worst case
 * 
 * Best case: O(n)
 * Array is sorted, i = 0, j loop from 0 to n - 2
 * and no swap is made --> hasSwapped is still false
 * Then, as hasSwapped is false, it breaks the outer
 * loop within i = 0 --> n - 1 operations 
 * ----> O(n)
 * 
 * Worst case: O(n^2)
 * Array is inversely sorted:
 * i = 0 -> j = 0 to n - 2
 * i = 1 -> j = 0 to n - 3
 * i = 2 -> j = 0 to n - 4
 * ...
 * i = n - 2 -> j = 0 to 1
 * total operations = n - 1 + n - 2 + ... + 2 = (n * (n - 1) - 1) * 0.5
 * ----> O(n^2) 
 */
public class BubbleSort<E> implements ISort<E> {
    /**
     * @param array
     * @param comparator Default sort direction is ascending
     */
    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        boolean hasSwapped;
        for (int i = 0; i < array.length - 1; i++) {
            hasSwapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    swapArrayPosition(array, j, j + 1);
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) break;
        }
    }

    /**
     * @param array
     * @param comparator
     * @param sortDirection defined in ISort, ASCENDING or DESCENDING
     */
    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        boolean hasSwapped;
        for (int i = 0; i < array.length - 1; i++) {
            hasSwapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (comparator.compare(array[j], array[j + 1]) == sortDirection.compareResult()) {
                    swapArrayPosition(array, j, j + 1);
                    hasSwapped = true;
                }
            }
            if (!hasSwapped) break;
        }
    }

    private void swapArrayPosition(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Bubble Sort";
    }
}
