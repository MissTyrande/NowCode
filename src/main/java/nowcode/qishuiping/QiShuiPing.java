package nowcode.qishuiping;

/**
 * Created by leaf_kai on 2022/1/13.
 */

import java.util.Scanner;

/**
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是 5 瓶，方法如下：先用 9 个空瓶子换3瓶汽水，喝掉 3 瓶满的，喝完以后 4 个空瓶子，用 3 个再换一瓶，喝掉这瓶满的，这时候剩 2 个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用 3 个空瓶子换一瓶满的还给老板。如果小张手上有 n 个空汽水瓶，最多可以换多少瓶汽水喝？

 数据范围：输入的正整数满足

 注意：本题存在多组输入。
 允许如题面所述向老板借汽水。
 输入的 0 仅表示输入结束，并不用输出结果
 */
public class QiShuiPing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            int first = process(input);
            System.out.println(first);
        }
    }

    private static int process (int input) {
        if(input < 3 & input > 1) {
            return 1;
        }
        if (input < 2) {
            return 0;
        }
        int first = input / 3;
        int rever = input % 3;
        int result = first + rever;
        return first + process(result);
    }

}
