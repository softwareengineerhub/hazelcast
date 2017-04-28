/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter2;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicLong;
import com.hazelcast.core.IMap;
import com.hazelcast.core.IQueue;
import com.hazelcast.core.IdGenerator;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author denys
 */
public class Main2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        IQueue<String> q = hz.getQueue("q");
        
        //IdGenerator - for generation unique names in cluster on fly
        IdGenerator idGenerator = hz.getIdGenerator("idGenerator");
        IMap someMap = hz.getMap("somemap-"+idGenerator.newId());
        
        //Different types of data can be stored by same key
        IAtomicLong atomicLong = hz.getAtomicLong("a");
        IMap map = hz.getMap("a");
        
        //Removes Distributed object from cluster. Faster then clear()
        map.destroy();
        
    }

}
