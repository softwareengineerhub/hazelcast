/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Denis
 */
public class Main2 {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog = null;//new Dog("Tosha",4 );
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("c://res.txt")))){
            dog=(Dog) in.readObject();
        }
        System.out.println(dog);
    }
}
