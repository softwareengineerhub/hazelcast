/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.outofmemory;

import com.hazelcast.client.ClientOutOfMemoryHandler;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;
import com.hazelcast.core.OutOfMemoryHandler;
import com.hazelcast.instance.DefaultOutOfMemoryHandler;

/**
 *
 * @author denys
 */
public class Main {
    
    public static void main(String[] args) throws InterruptedException{
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        IList list = client.getList("list");
        /*Hazelcast.setOutOfMemoryHandler(new OutOfMemoryHandler() {
            @Override
            public void onOutOfMemory(OutOfMemoryError oome, HazelcastInstance[] his) {
                String message = oome.getMessage();
                System.out.println("###############message="+message);
            }
        });*/
        /*Hazelcast.setOutOfMemoryHandler(new DefaultOutOfMemoryHandler(){
            @Override
            public boolean shouldHandle(OutOfMemoryError oome) {
                return false;
            }

            @Override
            public void onOutOfMemory(OutOfMemoryError oome, HazelcastInstance[] hazelcastInstances) {
                String message = oome.getMessage();
              //  System.out.println("###############message="+message);
            }
            
            
            
        });*/
        
        /*Hazelcast.setOutOfMemoryHandler(new ClientOutOfMemoryHandler(){
            @Override
            public void onOutOfMemory(OutOfMemoryError oome, HazelcastInstance[] hazelcastInstances) {
                String message = oome.getMessage();
                System.out.println("###############message="+message);
            }
            
        });*/
        
       /* int i=0;
        while (true) {
            try {
                byte[] data = new byte[50 * 1024 * 1024];
                list.add(data);
                System.out.println("Iteration: " + i+++"; list.size="+list.size());
                Thread.sleep(500);
            } catch (Throwable th) {
                list.clear();                
                Thread.sleep(500);
            }
        }*/
       
       IMap<String, String> map = client.getMap("a");
       String res=map.get("key");
       System.out.println(res);
        
    }
    
}
