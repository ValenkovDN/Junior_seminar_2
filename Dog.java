package Seminar_2_hw;

public class Dog extends Animal{
    private String sound;

    public Dog(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }

    public void makeSound(){
        System.out.printf("Пёс %s издает звук - %s", getName(), sound);
    }
}
