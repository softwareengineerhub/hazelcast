/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book.chapter3;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IAtomicReference;
import java.io.Serializable;

/**
 *
 * @author denys
 */
public class Main3 {
    
    /*
    Also functions could be applyed to Reference
    
    
    */
    
    
    public static void main(String[] args){
        HazelcastInstance client = Hazelcast.newHazelcastInstance();
        IAtomicReference<Person> ref = client.getAtomicReference("person");
        System.out.println(ref.get());
        Person p = new Person();
        p.setAge(30);
        p.setName("Denis");
        ref.set(p);         
        System.out.println(ref.get());
        client.shutdown();
    }
    
}

class Person implements Serializable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + '}';
    }    
}
