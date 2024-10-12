package Maman12.ExAAnimals;


import Maman12.ExAAnimals.Attributes.Color;

public abstract class Animal implements Cloneable {

    private String name;
    private int age;
    private Color color;

    public Animal(String name, int age, Color color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public abstract void eat();

    public abstract void sleep();

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + this.getClass().getName().substring(this.getClass().getPackageName().length() + 1)
                + ") " + this.name + ", at age: " + this.age + ", with color: " + this.color;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Animal &&
                ((Animal) obj).getName().equals(this.getName()) &&
                ((Animal) obj).getAge() == this.getAge() &&
                ((Animal) obj).getColor() == this.getColor();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();

    }
}
