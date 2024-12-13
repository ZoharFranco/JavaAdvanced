package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

public class MySet<T> {
    private ArrayList<T> items;

    public MySet() {
        items = new ArrayList<>();
    }

    public MySet(Collection<T> items) {
        ArrayList<T> uniqueItems = new ArrayList<>(items.stream().distinct().toList());
        this.items = new ArrayList<>(uniqueItems);
    }

    public void union(MySet<T> other) {
        ArrayList<T> uniqueItems = new ArrayList<>(other.items.stream().distinct().toList());
        for (T uniqueItem : uniqueItems) {
            if (!this.items.contains(uniqueItem)) this.items.add(uniqueItem);
        }
    }

    public void intersect(MySet<T> other) {
        ArrayList<T> uniqueItems = new ArrayList<>(other.items.stream().distinct().toList());
        this.items.retainAll(uniqueItems);
    }

    public boolean isSubset(MySet<T> other) {
        ArrayList<T> uniqueItems = new ArrayList<>(other.items.stream().distinct().toList());
        return this.items.containsAll(uniqueItems);
    }

    public boolean isMember(T item) {
        return this.items.contains(item);
    }

    public void insert(T item) {
        if (!this.items.contains(item)) items.add(item);
    }

    public void delete(T item) {
        items.remove(item);
    }

    public Iterator<T> iterator() {
        return items.iterator();
    }

    @Override
    public String toString() {
        return "MySet{" +
                "items=" + items +
                '}';
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }


}
