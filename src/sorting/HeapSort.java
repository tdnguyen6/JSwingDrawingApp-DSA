package sorting;

import java.util.Comparator;

public class HeapSort<E> implements ISort<E> {

    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i, comparator, SortDirection.ASCENDING);
        for (int i = array.length - 1; i > 0; i--) {
            swapArrayPosition(array, 0, i);
            heapify(array, i, 0, comparator, SortDirection.ASCENDING);
        }
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        for (int i = array.length / 2 - 1; i >= 0; i--)
            heapify(array, array.length, i, comparator, sortDirection);
        for (int i = array.length - 1; i > 0; i--) {
            swapArrayPosition(array, 0, i);
            heapify(array, i, 0, comparator, sortDirection);
        }
    }

    private void heapify(E[] array, int heapSize, int rootNode, Comparator<E> comparator, SortDirection sortDirection) {
        int extremeNode = rootNode;
        int leftNode = 2 * rootNode + 1;
        int rightNode = 2 * rootNode + 2;

        if (leftNode < heapSize && comparator.compare(array[leftNode], array[extremeNode]) == sortDirection.compareResult())
            extremeNode = leftNode;
        if (rightNode < heapSize && comparator.compare(array[rightNode], array[extremeNode]) == sortDirection.compareResult())
            extremeNode = rightNode;

        if (extremeNode != rootNode) {
            swapArrayPosition(array, extremeNode, rootNode);
            heapify(array, heapSize, extremeNode, comparator, sortDirection);
        }
    }

    private void swapArrayPosition(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Heap Sort";
    }
}
