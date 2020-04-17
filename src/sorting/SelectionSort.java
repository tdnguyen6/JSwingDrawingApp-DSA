package sorting;

import java.util.Comparator;

/**
 * Space complexity: O(1) Only 1 var: extremeIndex
 * 
 * Time complexity: O(n^2) based on worst case
 * 
 * Worst case: Array is inversedly sorted, every outer loop,
 * the extreme index in that the other end, so for array
 * size n, the inner loop will run
 * n - 1 + n - 2 + ... + 1 = (n - 1) * n * 0.5 ----> O(n^2)
 */
public class SelectionSort<E> implements ISort<E> {
    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        int extremeIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            extremeIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[extremeIndex], array[j]) > 0) {
                    extremeIndex = j;
                }
            }
            swapArrayPosition(array, i, extremeIndex);
        }
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        int extremeIndex;
        for (int i = 0; i < array.length - 1; i++) {
            extremeIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (comparator.compare(array[extremeIndex], array[j]) == sortDirection.compareResult()) {
                    extremeIndex = j;
                }
            }
            swapArrayPosition(array, i, extremeIndex);
        }
    }

    private void swapArrayPosition(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Selection Sort";
    }
}
