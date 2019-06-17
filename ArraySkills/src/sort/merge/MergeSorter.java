package sort.merge;

public class MergeSorter {

    public static void sort(int[] arr) {
        int size = arr.length;
        if (size < 2)
            return;

        int leftSize = size / 2;
        int rightSize = size - leftSize;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        System.arraycopy(arr, 0, left, 0, leftSize);
        System.arraycopy(arr, leftSize, right, 0, size - leftSize);

        sort(left);
        sort(right);
        merge(left, right, arr);
    }

    // Merges two sorted arrays
    private static void merge(int[] left, int[] right, int[] arr) {
        int leftSize = left.length;
        int rightSize = right.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while (i < leftSize)
            arr[k++] = left[i++];

        while (j < rightSize)
            arr[k++] = right[j++];
    }

}
