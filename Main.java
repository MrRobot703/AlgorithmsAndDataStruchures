import algorithms.InsertionSort;
import algorithms.MergeSort;
import algorithms.QuickSort;
import algorithms.SelectionSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new Random()
                .ints(-20, 20)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());

        Integer[] arr = list.toArray(new Integer[]{});

        /*System.out.println(Arrays.toString(list.toArray()));
        List sortedList = MergeSort.sort(list);
        System.out.println(Arrays.toString(sortedList.toArray()));*/

        /*System.out.println(Arrays.toString(arr));
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));*/

        System.out.println(Arrays.toString(list.toArray()));
        List<Integer> sortedList = QuickSort.sort(list);
        System.out.println(Arrays.toString(sortedList.toArray()));
        System.out.println(Arrays.toString(list.toArray()));
    }
}
