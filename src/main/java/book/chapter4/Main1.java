/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter4;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICollection;
import com.hazelcast.core.ItemEvent;
import com.hazelcast.core.ItemListener;

/**
 *
 * @author denys
 */
public class Main1 {
    
    /*
    ISet (and the IList) is implemented as a collection within the MultiMap, where the ID
    of the Set is the key in the MultiMap and the value is the collection
    */
    
    
    //ItemListener
    
    public static void main(String[] args) throws InterruptedException {
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        ICollection<String> q = client.getQueue("queue");
        q.addItemListener(new ItemListener<String>() {
            
            @Override
            public void itemAdded(ItemEvent<String> ie) {
                System.out.println(ie);
            }

            @Override
            public void itemRemoved(ItemEvent<String> ie) {
                System.out.println(ie);
            }
        }, true);
        //true - if we need value ot just understand event ahs happened
        
        q.add("A");
        q.add("B");
        q.add("C");
        
        Thread.sleep(3000);
        
        q.remove("A");
        
    }
    
}
