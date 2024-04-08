package Seminar_2_hw;

import java.lang.reflect.Constructor;

public class Cat extends Animal{
    private String sound;

    public Cat(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }



    public void makeSound(){
        System.out.printf("Кот %s издает звук - %s", getName(), sound);
    }


}
