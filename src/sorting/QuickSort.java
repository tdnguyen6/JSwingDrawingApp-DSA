package sorting;

import java.util.Comparator;
import java.util.Random;

public class QuickSort<E> implements ISort<E> {
    Random random = new Random();

    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        random.setSeed(array.length);
        doQuickSort(array, 0, array.length - 1, comparator, SortDirection.ASCENDING);
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        random.setSeed(array.length);
        doQuickSort(array, 0, array.length - 1, comparator, sortDirection);
    }

    private void doQuickSort(
            E[] array, int first, int last, Comparator<E> comparator, SortDirection sortDirection) {
        if (first < last) {
            int pivotIndex = partition(array, first, last, comparator, sortDirection);
            doQuickSort(array, first, pivotIndex - 1, comparator, sortDirection);
            doQuickSort(array, pivotIndex + 1, last, comparator, sortDirection);
        }
    }

    private int partition(
            E[] array, int first, int last, Comparator<E> comparator, SortDirection sortDirection) {

        // Pivot is the median of 3 random elements --> better performance
        int pivotIndex = median(random.nextInt(last - first + 1) + first, random.nextInt(last - first + 1) + first, random.nextInt(last - first + 1) + first, array, comparator);
        swapArrayPosition(array, first, pivotIndex);

        E pivot = array[first];
        int i = last + 1;

        for (int j = last; j >= first; j--) {
            if (comparator.compare(array[j], pivot) == sortDirection.compareResult()) {
                i--;
                swapArrayPosition(array, i, j);
            }
        }
        swapArrayPosition(array, i - 1, first);
        return i - 1;
    }

    private void swapArrayPosition(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int median(int a, int b, int c, E[] array, Comparator<E> comparator) {
        if (comparator.compare(array[a], array[b]) < 0) {
            if (comparator.compare(array[b], array[c]) < 0) return b;
            if (comparator.compare(array[a], array[c]) < 0) return c;
            return a;
        }
        if (comparator.compare(array[a], array[c]) < 0) return a;
        if (comparator.compare(array[b], array[c]) < 0) return c;
        return b;
    }

    @Override
    public String toString() {
        return "Quick Sort with pivot as median of 3 random elements";
    }
}
