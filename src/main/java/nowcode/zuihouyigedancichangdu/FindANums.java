package nowcode.zuihouyigedancichangdu;

import java.util.Locale;
import java.util.Scanner;

/**
 * 描述 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * <p>数据范围： 输入描述： 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * <p>输出描述： 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 * 输入： ABCabc
 * A
 * 复制 输出： 2
 */
public class FindANums {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String inputStr = "";
    String target = "";
    int total = 0;
    while (scanner.hasNextLine()) {
      if (inputStr.length() < 1) {
        inputStr = scanner.nextLine();
      } else {
        total = 0;
        target = scanner.nextLine();
        inputStr = inputStr.toLowerCase();
        for (char a : inputStr.toCharArray()) {
          if (target.toLowerCase().equals(String.valueOf(a))) {
            total += 1;
          }
        }
        System.out.println(total);
        inputStr = "";
        target = "";
      }
    }
  }
}
