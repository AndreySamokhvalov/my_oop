package srс.console;

import srс.FamilyTree;
import srс.FileHandler;
import srс.Human;
import srс.commands.*;
import srс.presenter.Presenter;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Console<T extends Human> {

    private FamilyTree familyTree;
    private FileHandler fileHandler;
    private Presenter presenter;
    List<Commands> commandsList;

    public Console(FamilyTree familyTree, FileHandler fileHandler, Presenter presenter) {
        this.familyTree = familyTree;
        this.fileHandler = fileHandler;
        this.presenter = presenter;

        this.familyTree.setWritable(fileHandler);

        this.familyTree = familyTree.readFamilyTree();
        presenter.setFamilyTree(this.familyTree);
        commandsList = new ArrayList<>();
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    
        public Presenter getPresenter() {
            return presenter;
        }
        public T getHuman(FamilyTree familyTree) {
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
            System.out.println("Неверный формат возраста");
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

    public String getName() {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        return iScanner.nextLine();
    }

    public void go() {
        Scanner iScanner = new Scanner(System.in);
        T human;
        
        commandsList.add(new Command_2(this));
        commandsList.add(new Command_3(this));
        commandsList.add(new Command_4(this));
        commandsList.add(new Command_5(this));
        commandsList.add(new Command_6(this));
        commandsList.add(new Command_7(this));
        commandsList.add(new Command_1(this));

        while (true) {
            System.out.println("Выберите команду:");
            for (int i = 1; i < commandsList.size(); i++) {
                System.out.println(i + " - " + commandsList.get(i).description());
            }
            
            System.out.print("-->\t");
            String str = iScanner.nextLine();

            try {
                int choice = Integer.parseInt(str);
                if ((choice >= 0) & (choice < commandsList.size())) {
                    commandsList.get(Integer.parseInt(str)).execute();
                } else {
                    System.out.println("Такой команды не существует!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Не корректный ввод! Попробуйте ещё раз.");
            
        }

    }
}
}
