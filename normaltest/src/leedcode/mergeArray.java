package leedcode;


import java.util.Arrays;

public class mergeArray {

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
        merge(num1,3,num2,3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
// two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        /**
         *             if(nums1[p1] < nums2[p2])
         *                 nums1[p--] = nums2[p2--];
         *             else
         *                 nums1[p--] = nums1[p1--];
         */

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
