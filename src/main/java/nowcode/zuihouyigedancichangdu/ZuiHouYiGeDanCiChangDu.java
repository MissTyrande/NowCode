package nowcode.zuihouyigedancichangdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 描述 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * （注：字符串末尾不以空格为结尾） 输入描述： 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * <p>输出描述： 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class ZuiHouYiGeDanCiChangDu {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      if (str == null || str.length() <1) {
        System.out.println(0);
      } else {
        String[] array = str.split(" ");
        System.out.println(array[array.length - 1].length());
      }
    }
  }
}
