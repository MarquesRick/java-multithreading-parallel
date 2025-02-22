package br.com.concurrency.race.condition.atomic.operations;


/*
* In this exercise we are going to implement a class called MinMaxMetrics .
A single instance of this class will be passed to multiple threads in our application.
MinMaxMetrics is an analytics class and is used to keep track of the minimum and the maximum of a particular business or performance metric in our application.

Example:

A stock trading application that keeps track of the minimum and maximum price of the stock on a daily basis.


The class will have 3 methods:

addSample(..) - Takes a new sample.

getMin() - Returns the sample with the minimum value we have seen so far.

getMax() - Returns the sample with the maximum value we have seen so far.


Notes:

- Each of those methods can be called by any given number of threads concurrently, so the class needs to be thread safe.

- In addition, this class is used for analytics, so it needs to be as performant as possible as we don't want it to slow down our business logic threads too much.

- Threads that call getMin() or getMax() are interested in only one of the values and are never interested in both the min and the max in the same time
*
*
* */


public class MinMaxMetricsTest {

    private volatile long minValue;
    private volatile long maxValue;

    public MinMaxMetricsTest() {
        this.maxValue = Long.MIN_VALUE;
        this.minValue = Long.MAX_VALUE;
    }

    public void addSample(long newSample) {
        synchronized (this) {
            this.minValue = Math.min(newSample, this.minValue);
            this.maxValue = Math.max(newSample, this.maxValue);
        }
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return this.minValue;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return this.maxValue;
    }
}


