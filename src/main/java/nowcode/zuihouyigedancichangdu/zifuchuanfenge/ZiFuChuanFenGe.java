package nowcode.zuihouyigedancichangdu.zifuchuanfenge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 描述 •连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。 （注：本题有多组输入） 输入描述：
 * 连续输入字符串(输入多次,每个字符串长度小于等于100)
 *
 * <p>输出描述： 依次输出所有分割后的长度为8的新字符串
 *
 * <p>示例1 输入： abc 123456789 复制 输出： abc00000 12345678 90000000
 */
public class ZiFuChuanFenGe {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      int len = str.length();
      int num = str.length() % 8;
      int page = num > 0 ? len / 8 + 1 : len / 8;
      for (int i = 0; i < page; i++) {
        int end = (i+1) * 8 >= len ? len :(i+1) * 8;
        String temp = str.substring(i * 8, end);
        System.out.println((temp + "00000000").substring(0, 8));
      }


    }
  }
}
