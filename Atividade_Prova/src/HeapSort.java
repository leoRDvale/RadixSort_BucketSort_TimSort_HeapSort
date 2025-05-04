public class HeapSort {

    private int comparisonCount;
    private int movementCount;
    public static long duration;

    public void sort(int[] array) {
        long startTime = System.currentTimeMillis();
        comparisonCount = 0;
        movementCount = 0;





        //Implementar Codigo do HeapSort










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