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
public class ThreadC extends Thread {

    private Semaphore semaphore;

    public ThreadC(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println("ThreadC.Before.acquire");
            semaphore.acquire();
            System.out.println("ThreadC.After.acquire");
            Thread.sleep(10000);
            semaphore.release();
            System.out.println("ThreadC.release");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
