package selectionSort;

import util.ArrayGenerator;
import util.SortingHelper;

public class SelectionSort {

    private SelectionSort() {

    }

    public static <E extends Comparable<E>> void sort(E[] arr) {    //extends用在类上表示集成某一个类，用在泛型的话是要实现某一个接口
        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;

            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) { //compareTo返回的是一个整形，如果这个整形小于0表示前者小于后者，等于0表示前者等于后者，大于0表示前置大于后置
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);

        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000,100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);

            SortingHelper.sortTest("selectionSort", arr);
        }


        Student[] students = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};

        SelectionSort.sort(students);

        for (Student student : students) {
            System.out.print(student + " ");
        }
        System.out.println();


    }
}
