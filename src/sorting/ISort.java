package sorting;

import java.util.Comparator;

public interface ISort<E> {
    public void sort(E[] array, Comparator<E> comparator);

    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection);

    public static enum SortDirection {
        ASCENDING(1),
        DESCENDING(-1);
        private int value;

        SortDirection(int comparisonResult) {
            value = comparisonResult;
        }

        public int compareResult() {
            return this.value;
        }
    }
}
