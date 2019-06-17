package sort.quick;

public class QuickSorter {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        if (array.length > 0) {
            int pivotIndex = (int) (left + Math.random() * (right - left + 1));
            int pivot = array[pivotIndex];
            while (i <= j) {
                while (array[i] < pivot)
                    i++;
                while (array[j] > pivot)
                    j--;
                if (i <= j) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    i++;
                    j--;
                }
            }
            if (left < j)
                quickSort(array, left, j);
            if (i < right)
                quickSort(array, i, right);
        }
    }

}