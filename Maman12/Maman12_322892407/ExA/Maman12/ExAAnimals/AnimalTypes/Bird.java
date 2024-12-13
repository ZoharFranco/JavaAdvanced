package Maman12.ExAAnimals.AnimalTypes;

import Maman12.ExAAnimals.Animal;
import Maman12.ExAAnimals.Attributes.Color;

public abstract class Bird extends Animal {

    public Bird(String name, int age, Color color) {
        super(name, age, color);
    }

    public void eat() {
        System.out.println("Bird Eating...");
    }

    public void sleep() {
        System.out.println("Bird Sleeping...");
    }

    public void fly() {
        System.out.println("Bird Flying...");
    }
}
