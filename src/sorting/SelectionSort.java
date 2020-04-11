package sorting;

import java.util.Comparator;

public class SelectionSort<E> implements ISort<E> {
    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            int extremeIndex = i;
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
        for (int i = 0; i < array.length - 1; i++) {
            int extremeIndex = i;
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
