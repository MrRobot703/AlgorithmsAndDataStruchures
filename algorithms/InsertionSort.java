package algorithms;

import java.util.List;

public class InsertionSort {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int currentIndex = 1; currentIndex < list.size(); currentIndex++) {
            T current = list.get(currentIndex);
            int i = currentIndex - 1;
            while (i >= 0 && list.get(i).compareTo(current) > 0) {
                list.set(i+1,list.get(i));
                i--;
            }
            list.set(i+1, current);
        }
    }
}
