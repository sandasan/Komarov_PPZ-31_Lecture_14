package Lecture_14.join;

// Наследуем класс Thread
public class NewThread2 extends Thread {
    NewThread2(String name) {
        super(name);
    }

    // Переопределяем метод run()
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
        }
    }
}
