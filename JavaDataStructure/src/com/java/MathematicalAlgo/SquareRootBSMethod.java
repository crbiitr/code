package com.java.MathematicalAlgo;

/**
 * Created by chetan on 5/3/17.
 */
public class SquareRootBSMethod {
    static double e = 0.001; //  e decides the accuracy level
        public static double floorSqrt(int x)
        {
            // Base Cases
            if (x == 0 || x == 1)
                return x;

            // Do Binary Search for floor(sqrt(x))
            double start = 1, end = x, ans=0;
            while (start <= end)
            {
                double mid = (start + end) / 2;

                // If x is a perfect square
                System.out.println("Start:: " +start + ", End:: "+ end + ", mid::" + mid + ", mid^2 :: " + mid*mid + ", Diff(mid^2-x) :: " + (mid*mid - x));
                if (Math.abs(mid*mid - x) <= e)
                    return mid;

                // Since we need floor, we update answer when mid*mid is
                // smaller than x, and move closer to sqrt(x)
                if (mid*mid < x)
                {
                    start = mid;
                    ans = mid;
                }
                else   // If mid*mid is greater than x
                    end = mid;
            }
            return ans;
        }

        // Driver Method
        public static void main(String args[])
        {
            int x = 10;
            System.out.println(floorSqrt(x));
        }
}
