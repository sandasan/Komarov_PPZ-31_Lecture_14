package Lecture_14.multithread_acceleration;

// Класс, формирующий заданное количество потоков и запускающий их на выполнение
public class MultiThreadSorting {
    static void sort(int[] array, int threadNumber) {
        // Создаём массив потоков и инициируем их
        SingleThreadSorting[] threadArray = new SingleThreadSorting[threadNumber];
        for (int i = 0; i < threadArray.length; i++) {
            int size = array.length / threadNumber;
            int begin = size * i;
            int end = ((i + 1) * size);
            if ((array.length - end) < size) {
                end = array.length;
            }
            threadArray[i] = new SingleThreadSorting(array, begin, end);
        }
        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].getThr().join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // Вызываем метод для слияния получившихся частей
        System.arraycopy(mergeArrays(array, threadArray), 0, array, 0, array.length);
    }

    // Метод для слияния частей массива из потоков
    private static int[] mergeArrays(int[] array, SingleThreadSorting[] threadArray) {
        int[] arr = new int[array.length];
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            int k = -1;
            for (int j = 0; j < threadArray.length; j++) {
                if (!threadArray[j].isStop() && min > threadArray[j].peekElement()) {
                    min = threadArray[j].peekElement();
                    k = j;
                }
            }
            if (k != -1) {
                arr[i] = threadArray[k].pollElement();
            }
        }

        return arr;
    }
}
