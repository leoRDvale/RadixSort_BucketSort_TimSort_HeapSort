public class HeapSort {

    private int comparisonCount;
    private int movementCount;
    public static long duration;

    public void sort(int[] array) {
        long startTime = System.currentTimeMillis();
        comparisonCount = 0;
        movementCount = 0;

        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            movementCount += 3;

            heapify(array, i, 0);
        }

        long endTime = System.currentTimeMillis();
        duration = endTime - startTime;
    }


    private void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            comparisonCount++;
            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            comparisonCount++;
            if (array[right] > array[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            movementCount += 3;

            heapify(array, n, largest);
        }
    }

    public int getComparisonCount() {
        return comparisonCount;
    }

    public int getMovementCount() {
        return movementCount;
    }

    public static String formatDuration(long duration) {
        long milliseconds = duration % 1000;
        long seconds = (duration / 1000) % 60;
        long minutes = (duration / (1000 * 60)) % 60;
        long hours = (duration / (1000 * 60 * 60)) % 24;
        return String.format("%02d:%02d:%02d:%04d", hours, minutes, seconds, milliseconds);
    }
}