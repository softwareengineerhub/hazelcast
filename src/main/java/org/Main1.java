/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org;

import com.hazelcast.config.Config;
import com.hazelcast.config.ExecutorConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;

/**
 *
 * @author denys
 */
public class Main1 {
    
    
     public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        ExecutorConfig ec = config.getExecutorConfig("es");
        ec.setPoolSize(1);
        
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        IExecutorService service = instance.getExecutorService("es");
        
        
    }
    
    
}
