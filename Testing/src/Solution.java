import java.util.*;

/**
 * Created by chetan on 7/3/17.
 * https://www.geeksforgeeks.org/number-possible-triangles-cartesian-coordinate-system/
 *https://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
 */
public class Solution {
   /* public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        String a = in.nextLine();
        System.out.println(steadyGene(a));
    }*/
   public static void main(String[] args) {
//       int[] arr = {1,1,0,1,0,1,1,1};
//       int[] arr = {1,1,0,1,0,1,0,1,0,0,1};
       int [] arr={1,1,0,1,0,1,1,1};
        String str = "11010101001";
       System.out.println(getLongestBalancedChromosome(str));
       System.out.println(findMaxLength(arr));

   }
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }
    public static int  getLongestBalancedChromosome(String c)
    {
        if(c == null || c.length()==1) return 0;
        int sum = 0;
        int maxsize = -1, startindex = 0;
        int endindex = 0;

        int n = c.length();
        char[] arr = c.toCharArray();

        // Pick a starting point as i

        int []temp = new int[n];
        for (int i = 1; i < n; i++)
        {
            temp[i] = Math.abs(temp[i]-temp[i-1]);
        }
        return count(temp);
    }
    
    public static int count(int[] arr) {
       int count = 0;
        int maxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==1 && arr[i+1]==1) {
                count++;

            } else {
                count=0;
            }
            if(maxCount<count) maxCount=count;

        }
        return maxCount;
    }

    /*static int getLongestBalancedChromosome(String c) {
        int length = c.length();
        if(c==null ||length==0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (c.charAt(i) == '0') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.empty())
                    result = Math.max(result, i - stack.peek());
                else stack.push(i);
            }
        }
        return result;
    }
*/

    static int qw(String c) {

        if(c == null || c.length()==1) return 0;
        int n = c.length();
        char[] array = c.toCharArray();
        int tempArray[][] = new int[n][2];
        for (int i = 0; i < n; i++)
            tempArray[i][0] = tempArray[i][1] = 1;

        int result = 1;

        for (int i = 1; i < n; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (array[j] < array[i] &&
                        tempArray[i][0] < tempArray[j][1] + 1)
                    tempArray[i][0] = tempArray[j][1] + 1;

                if( array[j] > array[i] &&
                        tempArray[i][1] < tempArray[j][0] + 1)
                    tempArray[i][1] = tempArray[j][0] + 1;
            }

            if (result < Math.max(tempArray[i][0], tempArray[i][1]))
                result = Math.max(tempArray[i][0], tempArray[i][1]);
        }
        return result-1;
    }
/*
    public static int  getLongestBalancedChromosome(String c)
    {
        if(c == null || c.length()==1) return 0;
        int sum = 0;
        int maxsize = -1, startindex = 0;
        int endindex = 0;

        int n = c.length();
        char[] arr = c.toCharArray();

        // Pick a starting point as i

        for (int i = 0; i < n - 1; i++)
        {
            sum = (arr[i] == 0) ? -1 : 1;

            // Consider all subarrays starting from i

            for (int j = i + 1; j < n; j++)
            {
                if(arr[j] == 0)
                    sum += -1;
                else
                    sum += 1;

                // If this is a 0 sum subarray, then
                // compare it with maximum size subarray
                // calculated so far

                if (sum == 0 && maxsize < j - i + 1)
                {
                    maxsize = j - i + 1;
                    startindex = i;
                }
            }
        }
        endindex = startindex+maxsize-1;
        if (maxsize == -1)
            System.out.println("No such subarray");
        else
            System.out.println(startindex+" to "+endindex);

        return maxsize;
    }*/

    /*private static String transform(String input, int rot, int position, int len) {
        char[] ar = input.toCharArray();
        if (rot % 2 != 0) {
            for (int i = 0; i < rot; i++) {
                rotate(ar, position - 1, len - position);
            }
        }
        return String.valueOf(ar);
    }*/
    public static int maxLen(int arr[], int n)
    {
        // Creates an empty hashMap hM

        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++)
        {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array

        for (int i = 0; i < n; i++)
        {
            // Add current element to sum

            sum += arr[i];

            // To handle sum=0 at last index

            if (sum == 0)
            {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before, then update max_len
            // if required

            if (hM.containsKey(sum))
            {
                if (max_len < i - hM.get(sum + n))
                {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum + n, i);
        }

        for (int i = 0; i < n; i++)
        {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

/*
    public class Solution {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            int rot = scanner.nextInt();
            int position = scanner.nextInt();
            int len = input.length();
            System.out.print(transform(input, rot, position, len));
        }

        private static String transform(String input, int rot, int position, int len) {
            char[] ar = input.toCharArray();
            for (int i = 0; i < rot; i++) {
                rotate(ar, position - 1, len - position + 1);
            }
            return String.valueOf(ar);
        }

        private static void rotate(char arr[], int pos, int n) {
            int l = pos;
            int r = n - 1;
            while (l < r) {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
    }*/


}