/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter3;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.ICondition;
import com.hazelcast.core.ILock;

/**
 *
 * @author denys
 */
public class Main5 {

    /*
        ICondition.
        ILock.newCondition(String name)
        Waiting threads are signaled in FIFO order.
     */
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IAtomicLong counter = hz.getAtomicLong("counter");
        ILock lock = hz.getLock("lock");
        ICondition isOneCondition = lock.newCondition("one");
        lock.lock();
        try {
            while (counter.get() != 1) {
                System.out.println("Waiting");
                isOneCondition.await();
            }
        } finally {
            lock.unlock();
        }
        System.out.println("Wait finished, counter: " + counter.get());
    }

}
