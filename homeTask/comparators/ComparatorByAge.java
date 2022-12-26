package comparators;


import java.util.Comparator;

import srс.Human;

public class ComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human first, Human second) {
        return Integer.compare(first.getAge(), second.getAge());
    }
}