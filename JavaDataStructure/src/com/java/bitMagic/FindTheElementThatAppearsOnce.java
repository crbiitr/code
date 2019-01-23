package com.java.bitMagic;

/**
 * @author Chetan Raj
 * @implNote https://www.geeksforgeeks.org/find-the-element-that-appears-once/  (Second solution is easy to understand)
 * NOTE: Third method is also good. But it is not O(1) space. PLEASE TRY IT ALSO.
 * @since : 22/01/19
 */
public class FindTheElementThatAppearsOnce {
    private final static int INTEGER_SIZE = 31;
    public static void main(String[] args) {
        int []array = {1,2,3,4,1,2,3,1,2,3,9,9,9};
        int []array2 = {12, 1, 12, 3, 12, 1, 1, 2, 3, 2, 2, 3, 7};

        int xorSum = 0;
        for (int num : array) {
            xorSum = xorSum ^ num;
        }

        System.out.println("The element with single occurrence is:: " + findSingleNum(array));
        System.out.println("The element with single occurrence is:: " + findSingleNum(array2));
    }

    /**
     * Second method from gfg
     * @param arr
     * @return
     */
    public static int findSingleNum(int []arr) {
        int result = 0;
        int x = 1;
        for (int i = 0; i < INTEGER_SIZE; i++) {

            x = (1<<i);
            int sum = 0;
            for (int j = 0; j < arr.length; j++) {

                if ((arr[j] & x)!=0) {
                    sum++;
                }
            }
            if (sum%3==1) {
                result = result|x;
            }
        }
        return result;
    }
}
