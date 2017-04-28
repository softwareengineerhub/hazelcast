/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denys
 */
public class ThreadB extends Thread {

    private CountDownLatch countDownLatch;

    public ThreadB(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println("ThreadB.started");
            countDownLatch.await();
            System.out.println("ThreadB.Completed");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
