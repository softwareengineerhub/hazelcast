/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter6;

import com.hazelcast.config.Config;
import com.hazelcast.config.ExecutorConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IExecutorService;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denys
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
        config.getNetworkConfig().getJoin().getTcpIpConfig().addMember("192.168.0.116");
        config.getNetworkConfig().getJoin().getTcpIpConfig().addMember("192.168.0.137");
        
        ExecutorConfig ec = config.getExecutorConfig("Denis");
        ec.setPoolSize(3);
        System.out.println("ec="+ec);
        
        HazelcastInstance instance = Hazelcast.newHazelcastInstance(config);
        
        IExecutorService executor = instance.getExecutorService("Denis");        
        Thread.sleep(10000);
        for(int i=0;i<10;i++){
            executor.execute(new MyTask("Task"+i));
        }       
    }
    
}
