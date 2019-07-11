package sort;

/**
 * 二分算法步骤描述
 * <p>
 * ① 首先确定整个查找区间的中间位置 mid = （ left + right ）/ 2
 * <p>
 * ② 用待查关键字值与中间位置的关键字值进行比较；
 * <p>
 * 若相等，则查找成功
 * <p>
 * 若大于，则在后（右）半个区域继续进行折半查找
 * <p>
 * 若小于，则在前（左）半个区域继续进行折半查找
 * <p>
 * ③ 对确定的缩小区域再按折半公式，重复上述步骤。
 * <p>
 * 优点：ASL≤log2n，即每经过一次比较,查找范围就缩小一半。经log2n 次计较就可以完成查找过程。
 * <p>
 * 缺点：因要求有序，所以要求查找数列必须有序，而对所有数据元素按大小排序是非常费时的操作。另外，顺序存储结构的插入、删除操作不便利。
 */
public class middleFind {

    public static void main(String[] args) {
        int srcArray[] = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));
    }

    // 二分查找递归实现
    public static int binSearch(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    // 二分查找普通循环实现
    public static int binSearch(int srcArray[], int key) {
        int mid = srcArray.length / 2;
        if (key == srcArray[mid]) {
            return mid;
        }

        int start = 0;
        int end = srcArray.length - 1;
        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (key < srcArray[mid]) {
                end = mid - 1;
            } else if (key > srcArray[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
