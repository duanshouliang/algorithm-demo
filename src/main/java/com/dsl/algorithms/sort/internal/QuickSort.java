package com.dsl.algorithms.sort.internal;

import java.util.ArrayList;
import java.util.List;


/**
 * 核心思想：分治策略最，递归求解。以待排序的数组的某个元素 a 作为基准元素, 将小于等于 a 的元素移到 a 的左侧，反之移到 a 的右侧，最终得到了左右两个分区，然后递归对左右分区做同样的操作
 *
 * 不需要额外的内从空间，内排序算法中最好的一个
 *
 * 最坏的情况与简单排序的时间一样
 *
 *
 *
 */
public class QuickSort {
    private List<Integer> list;

    public QuickSort(List<Integer> list) {
        this.list = list;
    }

    public List<Integer> sort(int left, int right) {
        if (null == list || list.size() < 2) return list;
        int point = list.get(left);
        int i = left;
        int j = right;
        while (i < j) {
            //将比point大的换到右分区
            while (i < j && list.get(j) >= point) {
                j--;
            }
            if (i < j) {
                swap(i, j);
            }
            //将比point小的换到做分区
            while (i < j && list.get(i) <= point) {
                i++;
            }
            if (i < j) {
                swap(i, j);
            }
        }
        if (i != left) {
            sort(left, i - 1);
        }
        if (j != right) {
            sort(j + 1, right);
        }
        return list;
    }

    private void swap(int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static void main(String[] args) {
        //[1,3,2,5,7,9,4]
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(4);

        QuickSort sort = new QuickSort(list);
        sort.sort(0, list.size() -1);
        System.out.println(list);
    }
}
