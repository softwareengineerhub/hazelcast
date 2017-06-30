/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.map.listener.EntryAddedListener;

/**
 *
 * @author denys
 */
public class MyServerMapListener implements EntryAddedListener {

    @Override
    public void entryAdded(EntryEvent ee) {
        System.out.println("Server Listener");
    }

}
