/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import com.hazelcast.config.Config;
import com.hazelcast.config.ExecutorConfig;
import com.hazelcast.config.MultiMapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;
import com.hazelcast.core.MultiMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denys
 */
public class Main {
    
    
    public static void main(String[] args) throws InterruptedException {      
        Config c = new Config();
        MultiMapConfig mc = c.getMultiMapConfig("a");
        System.out.println(mc.getValueCollectionType());
        mc.setValueCollectionType(MultiMapConfig.ValueCollectionType.LIST);
        
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(c);
        MultiMap map = instance.getMultiMap("a");
        map.put("a", "A");
        map.put("a", null);
    }
    
}
