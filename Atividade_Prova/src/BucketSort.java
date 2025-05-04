import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    private int comparisonCount;
    private int movementCount;
    public static long duration;

    public void sort(int[] array) {
        long startTime = System.currentTimeMillis();
        comparisonCount = 0;
        movementCount = 0;

        int numberOfBuckets = array.length;

        if (numberOfBuckets <= 1) {
            return;
        }


        int maxValue = array[0];
        int minValue = array[0];
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
            if (value < minValue) {
                minValue = value;
            }
            comparisonCount += 2;
        }


        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }


        for (int value : array) {
            int bucketIndex = (int) ((double) (value - minValue) / (maxValue - minValue + 1) * (numberOfBuckets - 1));
            buckets[bucketIndex].add(value);
            movementCount++;
        }


        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);

        }


        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index++] = value;
                movementCount++;
            }
        }
        long endTime = System.currentTimeMillis();
        duration = (int) (endTime - startTime);
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
