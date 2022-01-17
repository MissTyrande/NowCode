import java.util.Arrays;

/**
 * 归并排序
 *  给定一个数组 [1,3,4,2,5]
 *  1 右侧有4个数比1大  那么就是  4个1
 *  3右侧 有2个数比3大   那么就是 2个3
 *  4右侧 有1个数比4大    那么就是 1个4
 *  2右侧 有1个数比2大    那么就是2
 *  5右侧没有比5大的    那么就是0
 *  4+ 3+ 3 + 4 + 2 = 16
 *  思路：
 *  采用归并排序的方法进行左右侧比较 计算出小和
 *  每次只有左侧指针对应的值 小于右侧指针的值 才相加 n个左侧指针的值
 */
public class GuiBingPaiXuQiuXiaoHe {
  public static void main(String[] args) {
    int[] array = {1,3,4,2,5};
    int left = 0;
    int right = 4;
    int total = process(array, left, right);
    System.out.println("最终小和 = " + total);
  }
  public static int process(int[] array, int left, int right) {
    if (left == right) {
      return 0;
    }
    int mid = left + ((right - left) >> 1);
    return  process(array, left, mid) +
    process(array, mid + 1, right) +
    merge(array, left, mid, right);
  }

  public static int merge(int[] array, int left, int mid, int right)  {
    int[] help = new int[right - left + 1];
    int p1 = left;
    int p2 = mid + 1;
    int i = 0;
    int total = 0;
    while (p1 <= mid && p2 <= right) {
      // 精髓: 每次进来的array 都是已经排序好的，左侧数字右侧有几个比他大的数字， 就是array 有边界- p2 + 1
      total += array[p1] < array[p2] ? array[p1] * (right - p2 + 1) : 0;
      help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
    }
    while (p1 <= mid) {
      help[i++] = array[p1++];
    }
    while (p2 <= right) {
      help[i++] = array[p2++];
    }
    System.out.println(
        "array = "
            + Arrays.toString(help)
            + ", left = "
            + left
            + ", mid = "
            + mid
            + ", right = "
            + right);
    // 拷贝回原数组
    for (int j = 0; j< help.length; j++) {
      array[left + j] = help[j];
    }
    System.out.println(
        "array = "
            + Arrays.toString(array)
            + ", left = "
            + left
            + ", mid = "
            + mid
            + ", total = "
            + total);
    return total;
  }

}
