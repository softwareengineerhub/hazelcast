package client;

/**
 * Created by amyrgorod on 10.8.2016 г..
 */

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.HazelcastClient;
import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

public class TestHazelcastClient {

    public static void main( String[] args ) throws InterruptedException {
        ClientConfig clientConfig = new ClientConfig();
        Config cfg = new Config();
        NetworkConfig network = cfg.getNetworkConfig();
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled( false );
        join.getTcpIpConfig().addMember( "192.168.0.144").setEnabled( true );
        HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );
        
        
        
        IMap map = client.getMap( "customers" );
        //System.out.println( "Map Size:" + map.size() );

        //map.put(map.size() + 1, "Andrey");

       // System.out.println( "Map Size:" + map.size() );
        map.put("A"+System.currentTimeMillis(), "a");
        System.out.println("--------------");
        client.shutdown();
                 
    }
}
