package com.self.practice;

public class DeamonThreads {
    public static void main(String[] args) {
        NewThread newThread = new NewThread();
        newThread.setDaemon(true);
        newThread.start();
        System.out.println("completed");
    }
}
class NewThread extends Thread{
    public void run() {
        for (int i =0; i< 500; i++){
            System.out.println("lets run "+i);
        }
    }
}
