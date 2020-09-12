package com.sea.springboot.算法;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class 排序 {

    @Test
    void 冒泡排序() {
        int[] arrs = new int[]{7, 2, 4, 2, 8, 1, 9, 8, 21, 27};
        int temp = 0;
        for (int i = 0; i < arrs.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arrs.length - i - 1; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    temp = arrs[j + 1];
                    arrs[j + 1] = arrs[j];
                    arrs[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        System.out.println(arrs);
    }

    @Test
    void 插入排序() {
        int[] arrs = new int[]{7, 2, 4, 2, 8, 1, 9, 8, 21, 27};

        for (int i = 1; i < arrs.length; i++) {
            int index = i;
            for (int j = 0; j < i; j++) {
                if (arrs[j] >= arrs[i]) {
                    index = j;
                    break;
                }
            }
            int temp = arrs[i];
            for (int j = i; j > index; j--) {
                arrs[j] = arrs[j - 1];
            }
            arrs[index] = temp;
        }
        System.out.println(arrs);
    }


}
