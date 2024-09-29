package thread.fundamentals.creation.finaltest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * In this exercise we are going to implement a  MultiExecutor .
 * <p>
 * The client of this class will create a list of Runnable tasks and provide that list into MultiExecutor's constructor.
 * <p>
 * When the client runs the . executeAll(),  the MultiExecutor,  will execute all the given tasks.
 * <p>
 * To take full advantage of our multicore CPU, we would like the MultiExecutor to execute all the tasks in parallel,
 * by passing each task to a different thread.
 */
public class ThreadTestCreationMain {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Task 1 - Count: " + i);
                try {
                    Thread.sleep(500); // Sleep for 500ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Task 2 - Count: " + i);
                try {
                    Thread.sleep(700); // Sleep for 700ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task3 = () -> {
            for (int i = 1; i <= 4; i++) {
                System.out.println("Task 3 - Count: " + i);
                try {
                    Thread.sleep(300); // Sleep for 300ms
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Add tasks to a list
        List<Runnable> tasks = Arrays.asList(task3, task1, task2);

        MultiExecutor multiExecutor = new MultiExecutor(tasks);
        multiExecutor.executeAll();

    }

    public static class MultiExecutor {

        private final List<Runnable> tasks;

        /*
         * @param tasks to executed concurrently
         */
        public MultiExecutor(List<Runnable> tasks) {
            this.tasks = tasks;
        }

        /**
         * Executes all the tasks concurrently
         */
        public void executeAll() {
            List<Thread> threads = new ArrayList<>(tasks.size());

            for (Runnable task : tasks) {
                Thread thread = new Thread(task);
                threads.add(thread);
            }

            for (Thread thread : threads) {
                thread.start();
            }
        }
    }
}