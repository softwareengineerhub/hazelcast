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
public class App1 {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2, true);
        ThreadA a = new ThreadA(semaphore);
        ThreadB b = new ThreadB(semaphore);
        ThreadC c = new ThreadC(semaphore);
        c.start();
        a.start();
        b.start();
    }

}
