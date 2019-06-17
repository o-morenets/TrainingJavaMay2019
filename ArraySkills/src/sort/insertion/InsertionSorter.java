package sort.insertion;

public class InsertionSorter {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = temp;
        }
    }

}
