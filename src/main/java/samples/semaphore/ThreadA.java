/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.semaphore;

import java.util.concurrent.Semaphore;

/**
 *
 * @author denys
 */
public class ThreadA extends Thread {
    
    private Semaphore semaphore;

    public ThreadA(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("ThreadA.Before.acquire");
            semaphore.acquire();
            System.out.println("ThreadA.After.acquire");
            Thread.sleep(1000);
            semaphore.release();
            System.out.println("ThreadA.release");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
