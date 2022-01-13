package nowcode.mingmingdesuijishu;

/**
 * Created by leaf_kai on 2022/1/14.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了 N 个 1 到 1000 之间的随机整数（ N≤1000 ），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据(用于不同的调查)，希望大家能正确处理)。


 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。

 当没有新的输入时，说明输入结束。

 数据范围：  ，输入的数字大小满足  第一行输入总个数  从第二行开始就是每个随机数 直到达到总个数 程序开始运行
 要注意连续输入两次的情况 需要把list清空

 */
public class MingMingDeSuiJiShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> datas = new ArrayList<>();
        int total = 0;
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            datas.add(input);
            total = datas.get(0);
            if (total == 0) {
                return;
            }
            if (datas.size() == (total + 1)) {
                TreeSet<Integer> set = new TreeSet<>(datas.subList(1, datas.size()));
                for (int i : set) {
                    System.out.println(i);
                }
                total =0;
                datas.clear();
            }
        }

    }

}
