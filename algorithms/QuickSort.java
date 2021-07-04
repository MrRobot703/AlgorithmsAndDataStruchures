package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        List<T> less = new ArrayList<>();
        List<T> pivotList = new ArrayList<>();
        List<T> grater = new ArrayList<>();

        if (list.size() <= 1) {
            return list;
        } else {
            T pivot = list.get(new Random().nextInt(list.size()));

            for (T e: list) {
                if(e.compareTo(pivot) < 0) {
                    less.add(e);
                } else if (e.compareTo(pivot) > 0) {
                    grater.add(e);
                } else {
                    pivotList.add(e);
                }
            }

            less = sort(less);
            grater = sort(grater);

            less.addAll(pivotList);
            less.addAll(grater);
            return less;
        }
    }
}
