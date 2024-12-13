package org.example;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private String id;
    private int yearOfBirth;

    public Person(String firstName, String lastName, String id, int yearOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.yearOfBirth = yearOfBirth;
    }


    @Override
    public int compareTo(Person o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, id, yearOfBirth);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
