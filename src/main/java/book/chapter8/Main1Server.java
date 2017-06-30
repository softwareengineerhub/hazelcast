/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter8;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import java.util.Map;

/**
 *
 * @author Denis
 */
public class Main1Server {

    public static void main(String[] args) {
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        
        Config cfg = new Config();
            NetworkConfig network = cfg.getNetworkConfig();
            JoinConfig join = network.getJoin();
            join.getMulticastConfig().setEnabled(false);
            join.getTcpIpConfig().setEnabled(true).addMember("192.168.0.114");
            HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(cfg);
        
        //IMap<String, Integer> map = instance.getMap("map");
        //map.put("A", 1);
        
    }

}
