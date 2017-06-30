/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.transaction.TransactionContext;

/**
 *
 * @author denys
 */
public class MainClient {

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig().addAddress("192.168.0.114");
        //HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient(clientConfig);
        HazelcastInstance hazelcastInstance = HazelcastClient.newHazelcastClient();
        TransactionContext ctx = hazelcastInstance.newTransactionContext();
        try {
            ctx.beginTransaction();
            IMap map = hazelcastInstance.getMap("a");
            map.put("" + System.currentTimeMillis(), "Q" + System.currentTimeMillis());            
            String s = null;
            s.toString();
            ctx.commitTransaction();
            System.out.println(map.size());
        } catch (Throwable th) {
            th.printStackTrace();
            ctx.rollbackTransaction();
        }
        //hazelcastInstance.shutdown();
        Hazelcast.shutdownAll();
    }

}
