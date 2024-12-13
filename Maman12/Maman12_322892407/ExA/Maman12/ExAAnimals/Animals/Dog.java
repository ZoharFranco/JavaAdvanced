package Maman12.ExAAnimals.Animals;

import Maman12.ExAAnimals.AnimalTypes.Mammal;
import Maman12.ExAAnimals.Attributes.Color;
import Maman12.ExAAnimals.Attributes.Owner;

public class Dog extends Mammal {
    public Dog(String name, int age, Color color, Owner owner) {
        super(name, age, color, owner);
    }

    public void bark() {
        System.out.println("Dog Barking...");
    }
}
