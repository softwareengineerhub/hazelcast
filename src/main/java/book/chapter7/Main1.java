/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter7;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ITopic;
import com.hazelcast.core.Message;
import com.hazelcast.core.MessageListener;

/**
 *
 * @author Denis
 */
public class Main1 {
    
    public static void main(String[] args) throws InterruptedException{
        HazelcastInstance instance = Hazelcast.newHazelcastInstance();
        ITopic topic = instance.getTopic("topic");
        topic.publish("Hello!!!");
        Thread.sleep(3000);
        topic.addMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message msg) {
                System.out.println("\tmsg="+msg.getMessageObject());
            }
        });        
        Thread.sleep(4000);
        topic.publish("Message!");
    }
    
}
