package com.sea.springboot.算法;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;

@SpringBootTest
public class 排序 {

    @Test
    void test() {
        int[] arr = new int[]{7, 2, 4, 2, 8, 1, 9, 8, 27, 21};
        order5(arr);
        System.out.println(arr);
    }

    /**
     * 冒泡排序
     * 优化：当顺序没有发生改变时，后面的就不需要执行了
     *
     * @param arr
     */
    private void order(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
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
     * @param arr
     */
    private void order2(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    /**
     * 选择排序
     * 优化：如果当前位置就是最小值，就不需要交换
     * 最后一个元素不需要判断，自然就是最大值，所以循环次数-1
     *
     * @param arr
     */
    private void order3(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    /**
     * 归并排序
     * 不是原地排序，每次排序都要申请额外的空间
     *
     * @param arr
     */
    private void order4(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        MergeSort(arr, 0, arr.length - 1);
    }

    private void MergeSort(int[] arr, int m, int n) {
        if (m >= n) {
            return;
        }
        int x = (m + n) / 2;
        MergeSort(arr, m, x);
        MergeSort(arr, x + 1, n);
        Merge(arr, m, x, n);
    }

    private void Merge(int[] arr, int m, int x, int n) {
        int i = m;
        int j = x + 1;
        int k = 0;
        int[] temp = new int[n - m + 1];
        while (i <= x && k <= n) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        // 把左边剩余的数移入数组
        while (i <= x) {
            temp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= n) {
            temp[k++] = arr[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (i = 0; i <= n - m; i++) {
            arr[m + i] = temp[i];
        }
    }

    /**
     * 快读排序
     *
     * @param arr
     */
    private void order5(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int m, int n) {
        if (m >= n) {
            return;
        }
        //获取分区点
        int x = Partition(arr, m, n);
        quickSort(arr, m, x - 1);
        quickSort(arr, x + 1, n);
    }

    private int Partition(int[] arr, int m, int n) {
        int point = arr[n];
        int i = m;
        int temp;
        for (int j = m; j < n; j++) {
            if (arr[j] >= point) {
                continue;
            }
            if (i == j) {
                i++;
            } else {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        temp = arr[i];
        arr[i] = arr[n];
        arr[n] = temp;
        return i;
    }


}
