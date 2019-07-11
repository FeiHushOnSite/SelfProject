package leedcode;

import java.util.Arrays;

public class sortedSquares {
    public static void main(String[] args) {
        int[] A = new int[]{-7, -3, 2, 3, 11};
        int[] result = checkout(A);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] checkout(int[] A) {
     //   int temp = 0;
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i] * A[i];
        }
//        for (int i = 0; i < B.length - 1; i++) {
//            for (int j = i; j < B.length; j++) {
//                if(B[j] <= B[i]){
//                    temp = B[i];
//                    B[i] = B[j];
//                    B[j] = temp;
//                }
//            }
//        }
        Arrays.sort(B);
        return B;
    }
}
