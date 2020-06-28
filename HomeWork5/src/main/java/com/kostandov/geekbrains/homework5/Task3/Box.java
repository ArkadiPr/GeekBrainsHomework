package com.kostandov.geekbrains.homework5.Task3;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    public List<T> getFruits() {
        return fruits;
    }

    private List<T> fruits=new ArrayList<>();

    public float getWeight(){
        if(fruits.size()>0) {
            return fruits.size() * fruits.get(0).WEIGHT;
        }else {
            return 0;
        }
    }

    public boolean compare(Box<?> anotherBox) {
        return (this.getWeight()==anotherBox.getWeight());
    }

    public void sprinkleBox(Box<T> anotherBox){
        anotherBox.getFruits().addAll(this.getFruits());
        this.getFruits().clear();
    }

    public void addFruit(T fruit){
        this.getFruits().add(fruit);
    }
}
