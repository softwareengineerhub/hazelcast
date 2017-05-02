/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter8;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author Denis
 */
public class Main1Client {
    
    public static void main(String[] args){
        ClientConfig clientConfig = new ClientConfig().addAddress("127.0.0.1");
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig);
        
        IMap map=hazelcastInstance.getMap("map");
        System.out.println(map.size());
    }
    
}
