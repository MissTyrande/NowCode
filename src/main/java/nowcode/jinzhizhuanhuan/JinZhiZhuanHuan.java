package nowcode.jinzhizhuanhuan;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by leaf_kai on 2022/1/14.
 */

/**
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。

 数据范围：保证结果在

 直接调用Java的decode方法.
 该方法的作用是将 String 解码为 Integer。接受十进制、十六进制和八进制数字。

 根据要解码的 String（mn)的形式转成不同进制的数字。 mn由三部分组成：符号、基数说明符和字符序列。
 -0X123中-是符号位，0X是基数说明符（0表示八进制，0x,0X，#表示十六进制，什么都不写则表示十进制）
 ，123是数字字符序列。
 */
public class JinZhiZhuanHuan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String inputStr = scanner.next();
            System.out.println(Integer.decode(inputStr));
        }
    }
}
