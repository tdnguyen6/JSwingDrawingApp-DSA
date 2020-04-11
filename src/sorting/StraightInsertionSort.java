package sorting;

import java.util.Comparator;

public class StraightInsertionSort<E> implements ISort<E> {

    /**
     * @param array
     * @param comparator <p>Function name: sort
     *                   <p>Usage: sort an array based on insertion sort algorithm with the compation method passed
     *                   to by comparator
     *                   <p>Space complexity: O(1) Only 2 vars: key and j ----> O(1)
     *                   <p>Time complexity: O(n^2) based on worst case
     *                   <p>Best case: array is already sorted, then each outer loop will only do 1 comparison in
     *                   the while precondition and then skip the loop because array[i - 1] is always less array[i]
     *                   --> n - 1 comparisons ----> In best case: O(n)
     *                   <p>Worst case: array is sorted in reversed order to what we want. For every outer loop, the
     *                   inner loop will run from j = i - 1 to j = 0, with each inner loop doing 1 comparison and 1
     *                   swap -> 2 operations i = 1 then j = 0 ----> 1 times i = 2 then j = 1, 0 ----> 2 times ... i
     *                   = n - 1 then j = n - 2 to 0 ----> n - 1 times So the total number of loops is: 2 * (1 + 2 +
     *                   ... + n - 1) = (n - 1) * n = n^2 - n ----> In worst case: O(n^2)
     */
    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        E key;
        int j;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && comparator.compare(array[j], key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        E key;
        int j;
        for (int i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;
            while (j >= 0 && comparator.compare(array[j], key) == sortDirection.compareResult()) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String toString() {
        return "Straight Insertion Sort";
    }
}
