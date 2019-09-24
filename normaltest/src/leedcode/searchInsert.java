package leedcode;


import java.util.Arrays;

public class searchInsert {
    public static void main(String[] args) {
        int[] ints = new int[]{3,5,1,6};
        int i = searchInsert(ints, 5);
        System.out.println(i);
    }
    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num == target){
                result = i;
            }
        }
        return result;
    }
}
