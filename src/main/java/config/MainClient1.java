/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.MulticastConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author denys
 */
public class MainClient1 {

    public static void main(String[] args) {
        MulticastConfig multicastConfig = new MulticastConfig();
        int port=multicastConfig.getMulticastPort();
        System.out.println("port="+port);
        
        
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
        IMap<String, Integer> map = hazelcastInstance.getMap("test");
        map.set("a", 1);
        map.set("b", 2);
        map.set("c", 3);
        long start = System.currentTimeMillis();        
        
        map.keySet();        
        
        long end = System.currentTimeMillis();
        hazelcastInstance.shutdown();
        System.out.println(start-end);
        
        HazelcastClient.shutdownAll();
        
        
    }

}
