/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter5;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author Denis
 */
public class Main2 {
    
    public static void main(String[] args) throws InterruptedException{
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        IMap map = client.getMap("articles");
        map.put("A", "a");
        map.put("B", "b");
        map.put("C", "c");
        /*for(int i=0;i<10;i++){
            map.put(i, i);
        }*/
        
        while(true){
            Thread.sleep(1000);
            for(Object obj: map.keySet()){
                System.out.println(obj+"="+map.get(obj));
            }
            map.put("q"+System.currentTimeMillis(), "Q");
        }
    }
    
}
