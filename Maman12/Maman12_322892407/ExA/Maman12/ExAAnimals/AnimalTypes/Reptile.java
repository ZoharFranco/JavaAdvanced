package Maman12.ExAAnimals.AnimalTypes;

import Maman12.ExAAnimals.Animal;
import Maman12.ExAAnimals.Attributes.Color;

public abstract class Reptile extends Animal {

    public Reptile(String name, int age, Color color) {
        super(name, age, color);
    }

    public void eat() {
        System.out.println("Reptile Eating...");
    }

    public void sleep() {
        System.out.println("Reptile Sleeping...");
    }

    public void crawl() {
        System.out.println("Reptile Crawling...");
    }

}
