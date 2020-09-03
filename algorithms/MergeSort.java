package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MergeSort {
    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if(list.size() == 1) {
            return list;
        }

        int middle = list.size()/2;
        List<T> left = IntStream.range(0, middle)
                .mapToObj(list::get)
                .collect(Collectors.toList());
        List<T> right = IntStream.range(middle, list.size())
                .mapToObj(list::get)
                .collect(Collectors.toList());

        left = sort(left);
        right = sort(right);

        return merge(left, right);
    }

    private static <T extends Comparable<T>> List<T> merge(List<T> left, List<T> right) {
        List<T> result = new ArrayList<>();

        int leftIndex = 0, rightIndex = 0;
        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }

        while (leftIndex < left.size()) {
            result.add(left.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < right.size()) {
            result.add(right.get(rightIndex));
            rightIndex++;
        }

        return result;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void sort(T[] array, int p, int r) {
        if (p < r) {
            int mid = p + (r - p)/2;
            sort(array, p, mid);
            sort(array, mid + 1, r);
            merge(array, p, mid, r);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> void merge(T[] array, int p, int mid, int r) {
        int leftLength = mid - p + 1;
        int rightLength = r - mid;

        T[] L = (T[]) new Comparable[leftLength];
        T[] R = (T[]) new Comparable[rightLength];

        System.arraycopy(array, p, L, 0, leftLength);
        System.arraycopy(array, mid + 1, R, 0, rightLength);

        int leftIndex = 0;
        int rightIndex = 0;
        for (int k = p; k <= r; k++) {

            int comparing;
            if (leftIndex == leftLength) {
                comparing = 1;
            } else if (rightIndex == rightLength) {
                comparing = -1;
            } else {
                comparing = L[leftIndex].compareTo(R[rightIndex]);
            }

            if (comparing < 0) {
                array[k] = L[leftIndex];
                leftIndex++;
            } else {
                array[k] = R[rightIndex];
                rightIndex++;
            }
        }
    }
}
