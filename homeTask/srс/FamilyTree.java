package srс;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import srс.comparators.Comparator;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> humans;
    private Writable writable;

    /**
     * создаение конструкторов
     */

    public FamilyTree(Writable writable) {
        this.humans = new ArrayList<>();
        this.writable = writable;
    }

    public List<T> getHumans() {
        return humans;
    }

    public void saveFamilyTree() {
        writable.save(this);
    }

    public FamilyTree readFamilyTree() {
        if (writable != null) {
            if (writable.read() == null) {
                System.out.println("FamilyTree в файле нет! Создаём новое FamilyTree.");
                return new FamilyTree(writable);
            } else {
                System.out.println("FamilyTree загружено из файла.");
                return (FamilyTree) writable.read();
            }
        } else {
            System.out.println("Файл не загружен!");
            return null;
        }
    }

    /**
     * поиск по имени
     */
    public Human searchName(String name) {
        Human human = new Human();
        for (Human h : humans) {
            if (h.getName().equalsIgnoreCase(name)) {
                human = h;
            }
        }
        return human;
    }

    /**
     * печать всех
     */
    public void printHumans() {
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    public void setHumans(List<T> humans) {
        this.humans = (List<T>) humans;
    }

    /**
     * создание родственных связей
     */
    public void setRelative(Human father, Human mother, Human child) { // НУЖНЫ ПРОВЕРКИ НА НОЛЬ

        child.setFather(father);
        child.setMother(mother);
        father.relativ(child);
        mother.relativ(child);

    }

    // добавление нового члена семьи
    public void addNewHuman(T newHuman) {
        this.humans.add(newHuman);
        System.out.printf("Добавлен новый член семьи %s\n", newHuman.getName());
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    @Override
    public String toString() {
        StringBuilder familyMembers = new StringBuilder();
        System.out.printf("Всего людей в дереве - %d\n", humans.size());
        int count = 0;
        for (T member : this) {
            familyMembers.append("Член семьи ").append(++count).append(" - ").append(member.getName()).append(", ")
                    .append("возраст ").append(member.getAge()).append("\n");
        }
        return familyMembers.toString();
    }

    /**
     * печать связи ребенок - родители
     */
    public void getRelative(List<T> humans) {
        for (T h : humans) {
            if (h.getFather() != null && h.getMother() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("\nимя: ")
                        .append(h.getName())
                        .append("\n" + "отец: ")
                        .append(h.getFather().getName())
                        .append("\n" + "мать: ")
                        .append(h.getMother().getName()); // + "\n");
                System.out.println(sb.toString());

            } else {
                System.out.printf("\nимя: %s \nРодители неизвестны\n", h.getName());
            }
        }
    }

    public void sortFamilyTree(String sortParameter) {
        Collections.sort(this.getHumans(), new Comparator(sortParameter));
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<T>(humans);
    }

}
