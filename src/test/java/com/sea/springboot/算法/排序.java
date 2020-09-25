package com.sea.springboot.算法;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 排序 {

    @Test
    void test() {
        int[] arrs = new int[]{7, 2, 4, 2, 8, 1, 9, 8, 27, 21};
        order4(arrs);
        System.out.println(arrs);
        int a = 1;
    }

    /**
     * 冒泡排序
     * 优化：当顺序没有发生改变时，后面的就不需要执行了
     *
     * @param arrs
     */
    private void order(int[] arrs) {
        if (arrs.length <= 1) {
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    int temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param arrs
     */
    private void order2(int[] arrs) {
        if (arrs.length <= 1) {
            return;
        }
        for (int i = 1; i < arrs.length; i++) {
            int temp = arrs[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arrs[j] > temp) {
                    arrs[j + 1] = arrs[j];
                } else {
                    break;
                }
            }
            arrs[j + 1] = temp;
        }
    }

    /**
     * 选择排序
     * 优化：如果当前位置就是最小值，就不需要交换
     * 最后一个元素不需要判断，自然就是最大值，所以循环次数-1
     *
     * @param arrs
     */
    private void order3(int[] arrs) {
        if (arrs.length <= 1) {
            return;
        }
        for (int i = 0; i < arrs.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < arrs[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arrs[i];
                arrs[i] = arrs[min];
                arrs[min] = temp;
            }
        }
    }

    /**
     * 归并排序
     * 不是原地排序，每次排序都要申请额外的空间
     *
     * @param arrs
     */
    private void order4(int[] arrs) {
        if (arrs.length <= 1) {
            return;
        }
        MergeSort(arrs, 0, arrs.length - 1);
    }

    private void MergeSort(int[] arrs, int m, int n) {
        if (m >= n) {
            return;
        }
        int x = (m + n) / 2;
        MergeSort(arrs, m, x);
        MergeSort(arrs, x + 1, n);
        Merge(arrs, m, x, n);
    }

    private void Merge(int[] arrs, int m, int x, int n) {
        int i = m;
        int j = x + 1;
        int k = 0;
        int[] temp = new int[n - m + 1];
        while (i <= x && k <= n) {
            if (arrs[i] <= arrs[j]) {
                temp[k] = arrs[i];
                i++;
            } else {
                temp[k] = arrs[j];
                j++;
            }
            k++;
        }
        // 把左边剩余的数移入数组
        while (i <= x) {
            temp[k++] = arrs[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= n) {
            temp[k++] = arrs[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (i = 0; i <= n - m; i++) {
            arrs[m + i] = temp[i];
        }
    }

    private void 快速排序(int[] arrs) {
        if (arrs.length <= 1) {
            return;
        }
        for (int i = 0; i < arrs.length; i++) {
            int min = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < arrs[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arrs[i];
                arrs[i] = arrs[min];
                arrs[min] = temp;
            }
        }
    }


}
