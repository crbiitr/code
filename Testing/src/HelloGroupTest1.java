import java.util.Arrays;

/**
 * Created by user on 11/22/16.
 */
public class HelloGroupTest1 {

    public static void main(String[] args) {

        int A[] = {1,12,42,70,36,-4,43,15};
        int B[] = {5,15,44,72,36,2,69,24};
        System.out.println(findPlatform(A, B));
        System.out.println(A.length - OverlapInterval(A,B));

    }

    // Returns minimum number of platforms reqquired
    public static int findPlatform(int arr[], int dep[])
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);
        int n = arr.length;

        // plat_needed indicates number of platforms needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival, increment count of
            // platforms needed
            if (arr[i] < dep[j])
            {
                plat_needed++;
                i++;
                if (plat_needed > result)  // Update result if needed
                    result = plat_needed;
            }
            else // Else decrement count of platforms needed
            {
                plat_needed--;
                j++;
            }
        }

        return result;
    }

    public static int OverlapInterval(int[] start, int[] end){
        int maxOverlap = 0;
        int currentOverlap = 0;

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0;
        int j = 0;
        int m=start.length,n=end.length;
        while(i< m && j < n){
            if(start[i] < end[j]){
                currentOverlap++;
                maxOverlap = Math.max(maxOverlap, currentOverlap);
                i++;
            }
            else{
                currentOverlap--;
                j++;
            }
        }

        return maxOverlap;
    }


}
