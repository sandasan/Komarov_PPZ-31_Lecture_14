package Lecture_14.HomeWork;

// Класс реализует Runnable
public class SingleThreadSum implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private Thread thr;
    private int index;
    private int sum;
    private boolean stop = false;

    // Конструктор, который получает массив по ссылке, и также создаёт и запускает поток
    public SingleThreadSum(int[] array, int begin, int end) {
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

    public int getSum() {
        return sum;
    }

    public boolean isStop() {
        return stop;
    }

    @Override
    // Суммирование элементов массива
    public void run() {
        int temp = 0;
        for (int i = begin; i < end; i++) {
            temp += array[i];
        }
        this.sum = temp;
        this.stop = true;
    }
}
