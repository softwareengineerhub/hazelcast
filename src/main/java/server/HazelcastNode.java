package server;

/**
 * Created by amyrgorod on 10.8.2016 г..
 */

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HazelcastNode {

    public static void main( String[] args ) {
        Config cfg = new Config();

        NetworkConfig network = cfg.getNetworkConfig();
        
        JoinConfig join = network.getJoin();
        join.getMulticastConfig().setEnabled( false );
        //join.getMulticastConfig().setEnabled( true );
        //join.getTcpIpConfig().addMember( "10.249.140.56" ).setRequiredMember( "10.249.140.56" ).setEnabled( true );
        //join.getTcpIpConfig().addMember("192.168.0.114").setRequiredMember("192.168.0.137").setEnabled(true);
        //join.getTcpIpConfig().setRequiredMember("192.168.0.137").setEnabled(true);
        //join.getTcpIpConfig().addMember("192.168.0.114").setEnabled(true);
        
        //join.getTcpIpConfig().setEnabled(true);
        //join.getTcpIpConfig().setEnabled(true).addMember("192.168.0.137");
        //join.getTcpIpConfig().setEnabled(true).addMember("192.168.0.114");
        join.getTcpIpConfig().setEnabled(true).addMember("192.168.0.137");
                

        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(cfg);
        Map<Integer, String> customers = hazelcastInstance.getMap( "customers" );
        customers.put( 1, "Joe" );
        customers.put( 2, "Ali" );
        customers.put( 3, "Avi" );

        System.out.println( "Customer with key 1: " + customers.get(1) );
        System.out.println( "Map Size:" + customers.size() );       
               
        
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println( "Map Size:" + customers.size() );
               // customers.put(customers.size()+10, "Data");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
