package Maman12.ExAAnimals;

import Maman12.ExAAnimals.AnimalTypes.Bird;
import Maman12.ExAAnimals.AnimalTypes.Reptile;
import Maman12.ExAAnimals.Animals.Dog;
import Maman12.ExAAnimals.Animals.Pigeon;
import Maman12.ExAAnimals.Animals.Snake;
import Maman12.ExAAnimals.Attributes.Color;
import Maman12.ExAAnimals.Attributes.Owner;

import java.util.ArrayList;

public class Zoo {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();

        Dog dog = new Dog("don", 12, Color.BLACK, new Owner("moshe", "1234"));
        animals.add(dog);

        Snake snake = new Snake("snakei", 13, Color.GREEN);
        animals.add(snake);

        Pigeon pigeon = new Pigeon("pigeoni", 14, Color.WHITE);
        animals.add(pigeon);


        // Polymorphism check
        System.out.println("\n\n** Polymorphism check **\n");
        for (Animal animal : animals) {
            System.out.println(animal);

            animal.eat();
            animal.sleep();

            if (animal instanceof Reptile) {
                ((Snake) animal).crawl();
            }

            if (animal instanceof Bird) {
                ((Pigeon) animal).fly();
            }

            if (animal instanceof Dog) {
                ((Dog) animal).bark();
            }
        }

        // Clone check
        System.out.println("\n\n** Clone check **\n");
        System.out.println("Lets clone the dog:");
        try {
            Dog dog2 = (Dog) dog.clone();
            System.out.println("The 2 dogs:");
            System.out.println(dog);
            System.out.println(dog2);

            System.out.println("Change the new dog's age to 15");
            dog2.setAge(15);
            System.out.println(dog);
            System.out.println(dog2);

            System.out.println("Change the new dog's owner to newOwner");
            dog2.getOwner().setName("newOwner");
            System.out.println(dog);
            System.out.println(dog2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
