/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.QueueConfig;
import com.hazelcast.config.TopicConfig;
import com.hazelcast.core.Client;
import com.hazelcast.core.ClientListener;
import com.hazelcast.core.Cluster;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.LifecycleListener;
import com.hazelcast.core.MembershipListener;
import com.hazelcast.core.MigrationListener;
import com.hazelcast.core.MultiMap;
import com.hazelcast.core.PartitionService;
import com.hazelcast.map.listener.MapListener;
import com.hazelcast.partition.PartitionLostListener;
import com.hazelcast.web.listener.ServerLifecycleListener;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import sun.security.util.Cache;

/**
 *
 * @author denys
 */
public class AppTest {
    
    public static void main(String[] args) throws InterruptedException {                    
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        
        
    }
    
}
