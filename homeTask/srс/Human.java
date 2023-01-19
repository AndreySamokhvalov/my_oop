package srс;
import java.io.Serializable;
import java.util.ArrayList;

public class Human implements Serializable, Comparable<Human>  {
    private String name;
    private String gender;
    private Human father;
    private Human mother;
    private int age;
    private ArrayList<Human> children;

    /**
     * конструкторы
     */
    public Human(String name, String gender, Human father, Human mother, int age) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.age = age;
        this.children = new ArrayList<>();

    }

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public Human() {
    
    }

    /**
     * геттеры и сеттры
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public String getAllChildren() {
        StringBuilder kids = new StringBuilder();
        if (this.children.size() > 0) {
            kids.append("У ").append(this.getName()).append(" есть ");
            for (Human child : this.children) {
                kids.append(child.getGender().equals("муж") ? "Сын" : "Дочь").append(" - ").append(child.getName()).append(" ");
            }
        } else {
            kids.append("У ").append(this.getName()).append(" детей нет.");
        }
        return kids.toString();
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    /**
     * печать списка детей
     */
    public void printChildren(ArrayList<Human> children) {
        for (Human h : children) {
            System.out.println(h); 
        }
    }

    public void relativ(Human child) {
        getChildren().add(child);
    }

    

    @Override
    public int compareTo(Human human) {
        return name.compareTo(human.getName());
    }

    /**
     * перегрузка toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ")
                .append("\n" + name + "\n")
                .append("пол: ")
                .append(gender  + "\n")
                .append("возраст: ")
                .append(age  + "\n");
        String res = sb.toString();
        return res;

    }

}
