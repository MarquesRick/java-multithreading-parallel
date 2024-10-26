package br.com.fundamentals.creation.intro;

public class ThreadIntroMain {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Code that will run in  a new thread
                System.out.println("we are now in thread " + Thread.currentThread().getName());
                System.out.println("Current thread priority is " + Thread.currentThread().getPriority());
            }
        });
        
        thread.setName("New Worker Thread"); //rename thread

        thread.setPriority(Thread.MAX_PRIORITY); //set priority for thread

        System.out.println("We are in thread: " + Thread.currentThread().getName() + " before starting a new thread");
        thread.start();
        System.out.println("We are in thread: " + Thread.currentThread().getName() + " after starting a new thread");
    }
}
