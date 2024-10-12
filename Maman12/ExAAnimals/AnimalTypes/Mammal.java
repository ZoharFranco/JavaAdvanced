package Maman12.ExAAnimals.AnimalTypes;

import Maman12.ExAAnimals.Animal;
import Maman12.ExAAnimals.Attributes.Color;
import Maman12.ExAAnimals.Attributes.Owner;

public abstract class Mammal extends Animal {
    private Owner owner;

    public Mammal(String name, int age, Color color, Owner owner) {
        super(name, age, color);
        this.owner = owner;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void eat() {
        System.out.println("Mammal Eating...");
    }

    public void sleep() {
        System.out.println("Mammal Sleeping...");
    }


    @Override
    public boolean equals(Object obj) {
        return obj instanceof Mammal &&
                super.equals(obj) &&
                this.owner.equals(((Mammal) obj).owner);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Mammal cloned = (Mammal) super.clone();
        Owner clonedOwner = (Owner) this.owner.clone();
        cloned.setOwner(clonedOwner);
        return cloned;
    }

    @Override
    public String toString() {
        return super.toString() + ", Owner: " + owner;
    }
}
