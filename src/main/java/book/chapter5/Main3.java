/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter5;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.map.AbstractEntryProcessor;
import java.util.Map;

/**
 *
 * @author Denis
 */
public class Main3 {
    
    public static void main(String[] args){
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        IMap<String, Integer> map = client.getMap("a");        
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        System.out.println("----------------");
        Map<String, Object> updatedMap =  map.executeOnEntries(new AbstractEntryProcessor<String, Integer>() {
            
            @Override
            public Object process(Map.Entry<String, Integer> entry) {
                entry.setValue(entry.getValue()+10);
                return entry.getValue();
            }
        });
        System.out.println("--------updateMap--------");
        System.out.println(updatedMap);
        System.out.println("-----------IMap--------------");
        for(String key: map.keySet()){
            System.out.println(key+"="+map.get(key));
        }
    }
    
}
