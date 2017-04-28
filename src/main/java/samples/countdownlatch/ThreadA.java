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
public class ThreadA extends Thread {

    private CountDownLatch countDownLatch;

    public ThreadA(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            long count = countDownLatch.getCount();
            while (count > 0) {
                System.out.println("count=" + count);
                countDownLatch.countDown();
                count = countDownLatch.getCount();
            }
            System.out.println("ThreadA. Completed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
