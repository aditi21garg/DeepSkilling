class MessagePrinter extends Thread {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(message + " - " + i);
        }
    }
}

public class ThreadCreation {
    public static void main(String[] args) {
        MessagePrinter thread1 = new MessagePrinter("Thread 1");
        MessagePrinter thread2 = new MessagePrinter("Thread 2");

        thread1.start();
        thread2.start();
    }
}
