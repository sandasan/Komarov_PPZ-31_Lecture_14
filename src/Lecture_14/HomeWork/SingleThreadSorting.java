package Lecture_14.HomeWork;

// Класс реализует Runnable
public class SingleThreadSorting implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private boolean stop = false;

    // Конструктор, который получает массив по ссылке, и также создаёт и запускает поток
    public SingleThreadSorting(int[] array, int begin, int end) {
        super();
        this.array = array;
        this.begin = begin;
        this.end = end;
        thr = new Thread(this);
        thr.start();
        this.index = begin;
    }

    public Thread getThr() {
        return thr;
    }

    public int peekElement() {
        return array[index];
    }

    public int pollElement() {
        int temp = array[index];
        check();
        return temp;
    }

    public boolean isStop() {
        return stop;
    }

    @Override
    // Сортировка массива вставкой
    public void run() {
        int temp;
        for (int i = begin; i < end; i++) {
            int k = i - 1;
            temp = array[i];
            for (; k >= begin && array[k] > temp;) {
                array[k + 1] = array[k];
                array[k] = temp;
                k--;
            }
        }
    }

    // Вспомогательный метод
    private void check() {
        this.index++;
        if (this.index >= this.end) {
            this.stop = true;
        }
    }
}
