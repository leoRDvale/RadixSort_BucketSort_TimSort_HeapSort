public class RadixSort {

    private int comparisonCount;
    private int movementCount;
    public static long duration;

    public void sort(int[] array) {
        long startTime = System.currentTimeMillis();
        comparisonCount = 0;
        movementCount = 0;

        if (array == null || array.length == 0) {
            duration = 0;
            return;
        }

        int max = getMax(array);
        int maxDigits = Integer.toString(Math.abs(max)).length();

        msdRadixSort(array, 0, array.length - 1, maxDigits - 1);

        long endTime = System.currentTimeMillis();
        duration = endTime - startTime;
    }

    private void msdRadixSort(int[] array, int left, int right, int digit) {
        if (left >= right || digit < 0) return;

        int[] count = new int[20];
        int[] output = new int[right - left + 1];

        int divisor = (int) Math.pow(10, digit);

        for (int i = left; i <= right; i++) {
            int num = (array[i] / divisor) % 10;
            count[num + 10]++;
            comparisonCount++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = right; i >= left; i--) {
            int num = (array[i] / divisor) % 10;
            output[--count[num + 10]] = array[i];
            movementCount++;
        }

        for (int i = 0; i < output.length; i++) {
            array[left + i] = output[i];
            movementCount++;
        }

        int start = left;
        for (int i = 0; i < count.length; i++) {
            int end = left + count[i] - 1;
            if (start < end) {
                msdRadixSort(array, start, end, digit - 1);
            }
            start = end + 1;
        }
    }

    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            comparisonCount++;
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
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