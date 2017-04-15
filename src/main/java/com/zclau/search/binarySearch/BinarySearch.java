package com.zclau.search.binarySearch;

import com.zclau.util.In;
import com.zclau.util.StdIn;
import com.zclau.util.StdOut;

import java.util.Arrays;

/**
 * Execution:  java com.zclau.search.binarySearch.BinarySearch com.zclau.binarySearch/tinyW.txt < com.zclau.binarySearch/tinyT.txt
 *
 *
 * Created by liuzicong on 14/4/2017.
 */
public class BinarySearch {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whiteList = in.readAllInts();

        Arrays.sort(whiteList);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if(indexOf(whiteList, key) == -1) {
                StdOut.println(key);
            }
        }
    }
}
