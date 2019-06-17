package skills.arraysProcessing;

/* Желательно уметь написать любую задачу из нижеприведенных на листке бумаги (в блокноте) без ошибок */

public interface IArraysProcessing {

    /* Найти сумму элементов массива */
    int sumElements(int[] arr);

    /* Найти максимальный элемент, значение */
    int maxElement(int[] arr);

    /* Найти максимальный элемент, индекс */
    int maxIndex(int[] arr);

    /* Найти минимальный элемент, значение */
    int minElement(int[] arr);

    /* Найти минимальный элемент, индекс */
    int minIndex(int[] arr);

    /* Найти среднее значение элементов массива */
    double average(int[] arr);

    /* Посчитать количество элементов равных заданному */
    long countSpecifiedElements(int[] arr, int number);

    /* Посчитать количество элементов равных нулю */
    long countZeroElements(int[] arr);

    /* Посчитать количество элементов больше нуля */
    long countElementsGraterThanZero(int[] arr);

    /* Помножить элементы массива на число */
    int[] multiplyElementsWithNumber(int[] arr, int number);

    /* Прибавить к элементам массива их индекс */
    int[] addIndexToElement(int[] arr);

    /* Обнулить четные по значению элементы массива */
    int[] setZeroEvenElement(int[] arr);

    /* Обнулить элементы  с нечетным индексом. */
    int[] setZeroOddIndex(int[] arr);

    /* Найти первый положительный элемент */
    int findFirstPositiveElement(int[] arr);

    /* Найти последний отрицательный элемент */
    int findLastNegativeElement(int[] arr);

    /* Найти индексы вхождения элемента в массив */
    int[] indexesOfElement(int[] arr, int number);

    /* Проверить массив на упорядоченность элементов по возрастанию */
    boolean isOrderedAsc(int[] arr);

    /* Проверить массив на упорядоченность элементов по спаданию */
    boolean isOrderedDesc(int[] arr);

    /* Циклический сдвиг элементов массива на k- позиций вправо */
    int[] shiftElementsRight(int[] arr, int k);

    /* Вывести элементы, значения которых равны значениям других элементов */
    int[] duplicates(int[] arr);

    /* Найти количество элементов больших среднего значения */
    long numElementsGreaterThanAvg(int[] arr);

    /* Вывести элементы, значения которых не равны значениям других элементов */
    int[] uniqueElements(int[] arr);

    /* Вывести элементы одного массива, которые не равны элементам второго массива */
    int[] differentElements(int[] arr1, int[] arr2);

    /* Посчитать сколько элементов в массиве с таким-же значением, как и первый */
    long numElementsEqualFirst(int[] arr);

    /* Из двух отсортированных массивов сделать третий отсортированный, не сортируя его */
    int[] mergeSortedArrays(int[] arr1, int[] arr2);

    /* Поменять первый положительный элемент с последним положительным, второй с предпоследним и т.д. */
    int[] swapPositiveElements(int[] arr);
}
