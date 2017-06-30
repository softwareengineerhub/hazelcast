/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter6;

import java.io.Serializable;

/**
 *
 * @author denys
 */
public class UserKey implements Serializable {
    private int userId;

    public UserKey(int userId) {
        this.userId = userId;
    }
    
    /*@Override
    public int hashCode(){
        return -1;
    }
    
    public boolean equlas(UserKey other){
        return false;
    }*/
    
}
