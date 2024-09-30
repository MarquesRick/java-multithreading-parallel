package thread.fundamentals.coordination.interrupt;

public class StopThreadUsingInterruptMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
        thread.interrupt(); //throws the catch message 'exiting blocking thread'
    }

    private static class BlockingTask implements Runnable{
        @Override
        public void run(){
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                System.out.println("Exiting blocking thread");
            }
        }
    }
}
