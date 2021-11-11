package qqq;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

import java.util.Map;

public class ClientApp {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        Map<Integer, String> imap = hazelcastInstance.getMap("qqq");
        String res=imap.get(2);
        System.out.println("res="+res);
        System.out.println("imap.size="+imap.size());
        imap.entrySet().forEach(System.out::println);
    }

}
