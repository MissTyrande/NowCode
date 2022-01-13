import java.util.Arrays;

/**
 * 采用递归方式， 分割法求数组中的最大值
 *
 */
public class RecursionGetMaxNum {
  public static void main(String[] args) {
    //
    getMax();
  }
  public static void getMax() {
    int[] abc = {2,7,6,0,8,1};
    int max = process(abc, 0, abc.length - 1);
    System.out.println(max);
  }

  private static int process(int[] array, int left, int right) {
    if (left == right) {
      return array[left];
    }
    int middle = left + ((right - left) >> 1);
    int leftMax = process(array, left, middle);
    int rightMax = process(array, middle + 1, right);
    return Math.max(leftMax, rightMax);
  }

}
