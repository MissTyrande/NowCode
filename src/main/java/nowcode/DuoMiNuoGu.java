package nowcode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by leaf_kai on 2022/2/21.
 */
public class DuoMiNuoGu {
    private static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        System.out.println(pushDomimo("RR.L"));
        System.out.println(pushDomimo(".L.R...LR..L.."));
    }

    private static String pushDomimo(String dominos) {
        int len = dominos.length();
        char[] chars = dominos.toCharArray();
        for (int i = 0; i < len; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, Integer> indexToValue = new HashMap<>();
            while (size-- > 0) {
                int index = queue.poll();
                if (chars[index] == '.') {
                    continue;
                }
                if (chars[index] == 'L' && index - 1 >=0 && chars[index - 1] == '.') {
                    indexToValue.putIfAbsent(index - 1, 0);
                    indexToValue.put(index - 1, indexToValue.get(index - 1) - 1);
                }
                if (chars[index] == 'R' && index + 1 < len && chars[index + 1] == '.') {
                    indexToValue.put(index + 1, 0);
                    indexToValue.put(index + 1, indexToValue.get(index + 1) + 1);
                }
            }
            for (int i : indexToValue.keySet()) {
                int value = indexToValue.get(i);
                if (value != 0 ) {
                    chars[i] = value > 0 ? 'R' : 'L';
                    queue.offer(i);
                }
            }
        }
        return new String(chars);
    }
}
