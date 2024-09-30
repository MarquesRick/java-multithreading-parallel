package thread.fundamentals.coordination.interrupt;

import java.math.BigInteger;

public class StopThreadVerifyingCancellationMain {
    public static void main(String[] args) {
        Thread thread = new Thread(
                new LongComputationTask(
                        new BigInteger("200000"),
                        new BigInteger("100000000")
                )
        ); //this will spend a lot of time to return

        thread.start();
        thread.interrupt(); //without checking if isInterrupted() this would be executed after the task returns
    }

    private static class LongComputationTask implements Runnable {
        private final BigInteger base;
        private final BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) { //this is like Cancellation Token,
                                                             // that checks if the thread was cancelled
                    System.out.println("Prematurely interrupted computation");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
