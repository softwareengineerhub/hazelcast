/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;

/**
 *
 * @author denys
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        
        ClientConfig clientConfig = new ClientConfig();
        Config cfg = new Config();
        NetworkConfig network = cfg.getNetworkConfig();
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled(false);
        join.getTcpIpConfig().addMember("192.168.0.144").setEnabled(true);
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);

        IList list = client.getList("customers");        
        System.out.println(list.size()+"--------------");
        client.shutdown();
    }
    
}
