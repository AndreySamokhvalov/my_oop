package scr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import comparators.ComparatorByAge;

public class FamilyTree implements Serializable {
    private List<Human> humans;
    private Writable writable;

    /**
     * создаение конструкторов
     */
    public FamilyTree(List<Human> humans) {
        this.humans = humans;
    }

    public FamilyTree() {
        this(new ArrayList<>());
        this.writable = new FileHandler();
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void saveFamilyTree() {
        // if (writable != null) {
        //     if (writable instanceof FileHandler) {
                writable.save(this);
        //     }
        // } else {
        //     System.out.println("Ошибка!");
        // }
    }

    public FamilyTree readFamilyTree() {
        if (writable != null) {
            if (writable instanceof FileHandler) {
                if ((((FileHandler) writable).read()) == null) {
                    System.out.println("Файл отсутсвует!");// метод создания дерева
                    // return new FamilyTree();
                } else {
                    return ((FileHandler) writable).read();
                }
            }
        }
        return null;
    }

    // ----------------------------------------------------
    /**
     * добавление
     */
    public void add(String name, String gender, Human father, Human mother, int age) {
        Human human = new Human(name, gender, father, mother, age);
        humans.add(human);
    }

    /**
     * поиск по имени
     */
    public Human searchName(String name) {
        Human human = new Human();
        for (Human h : humans) {
            if (h.getName().equals(name)) {
                human = h;
            }
        }
        return human;
    }

    /**
     * печать всех
     */
    public void printHumans(List<Human> humans) {
        for (Human h : humans) {
            System.out.println(h);
        }
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
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
    public void addNewHuman(Human newHuman) {
        this.humans.add(newHuman);
        System.out.printf("Добавлен новый член семьи %s\n", newHuman.getName());
    }

    public void setWritable(Writable writable) {
        this.writable = writable;
    }

    public Human createHuman(){
        Human human = new Human();
                    Scanner iScanner = new Scanner(System.in, "Cp866");
                    System.out.print("Введите имя: ");
                    String str = iScanner.nextLine();
                    String nameStr = str.substring(0, 1).toUpperCase() + str.substring(1);
                    human.setName(nameStr);

                    System.out.print("Введите пол: ");
                    str = iScanner.nextLine();
                    human.setGender(str);

                    System.out.print("Введите возраст: ");
                    try {
                        str = iScanner.nextLine();
                        human.setAge(Integer.parseInt(str));
                    } catch (Exception exception) {
                        System.out.println("Возраст не может быть задан в таком виде!");
                        human.setAge(0);
                    }
           
                 return human;
    }

    public void sortByName(){
        Collections.sort(this.getHumans());
    }


    public void sortByAge(){
        Collections.sort(this.getHumans(), new ComparatorByAge());
    }

    
    
    /**
     * печать связи ребенок - родители
     */
    public void getRelative(List<Human> humans) {
        for (Human h : humans) {
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
}
