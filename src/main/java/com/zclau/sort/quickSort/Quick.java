package com.zclau.sort.quickSort;

/**
 * Created by liuzicong on 15/4/2017.
 */
public class Quick {

    public static int partition(int[] a, int lo, int hi) {
        int i = lo; //左扫描指针
        int j = hi + 1; //右扫描指针
        int v = a[lo]; //切分元素

        for (; ; ) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    public static void exchange(int[] a, int l, int r) {
        if ((l < 0 || l >= a.length) || (r < 0 || r >= a.length)) {
            return;
        }
        if (l == r) {
            return;
        }

        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int i = partition(a, lo, hi);
        sort(a, lo, i - 1);
        sort(a, i + 1, hi);
    }

    public static void main(String[] args) {
        int[] a = {2, 1, 5, 6, 7, 8, 9, 4, 3, 10};
        int[] a1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        sort(a1, 0, a.length - 1);
        for (int i : a1) {
            System.out.println(i);
        }
    }
}
