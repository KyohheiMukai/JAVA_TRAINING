package ch14.ex14_additional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Copyright (C) 2012 RICOH Co., Ltd. All rights reserved.
 */

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to
 * be exectued by a thread.
 *
 * [Instruction]
 *  Implement one constructor and three methods.
 *  Don't forget to write a Test program to test this class.
 *  Pay attention to @throws tags in the javadoc.
 *  If needed, you can put "synchronized" keyword to methods.
 *  All classes for implementation must be private inside this class.
 *  Don't use java.util.concurrent package.
 */
public class ThreadPool {

	private boolean isStarted = false;
	private int queueSize = -1;
	private int numberOfThreads = -1;
	private Queue<Thread> threadQueue = null;


    /**
     * Constructs ThreadPool.
     *
     * @param queueSize the max size of queue
     * @param numberOfThreads the number of threads in this pool.
     *
     * @throws IllegalArgumentException if either queueSize or numberOfThreads
     *         is less than 1
     */
    public ThreadPool(int queueSize, int numberOfThreads) {

    	if(queueSize < 1)
    		throw new IllegalArgumentException("queueSize is less than 1");

    	if(numberOfThreads < 1)
    		throw new IllegalArgumentException("numberOfThreads is less than 1");

    	this.queueSize =queueSize;
    	this.numberOfThreads = numberOfThreads;

    }

    /**
     * Starts threads.
     *
     * @throws IllegalStateException if threads has been already started.
     */
    public void start() {
    	if(isStarted)
    		throw new IllegalStateException("Threads has been already started.");

    	threadQueue = new LinkedList<Thread>();
    	isStarted = true;
    }

    /**
     * Stop all threads and wait for their terminations.
     *
     * @throws IllegalStateException if threads has not been started.
     */
    public void stop() {
    	if(!isStarted)
    		throw new IllegalStateException("Threads has not been already started.");
    	isStarted = false;
    	threadQueue.clear();
    	threadQueue = null;

    }

    /**
     * Executes the specified Runnable object, using a thread in the pool.
     * run() method will be invoked in the thread.
     *
     * @param runnable Runnable object whose run() method will be invoked.
     *
     * @throws NullPointerException if runnable is null.
     * @throws IllegalStateException if this pool has not been started yet.
     */
    public synchronized void dispatch(Runnable runnable) {
    	if(runnable == null)
    		throw new NullPointerException("runnable is null.");
    	if(!isStarted)
    		throw new IllegalStateException("Threads has not been already started.");

    	Thread th = new Thread(runnable);
    	th.start();
    	threadQueue.add(th);
    }
}