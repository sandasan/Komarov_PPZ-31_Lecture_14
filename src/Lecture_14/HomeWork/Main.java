package Lecture_14.HomeWork;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Раздел Сортировки Шелла
        int[] array = new int[9];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
//            array[i] = i;
            array[i] = rn.nextInt(10);
        }

        ShellSort.sort(array);

        // Раздел Суммирования
        /*
        // Создаём 3 массива, наполненных случайными числами
        int[] array = new int[200000];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
        }
        int[] array2 = array.clone();
        int[] array3 = array.clone();

        // Запуск суммирования в разных режимах для сравнения скорости
        long tStart = System.currentTimeMillis();
        int arraySum = sum(array);
        System.out.println("arraySum: " + arraySum);
        long tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tStart) + " ms - Static method sum");

        tStart = System.currentTimeMillis();
        arraySum = MultiThreadSum.sum(array2, 3);
        System.out.println("arraySum: " + arraySum);
        tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tStart) + " ms - MultiThreadSort sum");

        tStart = System.currentTimeMillis();
        // Arrays.sum(array3);
        arraySum = Arrays.stream(array3).sum();
        System.out.println("arraySum: " + arraySum);
        tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tStart) + " ms - Arrays sum");
        */
    }
    // Статический метод для однопоточного суммирования
    static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    // Статический метод для однопоточной сортировки
    /*static void sort(int[] array) {
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
    }*/
}
