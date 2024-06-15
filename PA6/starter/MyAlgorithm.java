/**
 * This class contains an algorithm utilizing a stack or queue. 
 */
public class MyAlgorithm {
    /**
     * Finds the average difference between consecutive elements in the
     * monotonically increasing subsequence starting from the first element in
     * the array
     * 
     * @param arr the array containing the monotonic subsequence
     * @throws NullPointerException if the specified array is null
     * @return the average difference between elements in the subsequence
     */
    public static double avgDiffMonotonicIncreasing(int[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        }

        if (arr.length == 0) {
            return 0.0;
        }

        int first = arr[0];
    
        int sum = 0;
        int increased = 0;
        int curr;
        int prev = first;

        for (int i = 1; i < arr.length; i++) {
            curr = arr[i];
            if (curr > prev) {
                sum += curr - prev;
                prev = curr;
                increased++;
            }
        }

        if (increased == 0) {
            return 0;
        } else {
            return (double) sum/increased;
        }

    }
}
