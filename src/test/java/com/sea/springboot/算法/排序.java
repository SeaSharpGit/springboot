package com.sea.springboot.算法;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 排序 {

    @Test
    void test() {
        int[] arrs = new int[]{7, 2, 4, 2, 8, 1, 9, 8, 21, 27};
        插入排序(arrs);
        System.out.println(arrs);
        int a = 1;
    }

    private void 冒泡排序(int[] arrs) {
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

    private void 插入排序(int[] arrs) {
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


}
