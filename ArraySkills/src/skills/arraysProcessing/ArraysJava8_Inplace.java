package skills.arraysProcessing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysJava8_Inplace implements IArraysProcessing {

    @Override
    public int sumElements(int[] arr) {
        return Arrays.stream(arr).sum();
    }

    @Override
    public int maxElement(int[] arr) {
        return Arrays.stream(arr).max().getAsInt();
    }

    @Override
    public int maxIndex(int[] arr) {
        return IntStream.range(0, arr.length).boxed().max(Comparator.comparingInt(index -> arr[index])).get();
    }

    @Override
    public int minElement(int[] arr) {
        return Arrays.stream(arr).min().getAsInt();
    }

    @Override
    public int minIndex(int[] arr) {
        return IntStream.range(0, arr.length).boxed().min(Comparator.comparing(index -> arr[index])).get();
    }

    @Override
    public double average(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }

    @Override
    public long countSpecifiedElements(int[] arr, int number) {
        return Arrays.stream(arr).filter(e -> e == number).count();
    }

    @Override
    public long countZeroElements(int[] arr) {
        return Arrays.stream(arr).filter(e -> e == 0).count();
    }

    @Override
    public long countElementsGraterThanZero(int[] arr) {
        return Arrays.stream(arr).boxed().filter(e -> e > 0).count();
    }

    @Override
    public int[] multiplyElementsWithNumber(int[] arr, int number) {
        IntStream.range(0, arr.length).forEach(i -> arr[i] *= number);
        return arr;
    }

    @Override
    public int[] addIndexToElement(int[] arr) {
        IntStream.range(0, arr.length).forEach(i -> arr[i] += i);
        return arr;
    }

    @Override
    public int[] setZeroEvenElement(int[] arr) {
        IntStream.range(0, arr.length).forEach(i -> {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            }});
        return arr;
    }

    @Override
    public int[] setZeroOddIndex(int[] arr) {
        IntStream.range(0, arr.length).filter(i -> i % 2 != 0).forEach(i -> arr[i] = 0);
        return arr;
    }

    @Override
    public int findFirstPositiveElement(int[] arr) {
        return Arrays.stream(arr).filter(e -> e > 0).findFirst().orElse(-1);
    }

    @Override
    public int findLastNegativeElement(int[] arr) {
        return Arrays.stream(arr).filter(e -> e < 0).reduce((left, right) -> right).orElse(+1);
    }

    @Override
    public int[] indexesOfElement(int[] arr, int number) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == number).toArray();
    }

    @Override
    public boolean isOrderedAsc(int[] arr) {
        return Arrays.equals(arr, Arrays.stream(arr).sorted().toArray());
    }

    @Override
    public boolean isOrderedDesc(int[] arr) {
        return Arrays.equals(arr,
                Arrays.stream(arr).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray());
    }

    @Override
    public int[] shiftElementsRight(int[] arr, int k) {
        return IntStream.range(0, arr.length).map(i -> arr[(arr.length + i - k) % arr.length]).toArray();
    }

    @Override
    public int[] duplicates(int[] arr) {
        return Arrays.stream(arr)
                .filter(e -> Collections.frequency(Arrays.stream(arr).boxed().collect(Collectors.toList()), e) > 1)
                .distinct()
                .toArray();
    }

    @Override
    public long numElementsGreaterThanAvg(int[] arr) {
        return Arrays.stream(arr).filter(e -> e > Arrays.stream(arr).average().getAsDouble()).count();
    }

    @Override
    public int[] uniqueElements(int[] arr) {
        return Arrays.stream(arr)
                .filter(e -> Collections.frequency(Arrays.stream(arr).boxed().collect(Collectors.toList()), e) == 1)
                .toArray();
    }

    @Override
    public int[] differentElements(int[] arr1, int[] arr2) {
        return Arrays.stream(arr1)
                .filter(e -> !Arrays.stream(arr2).boxed().collect(Collectors.toList()).contains(e))
                .toArray();
    }

    @Override
    public long numElementsEqualFirst(int[] arr) {
        return IntStream.range(0, arr.length).filter(i -> arr[i] == arr[0]).count();
    }

    @Override
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        return IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
    }

    @Override
    public int[] swapPositiveElements(int[] arr) {
        int[] indexes = IntStream.range(0, arr.length).filter(i -> arr[i] > 0).toArray();
        swapFirstAndLast(arr, indexes);
        return arr;
    }

    /**
     * Helper method
     * Recursively changes boundary elements
     *
     * @param arr     initial array
     * @param indexes array of positive numbers indexes
     */
    private void swapFirstAndLast(int[] arr, int[] indexes) {
        if (indexes.length > 1) {
            int firstIndex = indexes[0];
            int lastIndex = indexes[indexes.length - 1];

            int temp = arr[firstIndex];
            arr[firstIndex] = arr[lastIndex];
            arr[lastIndex] = temp;

            swapFirstAndLast(arr, Arrays.stream(indexes, 1, indexes.length - 1).toArray());
        }
    }

}
