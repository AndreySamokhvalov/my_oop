package srс.console;

import srс.FamilyTree;
import srс.FileHandler;
import srс.Human;
import srс.presenter.Presenter;

import java.util.Scanner;

public class Console<T extends Human> {

    private FamilyTree familyTree;
    private FileHandler fileHandler;
    private Presenter presenter;

    public Console(FamilyTree familyTree, FileHandler fileHandler, Presenter presenter) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.presenter = presenter;

        this.familyTree.setWritable(fileHandler);

        this.familyTree = familyTree.readFamilyTree();
        presenter.setFamilyTree(this.familyTree);
    }

    private T getHuman(FamilyTree familyTree) {
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
        System.out.print("Введите имя отца: ");
        str = iScanner.nextLine();
        String nameFather = str.substring(0, 1).toUpperCase() + str.substring(1);
        Human newFather = familyTree.searchName(nameFather);

        System.out.print("Введите имя матери: ");
        str = iScanner.nextLine();
        String nameMother = str.substring(0, 1).toUpperCase() + str.substring(1);
        Human newMother = familyTree.searchName(nameMother);
        familyTree.setRelative(newFather, newMother, human);
        
        return (T) human;

    }

    public void go() {
        Scanner iScanner = new Scanner(System.in);
        boolean repeat = true;
        T human;
        while (repeat) {
            System.out.println("Введите действие:");
            
            System.out.println("1 - показать всех членов семьи");
            System.out.println("2 - добавить нового члена семьи");
            System.out.println("3 - найти члена семьи по имени");
            System.out.println("4 - показать всех детей члена семьи");
            System.out.println("5 - сортировка членов семьи по имени");
            System.out.println("6 - сортировка членов семьи по возрасту).");
            System.out.println("Enter - выход + сохранение FamilyTree.dat ");
            
            System.out.print("-->\t");
            String str = iScanner.nextLine();
            switch (str) {
                case "":
                    // сохраняем FamilyTree в файл и выходим из цикла while
                    presenter.saveFamilyTree();
                    repeat = false;
                    break;
                case "1":
                    presenter.printFamilyTree();
                    break;
                case "2":
                    human = this.getHuman(familyTree);
                    presenter.addNewHuman(human);
                    break;
                case "3":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    System.out.println(presenter.searchHuman(str));

                    break;
                case "4":
                    System.out.print("Введите имя: ");
                    str = iScanner.nextLine();
                    System.out.println(presenter.getAllChildren(str));
                    break;
                case "5":
                System.out.println(presenter.sortFamilyTree("name"));
                    break;
                case "6":
                System.out.println(presenter.sortFamilyTree("age"));
                    break;
                default:
                    System.out.println("Некорректный ввод.");
                    break;
            }
        }
        iScanner.close();
    }

}