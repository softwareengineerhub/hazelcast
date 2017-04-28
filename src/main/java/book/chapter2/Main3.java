/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter2;

/**
 *
 * @author denys
 */
public class Main3 {
    
    public static void main(String[] args){
        /*
        Some DistributedObjects are truly partitioned, some not.
        IMap - uses partitions inside
        IAtomicLong, ISemaphore - not
        
        For eaxmple:
        s1, s2 - are in same partiotion
        ISemaphore s1 = hz.getSemaphore("s1");
        ISemaphore s2 = hz.getSemaphore("s2");
        
        We can contol partitions by names:
        ISemaphore s1 = hz.getSemaphore("s1@foo");
        ISemaphore s2 = hz.getSemaphore("s2@foo");
        @foo - name of partition
        */
        
        
        /*
        To retrieve partons we can use next:
        String parKey = s1.getPartitionKey();
        ISemaphore s3 = hz.getSemaphore("s3@"+parKey);
        
        This is for case when we need to create Object in the same partition, but we do not have explicity the key
        
        */
        
        //Random partiotion key
        //String parKey = hz.getPartitionService().randomPartitionKey();
        
        //Deployment:
        //distributed dynamic class loader
        
        //Hazelcast config is not updatable: Once a HazelcastInstance is created
        
        //shutdown - release resources and end network communication
        
    }
    
}
