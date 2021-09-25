package Lecture_14.join;

public class Main {
    // Приемр использования join()
    public static void main(String[] args) {
	    Thread thr1 = new Thread(new NewThread(), "2 thr");
	    NewThread2 thr4 = new NewThread2("5 thr");

	    try {
	        thr1.start();
	        thr4.start();
	        // Теперь (после выполнения этих команд) главный поток ждёт окончания дополнительных потоков
            thr1.join();
            thr4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stop program");
    }
}
