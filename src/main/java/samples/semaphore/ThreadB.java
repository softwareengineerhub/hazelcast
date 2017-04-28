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
public class ThreadB extends Thread {
    
    private Semaphore semaphore;

    public ThreadB(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("ThreadB.Before.acquire");
            semaphore.acquire();
            System.out.println("ThreadB.After.acquire");
            Thread.sleep(5000);
            semaphore.release();
            System.out.println("ThreadB.release");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
