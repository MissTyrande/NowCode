/**
 * Created by leaf_kai on 2022/1/19.
 */

import java.util.Arrays;

/**
 * 堆排序
 * 完全二叉树 :  从左往右依次占满  从上到下依次占满
 * 一个结点的父结点index  i-1/2
 * 一个结点的左子结点index   2 * i+ 1
 * 一个结点的右子节点的index   2* i+ 2
 * 堆: 也是一个完全二叉树
 * 分为 大根堆  每一个子树 头结点都是这个子树的最大值
 * 小根堆    每一个子树 头结点都是这个子树的最小值
 */
public class DuiPaiXu {
    public static void main(String[] args) {
        // 将一个数组 组成大根堆, 0位置就是最大值
        int[] array1 = {4,2,3,7,4,9};
        heapInsert(array1, array1.length-1);
        System.out.println("array1 = [" + Arrays.toString(array1) + "]");
        // 堆操作, 大根堆中最大值 删除掉,剩余的数变成一个大根堆,输出
        int[] array2 = {4,2,3,7,4,9};
        heapfiy(array2, 2, array2.length);
        System.out.println("array2 = [" + Arrays.toString(array2) + "]");
        sortByDui();
    }

    public static void sortByDui() {
        int[] array2 = {4,2,3,7,8,9};
        // 利用堆排序, 每一次heapinsert后 将最大值与最后一个值交换, 并且heapsize--
        // 先排序
        if (array2 == null || array2.length < 2) {
            return;
        }
        // 先排序 找到最大值 放在0位置,经过每一个位置值的heapinsert 保证了整个树都是一个大根堆结构
        for (int i = 0; i < array2.length; i++) {
            heapInsert(array2, i);
        }
        /**
         *      9
         *    7    8
         *  2  4  3
         */
        // 0位置与最后一个值3 交换  然后进行heapfiy 每一个小的子树找出最大值进行不断交换
        int heapsize = array2.length;
        swap(array2, 0, --heapsize);
        // 从上到下 heapfiy
        while (heapsize > 0) {
            heapfiy(array2, 0, heapsize);
            swap(array2, 0, --heapsize);
        }
        System.out.println("array3 = [" + Arrays.toString(array2) + "]");
    }

    /**
     * heapfiy 每次找出当前结点与左右子节点最大值
     * @param array
     * @param index
     * @param heapsize
     */

    public static void heapfiy(int[] array, int index, int heapsize) {
        int left = index * 2 + 1;
        // 为什么选取左子结点index ,因为左小于heapsize说明一定有子节点
        while (left < heapsize) {
            // 先让左右2个子节点比较 求出最大的index
            int largest = (left + 1 < heapsize) && array[left + 1] > array[left] ? left+ 1 : left;
            // largest再与 父结点比较
            largest = array[index] > array[largest] ? index : largest;
            // 如果largest == index 说明已经到了最后
            if (largest == index) {
                break;
            }
            // 将当前index 与largest交换
            swap(array, largest, index);
            index = largest;
            // 重新赋值left
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int[] array, int index) {
        while (array[index] > array[(index -1) / 2]) {
            // 如果当前结点值比他的父大 则与他的父交换
            swap(array, index, (index -1) / 2);
            index = (index -1) / 2;
        }
    }


    public static void swap(int[] array, int sourceIndex, int targetIndex) {
        int tmp = array[sourceIndex];
        array[sourceIndex] = array[targetIndex];
        array[targetIndex] = tmp;
    }
}
