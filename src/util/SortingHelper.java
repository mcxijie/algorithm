package util;

import MergeSort.MergeSort;
import insertionSort.InsertionSort;
import quickSort.QuickSort;
import selectionSort.SelectionSort;

public class SortingHelper {
    private SortingHelper() {

    }

    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr) {
        long startTime = System.nanoTime();
        if (sortname.equals("selectionSort")) {
            SelectionSort.sort(arr);
        } else if (sortname.equals("insertionSort")) {
            InsertionSort.sort(arr);
        }else if (sortname.equals("InsertionSort2")) {
            InsertionSort.sort2(arr);
        } else if (sortname.equals("MergeSort")) {
            MergeSort.sort(arr);
        }else if (sortname.equals("MergeSort2")) {
            MergeSort.sort2(arr);
        }else if (sortname.equals("MergeSort3")) {
            MergeSort.sort3(arr);
        }else if (sortname.equals("MergeSort4")) {
            MergeSort.sort4(arr);
        }else if (sortname.equals("MergeSortBU")) {
            MergeSort.sortBU(arr);
        } else if (sortname.equals("QuickSort")) {
            QuickSort.sort(arr);
        } else if (sortname.equals("QuickSort2Ways")) {
            QuickSort.sort2ways(arr);
        }
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if (!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + "failed");
        }
        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}
