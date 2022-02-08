package com.ivan.diythread;

public class ThreadTask implements Runnable{

    public ThreadTask() {}
    
    @Override
    public void run() {
        dealMessage();
    }
    
	 public void dealMessage() {
	 System.out.println("hello world");
	 }
}