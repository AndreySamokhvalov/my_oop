package comparators;


import scr.Human;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human first, Human second) {
        return Integer.compare(first.getAge(), second.getAge());
    }
}