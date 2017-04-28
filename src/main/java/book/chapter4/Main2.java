/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter4;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.ringbuffer.Ringbuffer;

/**
 *
 * @author denys
 */
public class Main2 {
    
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        Ringbuffer<Long> rb = client.getRingbuffer("rb");
        long sequence = rb.headSequence();
        System.out.println("Start reading from: "+sequence);
        while(true){
            System.out.println("Before");
            long item = rb.readOne(sequence);
            System.out.println("After");
            sequence++;
            System.out.println("Read: "+item);
        }
    }
    
}
