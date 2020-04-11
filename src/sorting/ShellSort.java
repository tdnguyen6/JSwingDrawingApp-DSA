package sorting;

import java.util.Comparator;

/**
 * Following Knuth sequence gap = 3gap + 1
 */
public class ShellSort<E> implements ISort<E> {
    public void setSequence(Sequence sequence) {
        this.sequence = sequence;
    }

    private Sequence sequence = Sequence.SHELL;

    /**
     * https://en.wikipedia.org/wiki/Shellsort#Gap_sequences
     */
    public static enum Sequence {
        SHELL,
        KNUTH,
        PRATT,
        HIBBARD,
        PAPERNOV_STASEVICH,
        INCERPI_SEDGEWICK,
        SEDGEWICK82,
        SEDGEWICK86,
        TOKUDA,
        CIURA;
    }

    ;
    int[][] increments = {
            {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096}, // SHELL
            {1, 4, 13, 40, 121, 364, 1093, 3280}, // KNUTH
            {1, 2, 3, 4, 6, 8, 9, 12, 16, 18, 24, 27, 32, 36, 48, 54, 64, 72, 81, 96, 108, 128, 144, 162, 192, 216, 243, 256, 288, 324, 384, 432, 486, 512, 576, 648, 729, 768, 864, 972, 1024, 1152, 1296, 1458, 1536, 1728, 1944, 2048, 2187, 2304, 2592, 2916, 3072, 3456, 3888}, // PRATT
            {1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095}, //HIBBARD
            {1, 3, 5, 9, 17, 33, 65, 129, 257, 513, 1025, 2049, 4097}, // PAPERNOV_STASEVICH
            {1, 3, 7, 21, 48, 112, 336, 861, 1968, 4592}, // SEDGEWICK_INCERPI
            {1, 3, 8, 23, 77, 281, 1073, 4193}, // SEDGEWICK82
            {1, 5, 19, 41, 109, 209, 505, 929, 2161, 3905}, // SEDGEWICK86
            {1, 4, 9, 20, 46, 103, 233, 525, 1182, 2660, 5985}, // TOKUDA
            {1, 4, 10, 23, 57, 132, 301, 701, 1750}, // CIURA

    };

    @Override
    public void sort(E[] array, Comparator<E> comparator) {
        for (int i = increments[sequence.ordinal()].length - 1; i >= 0; i--) {
            if (increments[sequence.ordinal()][i] < array.length) {
                for (int j = 0; j <= i; j++) {
                    sortSegment(array, comparator, SortDirection.ASCENDING, j, increments[sequence.ordinal()][i]);
                }
            }
        }
    }

    @Override
    public void sort(E[] array, Comparator<E> comparator, SortDirection sortDirection) {
        for (int i = increments[sequence.ordinal()].length - 1; i >= 0; i--) {
            if (increments[sequence.ordinal()][i] < array.length) {
                for (int j = 0; j <= i; j++) {
                    sortSegment(array, comparator, sortDirection, j, increments[sequence.ordinal()][i]);
                }
            }
        }
    }

    private void sortSegment(E[] array, Comparator<E> comparator, SortDirection sortDirection, int segment, int increment) {
        E key;
        int j;
        for (int i = segment + increment; i < array.length; i++) {
            key = array[i];
            j = i - increment;
            while (j >= 0 && comparator.compare(array[j], key) == sortDirection.compareResult()) {
                array[j + increment] = array[j];
                j -= increment;
            }
            array[j + increment] = key;
        }
    }

    private void swapArrayPosition(E[] array, int i, int j) {
        E temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public String toString() {
        return "Shell Sort using " + sequence + " sequence";
    }
}
