import java.util.Arrays;

/**
 * 快速排序3.0版本 每次取数组中最后一个数最为起始数字
 * 左侧数比其实数小则交换 依次递归
 * 加入随机选取一个数作为 起始数
 */

public class KuaiSuPaiXuOne {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 7, 4, 3,2,8,5};
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            // 先随机取出1个起始值 与最右侧的值做交换
            int random = (int) (Math.random() * (right - left + 1));
            swap(array, left + random, right);
            System.out.println("array = [" + Arrays.toString(array) + "], left = [" + left + "], right = [" + right + "]");
            // 调用patition 获取到一个只有2个数的数组 代表小于区的右边界和大于区的左边界的下标
            int[] p = patition(array, left, right);
            quickSort(array, left, p[0] - 1);
            quickSort(array, p[1] + 1, right);
        }

    }

    public static int[] patition(int[] array, int left, int right) {
        // 起始数据
        // 小于区的左边界
        int less = left - 1;
        // 大于区的右边界
        int more = right;
        // 最小不能小于less  最大不能大于more
        while (left < more) {
            if (array[left] < array[right]) {
                // 如果当前数比目标数小 则指针所指数与前一个数交换
                swap(array, left++, ++less);
            } else if (array[left] > array[right]) {
                // 如果当前数比目标数大, 则指针所指的数与目标数前1个数做交换
                swap(array, left, --more);
            } else {
                // 如果相等则left指针+1  不交换
                left++;
            }
        }
        swap(array, right, more);
        System.out.println("array = [" + Arrays.toString(array) + "], left = [" + left + "], right = [" + right + "]");
        System.out.println(less + "==" + more);
        return new int[]{less + 1, more};
    }

    /*
    两个位置的值做交换
     */
    public static void swap(int[] array, int source, int target) {
        int tmp = array[source];
        array[source] = array[target];
        array[target] = tmp;
    }
}
