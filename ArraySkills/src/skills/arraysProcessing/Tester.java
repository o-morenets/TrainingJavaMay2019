package skills.arraysProcessing;

import java.util.Arrays;

public class Tester {

    public static void main(String[] args) {
        Tester tester = new Tester();

        System.out.println("Java 7");
        tester.test(new ArraysJava7());

        System.out.println("=========================================");

        System.out.println("Java 8 (inplace)");
        tester.test(new ArraysJava8_Inplace());

        System.out.println("=========================================");

        System.out.println("Java 8 (new array creation)");
        tester.test(new ArraysJava8());
    }

    private void test(IArraysProcessing arraysProcessing) {

        int[] arr1 = {-2, 4, 0, 999, -7, 26, 5, -999, -2, -2, -6, -5, 5, -1, 0};
        int[] arrSortedAsc = {4, 5, 7, 8, 9};
        int[] arrSortedDesc = {9, 8, 7, 5, 4};
        int[] newArr;

        System.out.println("Initial array:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Найти сумму элементов массива");
        System.out.println(arraysProcessing.sumElements(arr1));

        System.out.println("Найти максимальный элемент, значение и индекс");
        System.out.println(arraysProcessing.maxElement(arr1) + "; " + arraysProcessing.maxIndex(arr1));

        System.out.println("Найти минимальный элемент, значение и индекс");
        System.out.println(arraysProcessing.minElement(arr1) + "; " + arraysProcessing.minIndex(arr1));

        System.out.println("Найти среднее значение элементов массива");
        System.out.println(arraysProcessing.average(arr1));

        System.out.println("Посчитать количество элементов равных заданному (5)");
        System.out.println(arraysProcessing.countSpecifiedElements(arr1, 5));

        System.out.println("Посчитать количество элементов равных нулю");
        System.out.println(arraysProcessing.countZeroElements(arr1));

        System.out.println("Посчитать количество элементов больше нуля");
        System.out.println(arraysProcessing.countElementsGraterThanZero(arr1));

        System.out.println("Помножить элементы массива на число (10)");
        newArr = Arrays.copyOf(arr1, arr1.length);
        newArr = arraysProcessing.multiplyElementsWithNumber(newArr, 10);
        System.out.println(Arrays.toString(newArr));

        System.out.println("Прибавить к элементам массива их индекс");
        newArr = Arrays.copyOf(arr1, arr1.length);
        newArr = arraysProcessing.addIndexToElement(newArr);
        System.out.println(Arrays.toString(newArr));

        System.out.println("Обнулить четные по значению элементы массива");
        newArr = Arrays.copyOf(arr1, arr1.length);
        newArr = arraysProcessing.setZeroEvenElement(newArr);
        System.out.println(Arrays.toString(newArr));

        System.out.println("Обнулить элементы  с нечетным индексом");
        newArr = Arrays.copyOf(arr1, arr1.length);
        newArr = arraysProcessing.setZeroOddIndex(newArr);
        System.out.println(Arrays.toString(newArr));

        System.out.println("Найти первый положительный элемент");
        System.out.println(arraysProcessing.findFirstPositiveElement(arr1));

        System.out.println("Найти последний отрицательный элемент");
        System.out.println(arraysProcessing.findLastNegativeElement(arr1));

        System.out.println("Найти индексы вхождения элемента в массив (5)");
        System.out.println(Arrays.toString(arraysProcessing.indexesOfElement(arr1, 5)));

        System.out.println("Проверить массив на упорядоченность элементов по возрастанию (не сортированный)");
        System.out.println(arraysProcessing.isOrderedAsc(arr1));

        System.out.println("Проверить массив на упорядоченность элементов по возрастанию (сортированный)");
        System.out.println(arraysProcessing.isOrderedAsc(arrSortedAsc));

        System.out.println("Проверить массив на упорядоченность элементов по спаданию (не сортированный)");
        System.out.println(arraysProcessing.isOrderedDesc(arr1));

        System.out.println("Проверить массив на упорядоченность элементов по спаданию (сортированный)");
        System.out.println(arraysProcessing.isOrderedDesc(arrSortedDesc));

        System.out.println("Циклический сдвиг элементов массива на k- позиций вправо");
        newArr = Arrays.copyOf(arr1, arr1.length);
        newArr = arraysProcessing.shiftElementsRight(newArr, 3);
        System.out.println(Arrays.toString(newArr));

        System.out.println("Вывести элементы, значения которых равны значениям других элементов");
        System.out.println(Arrays.toString(arraysProcessing.duplicates(arr1)));

        System.out.println("Найти количество элементов больших среднего значения");
        System.out.println(arraysProcessing.numElementsGreaterThanAvg(arr1));

        System.out.println("Вывести элементы, значения которых не равны значениям других элементов");
        System.out.println(Arrays.toString(arraysProcessing.uniqueElements(arr1)));

        System.out.println("Вывести элементы одного массива, которые не равны элементам второго массива");
        System.out.println(Arrays.toString(arraysProcessing.differentElements(arr1, arrSortedAsc)));

        System.out.println("Посчитать сколько элементов в массиве с таким-же значением, как и первый");
        System.out.println(arraysProcessing.numElementsEqualFirst(arr1));

        System.out.println("Из двух отсортированных массивов сделать третий отсортированный, не сортируя его");
        int[] arr1sorted = Arrays.copyOf(arr1, arr1.length);
        Arrays.sort(arr1sorted);
        int[] arr2sorted = Arrays.copyOf(arrSortedDesc, arrSortedDesc.length);
        Arrays.sort(arr2sorted);
        System.out.println(Arrays.toString(arraysProcessing.mergeSortedArrays(arr1sorted, arr2sorted)));

        System.out.println("Поменять первый положительный элемент с последним положительным, второй с предпоследним и т.д.");
        newArr = Arrays.copyOf(arr1, arr1.length);
        newArr = arraysProcessing.swapPositiveElements(newArr);
        System.out.println(Arrays.toString(newArr));
    }
}
