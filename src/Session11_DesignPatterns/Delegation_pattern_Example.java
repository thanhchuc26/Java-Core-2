/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session11_DesignPatterns;

/**
 *
 * @author June
 */
class Delegation_pattern implements Delegation_Pattern_Interface {

    @Override
    public void display() {
        System.out.println("class Delegation_pattern");
    }
}

public class Delegation_pattern_Example {

    public static void main(String[] args) {
        Delegation_pattern delegation_pattern = new Delegation_pattern();
        delegation_pattern.display();

        
        Delegation_Pattern_Interface example = new Delegation_Pattern_Interface() {
            @Override
            public void display() {
                System.out.println("Delegation_pattern_Example");
            }
        };
        example.display();
    }
}
