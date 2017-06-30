/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter6;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denys
 */
public class MyTask implements Runnable, Serializable {
    private String taskName;
    private static final long serialVersionUID = 1L;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }
    
    @Override
    public void run() {
        try {
            String address=InetAddress.getLocalHost().toString();
            long id=Thread.currentThread().getId();
            System.out.println("START;   "+taskName+";   "+address+"; Thread.id="+id);
            Thread.sleep(7000);
            System.out.println("END;   "+taskName+";   "+address+"; Thread.id="+id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
