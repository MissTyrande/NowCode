/** 1、有一个数组中，有一种数出现了奇数次 其他所有数都是偶数次， 请找出奇数次的这个数 2、有一个数组中，有两种数出现了奇数次 其他所有数都是偶数次， 请找出奇数次的这个数 */
public class FindNumShowTimes {

  /**
   * 思路 ：采用亦或 处理 每个数跟自身亦或是0 0与任意数亦或都是数本身
   *  复习一下知识 ：  位运算   &  相同为1 则为1    | 有一个1 则为1   ^ 亦或 不同则为1 相同则为0
   * @param args
   */
  public static void main(String[] args) {
    findNum();
    findTwoNum();
  }

  /** 数组中只有一种数是奇数个时 这么处理，复杂度 O（n） */
  public static void findNum() {
    int[] abc = {1, 2, 3, 2, 3, 1, 3};
    int target = 0;
    for (int item : abc) {
      target ^= item;
    }
    //    每个数跟自身亦或是0  0与任意数亦或都是数本身
    System.out.println(target);
  }

  public static void findTwoNum() {
    int[] abc = {2, 3, 2, 3, 1, 3, 5, 5, 6, 5, 6, 1};
    int target = 0;
    for (int item : abc) {
      target ^= item;
    }
    System.out.println("target 是a和b的亦或的值" + target);
    // 找到target 最右侧的1
    // 6  对应的二进制   1110
    System.out.println("那么target 最右侧的1" + Integer.toBinaryString(target));
    // 获取某一个整数最右侧1的值 就用数本身与 数取反 +1     0001 + 1  =  10
    System.out.println("获取到target最终的右侧为1的数是：" + (target & ((~target) + 1)));
    int ero1 = target & ((~target) + 1);
    // 那么数组中目标a 或者b 一定与ero1 进行与操作  要么为0 或者1
    int targetNew = 0;
    for (int item : abc) {
//      System.out.println("item is " + Integer.toBinaryString(item));
//      System.out.println("item & ero1 " + (item & ero1));
      // 例如 5 对应的二进制 101  和  最右侧为1的数  ero1 2 对应的二进制是10   101 & 10 值为0， 所以找到了5
      if ((item & ero1) == 0) {
        targetNew ^= item;
      }
    }
    // 之前5 ^ b = target   那么反过来  5 ^ target = b  所以得到3
    System.out.println(targetNew + "other is " + (targetNew ^ target));
  }
}
