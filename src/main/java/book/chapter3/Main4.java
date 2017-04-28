/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter3;

/**
 *
 * @author denys
 */
public class Main4 {
    
    /*
        ILock - distributed lock.
        The Hazelcast.getLock doesn’t work on a name of type String, but can be a key of any type. (key is not the original lock!)
        A lock is not automatically garbage collected. So if you create new locks over time, make sure to
        destroy them. If you don’t, you can run into an OutOfMemoryError.    
    */
    
    public static void main(String[] args){
        
    }
    
}
