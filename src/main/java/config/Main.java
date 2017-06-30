/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.InMemoryFormat;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.instance.GroupProperties;

/**
 *
 * @author denys
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException{
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        Config config = new Config();
        config.setProperty(GroupProperties.PROP_ENABLE_JMX_DETAILED, "true");
        IMap map = instance.getMap("a");
        Object res=map.get("q");
        System.out.println(res);
        System.out.println("-------------");
        map.set("A", 1);
        System.out.println(map.get("A"));
        
        /*while(true){
            Thread.sleep(1000);
            System.out.println(map.size());
        }*/
        
       // instance.shutdown();
    }
    
}
