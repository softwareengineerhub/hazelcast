/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter3;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;

/**
 *
 * @author denys
 */
public class Main1 {
    
    /*
    
    java provides mechanisms for synch of data in 1 JVM.
    Hazelcast provides way to distributed synchronization primitivies: ILock, IAtomicLong
    This probides high availability - if 1 machine fails, data still exists
    
    */
    
    public static void main(String[] args) {
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        IAtomicLong counter = client.getAtomicLong("counter");
        for (int k = 0; k < 1000; k++) {
            if (k % 500000 == 0) {
                System.out.println("At: " + k);
            }
            counter.incrementAndGet();
        }
        System.out.printf("Count is %s\n", counter.get());
        
        //Functions:
                
        //applies to current value, but do not modifie original
        long res = counter.apply(c->c+1);
        System.out.printf("Count is %s, res is %s\n", counter.get(), res);
        
        //applies to current value, modifie original
        res=counter.alterAndGet(c->c+2);
        System.out.printf("Count is %s, res is %s\n", counter.get(), res);
        
        //modify, but returns original value
        res=counter.getAndAlter(c->c+3);
        System.out.printf("Count is %s, res is %s\n", counter.get(), res);
        
        //modify, but do not return result
        counter.alter(c->c+4);
        System.out.printf("Count is %s, res is %s\n", counter.get(), res);
        
        client.shutdown();
        
        
        /*
        Replication: the IAtomicLong has 1 synchronous backup and zero asynchronous backups and is not configurable.
        */
    }
    
}
