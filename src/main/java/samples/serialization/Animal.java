/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package samples.serialization;

/**
 *
 * @author Denis
 */
public class Animal {

    private String color;

    public Animal() {
        System.out.println("Constructor");
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
