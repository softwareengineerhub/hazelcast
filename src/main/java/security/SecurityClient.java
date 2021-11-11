package security;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class SecurityClient {

    public static void main(String[] args) {
        ClientConfig clientConfig = new ClientConfig().addAddress("127.0.0.1");
        clientConfig.getGroupConfig().setName("username").setPassword("userpass");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        Map map = client.getMap("mymap");
        System.out.println(map);
        System.out.println("size="+map.size());
    }

}
