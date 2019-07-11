package leedcode;

import java.util.Arrays;

/**
 * tips:
 * Build the correct order of heights by sorting another array, then compare the two arrays.
 */
public class heightChecker {
    public static void main(String[] args) {
        int[] request = new int[]{1, 1, 4, 2, 1, 3};
        int result = checkout(request);
        System.out.println(result);
    }

    public static int checkout(int[] heights) {
        int[] compare = new int[heights.length + 1];
        for (int height : heights) {
            compare[height]++;
        }

        int count = 0;
        for (int i = 1, j = 0; i < compare.length; i++) {
            while (compare[i]-- > 0) {
                if (heights[j++] != i) {
                    count++;
                }
            }
        }
        return count;
    }
}
