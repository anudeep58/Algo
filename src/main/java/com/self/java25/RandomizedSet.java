package com.self.java25;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {

    Set<Integer> randomSet ;
    Random random;

    public RandomizedSet() {
            randomSet = new HashSet<>();
            random = new Random();
    }

    public boolean insert(int val) {
        if(!randomSet.contains(val)) {
            randomSet.add(val);
            return true;
        }
        else return false;
    }

    public boolean remove(int val) {
        if(randomSet.contains(val)) {
            randomSet.remove(val);
            return true;
        }
        else return false;
    }

    public int getRandom() {
        ArrayList<Integer> list = new ArrayList<>(randomSet);
        int rdm =  random.nextInt(list.size());
        return list.get(rdm);
    }
}
