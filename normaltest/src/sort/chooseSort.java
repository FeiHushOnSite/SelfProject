package sort;

/**
 * 选择排序（Selection sort）是一种简单直观的排序算法。
 * 它的工作原理如下。
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <p>
 * 选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，则它不会被移动。
 * 选择排序每次交换一对元素，它们当中至少有一个将410被移到其最终位置上，
 * 因此对n个元素的表进行排序总共进行至多n-1次交换
 * 在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
 */
public class chooseSort {
    public static void main(String[] args) {
        int[] ins = {2, 3, 5, 1, 23, 6, 78, 34};
        int[] ins2 = sort(ins);
        for (int in : ins2) {
            System.out.println(in);
        }
    }

    /**
     * 选择排序的时间复杂度为 O(n^2)。
     *
     * 第一次需要检查n个元素，但随后检查的元素数依次为n - 1, n – 2, …, 2和1。
     * 平均每次检查的元素数为1/2 * n， 因此运行时间为 n * 1/2 * n，简单地写作 O(n^2)。
     * @param arr
     * @return
     */
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i; // 用来记录最小值的索引位置，默认值为i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 遍历 i+1~length 的值，找到其中最小值的位置
                }
            }
            // 交换当前索引 i 和最小值索引 minIndex 两处的值
            if (i != minIndex) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
            // 执行完一次循环，当前索引 i 处的值为最小值，直到循环结束即可完成排序
        }
        return arr;
    }
}
