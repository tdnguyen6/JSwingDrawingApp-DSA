package sorting;

import java.util.Comparator;

public class MergeSort<E> implements ISort<E> {

    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        doMergeSort(array, 0, array.length - 1, comparator, SortDirection.ASCENDING);
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        doMergeSort(array, 0, array.length - 1, comparator, sortDirection);
    }

    private void doMergeSort(E[] array, int left, int right, Comparator<E> comparator, SortDirection sortDirection) {
        if (left < right) {
            int mid = (left + right) / 2;
            doMergeSort(array, left, mid, comparator, sortDirection);
            doMergeSort(array, mid + 1, right, comparator, sortDirection);
            merge(array, left, mid, right, comparator, sortDirection);
        }
    }

    private void merge(E[] array, int left, int mid, int right, Comparator<E> comparator, SortDirection sortDirection) {
        int leftLength = mid - left + 1;
        int rightLength = right - mid;

        E[] leftArray = array.clone();
        E[] rightArray = array.clone();

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightLength; i++) {
            rightArray[i] = array[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftLength && j < rightLength) {
            if (comparator.compare(leftArray[i], rightArray[j]) == sortDirection.compareResult()) {
                array[k] = rightArray[j];
                j++;
            } else {
                array[k] = leftArray[i];
                i++;
            }
            k++;
        }

        // Clean up the remaining
        while (i < leftLength) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            array[k] = rightArray[j];
            j++;
            k++;
        }

    }

    @Override
    public String toString() {
        return "Merge Sort";
    }
}
