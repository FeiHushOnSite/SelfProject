package leedcode;

public class removeDuplicate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        int[] result = removeDuplicate(nums);
        for (int i = 0; i < result.length; i++) {
            int i1 = result[i];
            System.out.println(i1);
        }
    }

    private static int[] removeDuplicate(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }
        }
        return nums;
    }
}
