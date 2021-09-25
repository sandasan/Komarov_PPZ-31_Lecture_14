package Lecture_14.multithread_acceleration;

import Lecture_14.HomeWork.ShellSort;

import java.util.Arrays;
import java.util.Random;

// Главный класс для тестирования ускорения при использовании многопоточности
public class Main {
    public static void main(String[] args) {
        // Создаём 3 массива, наполненных случайными числами
        int[] array = new int[200000];
//        int[] array = new int[20];
        Random rn = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rn.nextInt(10);
//            array[i] = rn.nextInt(100);
        }
        int[] array2 = array.clone();
        int[] array3 = array.clone();
        System.out.println("array: " + Arrays.toString(array));

        // Запуск сортировки в разных режимах для сравнения скорости
        long tStart = System.currentTimeMillis();
        sort(array);
        long tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tStart) + " ms - Static method sort");
        System.out.println("array: " + Arrays.toString(array));

        tStart = System.currentTimeMillis();
        MultiThreadSorting.sort(array2, 3);
        tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tStart) + " ms - MultiThreadSort sort");
        System.out.println("array2: " + Arrays.toString(array2));

        tStart = System.currentTimeMillis();
        Arrays.sort(array3);
        tEnd = System.currentTimeMillis();
        System.out.println((tEnd - tStart) + " ms - Arrays sort");
        System.out.println("array3: " + Arrays.toString(array3));
    }

    // Статический метод для однопоточной сортировки
    static void sort(int[] array) {
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
