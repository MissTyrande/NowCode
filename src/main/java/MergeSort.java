import java.util.Arrays;

/**
 * 归并排序 ：
 * 给定一个数组 [1,4,2,7,3,0]
 * 先取中点 M  0+  array.size - 0  >> 1  =
 *  先让左侧部分排好序  再让右侧部分排好序   然后merge
 *  先从左边取 哪个小取哪个
 *  help 数组作为一个临时开辟空间存储已经排序好的数组内容
 */
public class MergeSort {
  public static void main(String[] args) {
    int[] array = {1,4,2,7,3,0};
    int left = 0;
    int right = array.length - 1;
    process(array, left, right);
  }
  public static void process (int[] array, int left,  int right) {
    if (left == right) {
      return;
    }
    int mid = left + ((right - left) >> 1);
    process(array, left, mid);
    process(array, mid + 1, right);
    // 下面merge
    merge(array, left, mid, right);
    System.out.println(
        "array = " + Arrays.toString(array) + ", left = " + left + ", right = " + right);
  }
  private static void merge (int[] array, int left, int mid, int right) {
      int p1 = left;
      int p2 = mid +1;
      int i = 0;
      int[] help = new int[right - left + 1];
      while (p1 <= mid && p2 <= right) {
        help[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
      }
      // 越界处理 保证了至少左边或者右边越界 不可能同时越界
      while (p1 <= mid) {
        help[i++] = array[p1++];
      }
      while (p2 <= right) {
        help[i++] = array[p2++];
      }
    // 这里help 已经是排好序的数组了
    System.out.println("排完序的help " + Arrays.toString(help));
      for (int j =0; j < help.length; j++) {
        array[left + j] = help[j];
      }
    System.out.println("当前的array" + Arrays.toString(array));
  }


}
