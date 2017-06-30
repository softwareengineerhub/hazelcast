/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.QueueConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ILock;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.Member;

/**
 *
 * @author denys
 */
public class AppTestClient {
 
    public static void main(String[] args){        
        HazelcastInstance client = HazelcastClient.newHazelcastClient();
        Object res=client.getQueue("q1").poll();
        System.out.println("res="+res);
    }
    
}
