/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 * @author denys
 */
public class App1 {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ThreadA a = new ThreadA(countDownLatch);
        ThreadB b = new ThreadB(countDownLatch);
        a.start();
        b.start();
    }

}
