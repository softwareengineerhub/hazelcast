/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import java.io.Serializable;

/**
 *
 * @author denys
 */
public class MyLocalTask implements Runnable, Serializable {

    @Override
    public void run() {
        try {
            System.out.println("TaskA started!!!");
            Thread.sleep(20000);
            System.out.println("TaskA finished!!!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}
