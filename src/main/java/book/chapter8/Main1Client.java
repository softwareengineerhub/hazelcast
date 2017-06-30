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
import java.util.Map;

/**
 *
 * @author Denis
 */
public class Main1Client {
    
    public static void main(String[] args){
        ClientConfig clientConfig = new ClientConfig().addAddress("192.168.0.114");
        //HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig);
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
        
        //IMap map=hazelcastInstance.getMap("events.map");
        //System.out.println(map.size());
        
        
        
        Map<Integer, String> customers = hazelcastInstance.getMap( "customers" );
        customers.remove("ttt");
    }
    
}
