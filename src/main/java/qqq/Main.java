package qqq;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
        Map<Integer, MyData> customers = hazelcastInstance.getMap( "qqq" );
        customers.put(1, new MyData(1L));
        customers.put(2, new MyData());
        customers.put(3, new MyData(3L));
    }

}
