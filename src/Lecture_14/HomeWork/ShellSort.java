package Lecture_14.HomeWork;

import java.util.Arrays;

public class ShellSort {
    public static void sort(int[] array) {
        System.out.println("Исходный массив: " + Arrays.toString(array));
        int arrayLength = array.length;
        int step = arrayLength / 2;
        while (step > 1) {
            System.out.println("Разборка массива на части:");
            System.out.println("arrayLength = " + arrayLength);
            System.out.println("step = " + step);
            int arraysCount = step;
            int biggerArraysCount = arrayLength % step;
            int biggerArraySize = (arrayLength + step - arrayLength % step) / step;
            int smallerArraysCount = arraysCount - biggerArraysCount;
            int smallerArraySize = biggerArraySize - 1;
            int[][] valuesArray = new int[arraysCount][];
            int[][] indexesArray = new int[arraysCount][];
            // Формирование массивов для отправки на сортировку
            for (int i = 0; i < arraysCount; i++) {
                int currentPartialArraySize = (i + 1) > biggerArraysCount ? smallerArraySize : biggerArraySize;
                valuesArray[i] = new int[currentPartialArraySize];
                indexesArray[i] = new int[currentPartialArraySize];
                for (int j = 0; j < currentPartialArraySize; j++) {
                    valuesArray[i][j] = array[i + j * step];
                    indexesArray[i][j] = i + j * step;
                }
                System.out.println("valuesArray[" + i + "]: " + Arrays.toString(valuesArray[i]));
                System.out.println("\t\t\t\t\t\tindexesArray[" + i + "]: " + Arrays.toString(indexesArray[i]));
            }

            // Отправка массивов на сортировку
            MultiThreadSorting.sort(valuesArray);

            System.out.println("Сборка массива из частей:");
            int[] resultArray = new int[arrayLength];
            for (int i = 0; i < step; i++) {
                for (int j = 0; j < valuesArray[i].length; j++) {
                    resultArray[indexesArray[i][j]] = valuesArray[i][j];
                }
            }

            System.out.println("      array: " + Arrays.toString(array));
            System.out.println("resultArray: " + Arrays.toString(resultArray));
            step = step / 2 + step % 2;
        }
        insertionSort(array);
        System.out.println("Отсортированный массив:");
        System.out.println("      array: " + Arrays.toString(array));

        // d[i] = d[i - 1] / 2

    }

    // Статический метод для однопоточной сортировки
    static void insertionSort(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            int k = i - 1;
            temp = array[i];
            for (; k >= 0 && array[k] > temp;) {
                array[k + 1] = array[k];
                array[k] = temp;
                k--;
            }
        }
    }
}
