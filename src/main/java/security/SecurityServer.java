package security;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;

public class SecurityServer {

    public static void main(String[] args) {
        Config cfg = new Config();
        cfg.getGroupConfig().setName("username").setPassword("userpass");
        Hazelcast.newHazelcastInstance(cfg);
    }

}
