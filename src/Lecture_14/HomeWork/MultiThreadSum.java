package Lecture_14.HomeWork;

// Класс, формирующий заданное количество потоков и запускающий их на выполнение
public class MultiThreadSum {
    static int sum(int[] array, int threadNumber) {
        // Создаём массив потоков и инициируем их
        SingleThreadSum[] threadArray = new SingleThreadSum[threadNumber];
        for (int i = 0; i < threadArray.length; i++) {
            int size = array.length / threadNumber;
            int begin = size * i;
            int end = ((i + 1) * size);
            if ((array.length - end) < size) {
                end = array.length;
            }
            threadArray[i] = new SingleThreadSum(array, begin, end);
        }
        for (int i = 0; i < threadArray.length; i++) {
            try {
                threadArray[i].getThr().join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        // Вызываем метод для слияния получившихся частей
//        System.arraycopy(sumArraysSums(array, threadArray), 0, array, 0, array.length);
        int sum = sumArraysSums(threadArray);
        return sum;
    }

    // Метод для суммирования результатов суммирования элементов массива из потоков
    private static int sumArraysSums(SingleThreadSum[] threadArray) {
        int sum = 0;
        for (int i = 0; i < threadArray.length; i++) {
            while (!threadArray[i].isStop()){}
            sum += threadArray[i].getSum();
        }

        return sum;
    }

    // Метод для суммирования результатов суммирования элементов массива из потоков
    /*private static int[] sumArraysSums(int[] array, SingleThreadSum[] threadArray) {
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
    }*/
}
