package Lecture_14.daemon_interrupt;

import Lecture_14.join.NewThread;

public class Main {
    // Пример использования setDaemon, isDaemon, interrupt
    public static void main(String[] args) {
        Thread t = Thread.currentThread(); // получаем главный поток

        Thread thr1 = new Thread(new NewThread(), "2 thr");

        thr1.setDaemon(true); // устанавливаем поток демоном
        System.out.println("thr1.isDaemon(): " + thr1.isDaemon());
        thr1.start();

        System.out.println("Stop program");
        t.interrupt(); // прерываем основной поток
    }
}
