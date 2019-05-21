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


	/**
	 *
	 */
	public static int firstIndexOf(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (a[middle] >= key) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}

		if (low < a.length && a[low] == key) {
			return low;
		}

		return -1;
	}

	public static int lastIndexOf(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int middle = low + (high - low) / 2;
			if (a[middle] <= key) {
				low = middle + 1;
			} else {
				high = middle - 1;
			}
		}

		if (high >= 0 && a[high] == key) {
			return high;
		}

		return -1;
	}

    public static void main(String[] args) {
		System.out.println(firstIndexOf(new int[]{1,2,3}, 6));
		System.out.println(firstIndexOf(new int[]{1,2,3}, 3));
		System.out.println(firstIndexOf(new int[]{1,2,3,3,3,4}, 3));

		System.out.println(lastIndexOf(new int[]{1,2,2,3,3,4}, 3));
		System.out.println(lastIndexOf(new int[]{1,2,3,4}, 3));
		System.out.println(lastIndexOf(new int[]{1,1,1,1,1}, 1));
		System.out.println(lastIndexOf(new int[]{1,2,3,4,5}, 5));
    }
}
