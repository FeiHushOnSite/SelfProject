package leedcode;


/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * step 1 :  first to check how many zero in array
 * step 2:   delete zero element
 * step 3:   put delete zero to last position, (count how many zero delete)
 */
public class moveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }

        for (int num : nums) {
            System.out.print(num + ",");
        }

    }
}
