package com.defy.concurrency;

import java.util.concurrent.*;

public class ExecutorExample {

    public void example() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Callable<String> futureTask =
                new Callable<String>() {
                    @Override
                    public String call() throws Exception {
                    	System.out.println("Current Thread: "+Thread.currentThread());
                        return "Executing task";
                    }
                };
        final Future<String> future = executor.submit(futureTask);
        final Future<String> future2 = executor.submit(futureTask);
        final Future<String> future3 = executor.submit(futureTask);
        
        try {
            String result = future.get();
            System.out.println("result = " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdownNow();
    }

    public static void main(String[] args) {
        ExecutorExample test = new ExecutorExample();
        test.example();
    }
}