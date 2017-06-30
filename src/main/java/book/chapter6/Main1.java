/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter6;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author denys
 */
public class Main1 {
    
    public static void main(String[] args){
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IMap map = instance.getMap("map");
        map.put(new UserKey(1), "A");
        map.delete(new UserKey(1));        
        Object res=map.get(new UserKey(1));
        System.out.println("res="+res);
    }
    
}
