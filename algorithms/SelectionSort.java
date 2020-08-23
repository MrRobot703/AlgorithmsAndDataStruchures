package algorithms;

import java.util.List;

public class SelectionSort {
    public static <T extends Comparable<T>> void sort(List<T> list) {
        for (int currentIndex = 0; currentIndex < list.size(); currentIndex++) {
            int minIndex = currentIndex;
            for (int i = currentIndex + 1; i < list.size(); i++) {
                if (list.get(minIndex).compareTo(list.get(i)) > 0) minIndex = i;
            }
            list.set(currentIndex, list.set(minIndex, list.get(currentIndex)));
        }
    }
}
