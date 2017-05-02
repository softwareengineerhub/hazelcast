/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author Denis
 */
public class Main {
    
    public static void main(String[] args) throws IOException {
        Dog dog = new Dog("Tosha",4 );
        dog.setColor("Brown");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("c://res.txt")))){
            out.writeObject(dog);
        }
    }
}
