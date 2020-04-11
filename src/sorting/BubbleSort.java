package sorting;

import java.util.Comparator;

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
