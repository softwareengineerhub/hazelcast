/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter5;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

/**
 *
 * @author Denis
 */
public class Main1 {
    
    /*
    By default, Hazelcast uses 271 partitions
    
    
    The IMap extends the Java ConcurrentMap
    
    Lazy creation: The Map is not created when the getMap method is called, but is created only when the
Map instance is accessed. This is useful to know if you use the DistributedObjectListener and fail to
receive creation events.
    
    */
    /*HashCode and equals
        
<hazelcast>
<map name="objectMap">
<in-memory-format>OBJECT</in-memory-format>
</map>
<map name="binaryMap">
<in-memory-format>BINARY</in-memory-format>
</map>
</hazelcast>

        in OBJECT equal and hashCode,
        in binary - only binary snapshot of data
        
        */
    
    
    /*
    ------------High availability-----
    
    
    
    */
    
    public static void main(String[] args){        
        HazelcastInstance client = Hazelcast.newHazelcastInstance();        
        IMap<Employee, String> objectMap = client.getMap("objectMap");        
        Employee emp = new Employee();
        emp.setName("Denis");
        emp.setAge(30);
        emp.setSalary(5000);
        objectMap.put(emp, "A");
        System.out.println("---------------------------------");
        Employee emp1 = new Employee();
        //emp1.setName("Denis");
        emp1.setAge(30);
        emp1.setSalary(5000);
        String val = objectMap.get(emp1);
        System.out.println("value="+val);
    }
    
}
