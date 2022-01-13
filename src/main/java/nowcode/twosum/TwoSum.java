package nowcode.twosum;

/**
 * Created by leaf_kai on 2022/1/14.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 给出1个数组 输入target 找出数组中2个数之和等于target的数字
 * 变种题目 数组中有多组符合这个target的数字 请全部列出来
 *
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] array = {1,3,6,8,7,11,0,8,2};
        int target = 8;
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (int i : array) {
            if (target - i < 0) {
                continue;
            }
            int tmp = target - i;
            if (!resultMap.containsKey(tmp)) {
                resultMap.put(tmp, i);
            }
        }
        Map<Integer, Integer> resultMap1 = new HashMap<>();
        for (int j : array) {
            if (resultMap.containsKey(j) && resultMap.containsKey(resultMap.get(j))) {
                if (!resultMap1.keySet().contains(resultMap.get(j))) {
                  resultMap1.put(j, resultMap.get(j));
                }
            }
        }
        System.out.println(resultMap1.entrySet().toString());
    }
}
