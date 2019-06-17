package skills.arraysProcessing;

import java.util.Arrays;

public class ArraysJava7 implements IArraysProcessing {

    @Override
    public int sumElements(int[] arr) {
        int sum = 0;
        for (int e : arr) {
            sum += e;
        }
        return sum;
    }

    @Override
    public int maxElement(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        for (int e : arr) {
            if (e > maxElement) {
                maxElement = e;
            }
        }
        return maxElement;
    }

    @Override
    public int maxIndex(int[] arr) {
        int maxElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    @Override
    public int minElement(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        for (int e : arr) {
            if (e < minElement) {
                minElement = e;
            }
        }
        return minElement;
    }

    @Override
    public int minIndex(int[] arr) {
        int minElement = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < minElement) {
                minElement = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Override
    public double average(int[] arr) {
        double sum = 0.0;
        for (int e : arr) {
            sum += e;
        }
        return sum / arr.length;
    }

    @Override
    public long countSpecifiedElements(int[] arr, int number) {
        int count = 0;
        for (int e : arr) {
            if (e == number) {
                count++;
            }
        }
        return count;
    }

    @Override
    public long countZeroElements(int[] arr) {
        return countSpecifiedElements(arr, 0);
    }

    @Override
    public long countElementsGraterThanZero(int[] arr) {
        int count = 0;
        for (int e : arr) {
            if (e > 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] multiplyElementsWithNumber(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= number;
        }
        return arr;
    }

    @Override
    public int[] addIndexToElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += i;
        }
        return arr;
    }

    @Override
    public int[] setZeroEvenElement(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = 0;
            }
        }
        return arr;
    }

    @Override
    public int[] setZeroOddIndex(int[] arr) {
        for (int i = 1; i < arr.length; i += 2) {
            if (i % 2 != 0) {
                arr[i] = 0;
            }
        }
        return arr;
    }

    @Override
    public int findFirstPositiveElement(int[] arr) {
        for (int e : arr) {
            if (e > 0) {
                return e;
            }
        }
        return -1;
    }

    @Override
    public int findLastNegativeElement(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                return arr[i];
            }
        }
        return +1;
    }

    @Override
    public int[] indexesOfElement(int[] arr, int number) {
        int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                result[count++] = i;
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public boolean isOrderedAsc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isOrderedDesc(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[] shiftElementsRight(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            int temp = arr[arr.length - 1];
            System.arraycopy(arr, 0, arr, 1, arr.length - 1);
            arr[0] = temp;
        }
        return arr;
    }

    @Override
    public int[] duplicates(int[] arr) {
        int[] result = new int[arr.length / 2];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    result[count++] = arr[i];
                    break;
                }
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public long numElementsGreaterThanAvg(int[] arr) {
        double avg = average(arr);
        long count = 0;
        for (int e : arr) {
            if (e > avg) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] uniqueElements(int[] arr) {
        int[] result = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean hasDuplicates = false;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    hasDuplicates = true;
                    break;
                }
            }
            if (!hasDuplicates) {
                result[count++] = arr[i];
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public int[] differentElements(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int count = 0;

        for (int e1 : arr1) {
            boolean hasDuplicates = false;
            for (int e2 : arr2) {
                if (e1 == e2) {
                    hasDuplicates = true;
                }
            }
            if (!hasDuplicates) {
                result[count++] = e1;
            }
        }
        return Arrays.copyOf(result, count);
    }

    @Override
    public long numElementsEqualFirst(int[] arr) {
        int first = arr[0];
        int count = 0;
        for (int e : arr) {
            if (e == first) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];

        int leftSize = arr1.length;
        int rightSize = arr2.length;
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < leftSize) {
            result[k++] = arr1[i++];
        }

        while (j < rightSize) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    @Override
    public int[] swapPositiveElements(int[] arr) {
        int indexLeft = -1;
        int indexRight = arr.length;
        do {
            int i;
            for (i = indexLeft + 1; i < arr.length; i++) {
                if (arr[i] > 0) {
                    break;
                }
            }
            indexLeft = i;

            int j;
            for (j = indexRight - 1; j >= 0; j--) {
                if (arr[j] > 0) {
                    break;
                }
            }
            indexRight = j;

            if (indexLeft <= indexRight) {
                int temp = arr[indexLeft];
                arr[indexLeft] = arr[indexRight];
                arr[indexRight] = temp;
            }
        } while (indexLeft <= indexRight);

        return arr;
    }

}
