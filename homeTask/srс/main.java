package srс;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
        familyTree.setWritable(fileHandler);
        familyTree = familyTree.readFamilyTree();

        // очистка консоли
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Добро пожаловать!");

        // familyTree.add("Олег", "муж", null, null, 30);
        // familyTree.add("Маша", "жен", null, null, 32);

        List<Human> humans = familyTree.getHumans();

        List<String> menu = readMenu();

        // храним критерии в HashMap
        Map<Integer, String> criteria = new HashMap<>();
        int k = 1;
        for (String i : menu) {
            criteria.putIfAbsent(k, i);
            k++;
        }

        Scanner input = new Scanner(System.in);
        boolean mainLoop = true;

        int choice;
        do {
            for (Object entryObj : criteria.entrySet()) {
                Map.Entry entry = (Map.Entry) entryObj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.printf("%s - %s%n", key, value);
            }
            System.out.println("Выбирите пункт меню: ");
            choice = input.nextInt();

            switch (choice) {
                // показать всех
                case 1:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    familyTree.printHumans(humans);
                    if (familyTree.getHumans().size() == 0) {
                        System.out.printf("В семейном дереве пока нет записей%n");
                    }
                    int qq;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner q = new Scanner(System.in, "Cp866");
                        qq = q.nextInt();

                        switch (qq) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", qq);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (qq != 2 & qq != 1);
                    break;

                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    Human human = familyTree.createHuman();
                    System.out.print("Введите имя отца: ");
                    Scanner inameFather = new Scanner(System.in, "Cp866");
                    String InameFather = inameFather.nextLine();
                    String nameFather = InameFather.substring(0, 1).toUpperCase() + InameFather.substring(1);
                    Human newFather = familyTree.searchName(nameFather);

                    System.out.print("Введите имя матери: ");
                    Scanner inameMother = new Scanner(System.in, "Cp866");
                    String InameMother = inameMother.nextLine();
                    String nameMother = InameMother.substring(0, 1).toUpperCase() + InameMother.substring(1);
                    Human newMother = familyTree.searchName(nameMother);

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    familyTree.setRelative(newFather, newMother, human);
                    familyTree.addNewHuman(human);

                    int rr;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner r = new Scanner(System.in, "Cp866");
                        rr = r.nextInt();

                        switch (rr) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", rr);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (rr != 2 & rr != 1);
                    break;
                // поиск по имени
                case 3:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Добро пожаловать!");
                    System.out.println("Введите имя человека, которого хотите найти: ");
                    Scanner iname = new Scanner(System.in, "Cp866");
                    String Iname = iname.nextLine();
                    String name = Iname.substring(0, 1).toUpperCase() + Iname.substring(1);
                    System.out.println(familyTree.searchName(name));
                    int ww;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner w = new Scanner(System.in, "Cp866");
                        ww = w.nextInt();

                        switch (ww) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", ww);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (ww != 2 & ww != 1);
                    break;

                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    familyTree.getRelative(humans);
                    int ll;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner l = new Scanner(System.in, "Cp866");
                        ll = l.nextInt();

                        switch (ll) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", ll);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException eo) {
                                    eo.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (ll != 2 & ll != 1);
                    break;

                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("Введите имя человека, что бы увидеть список его детей: ");
                    Scanner yname = new Scanner(System.in, "Cp866");
                    String Yname = yname.nextLine();
                    String parentName = Yname.substring(0, 1).toUpperCase() + Yname.substring(1);
                    Human parent = (familyTree.searchName(parentName));
                    System.out.printf("Дети человека по имени %s:\n", parent.getName());
                    ArrayList<Human> children = parent.getChildren();
                    parent.printChildren(children);
                    int ee;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner e = new Scanner(System.in, "Cp866");
                        ee = e.nextInt();

                        switch (ee) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", ee);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException eo) {
                                    eo.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (ee != 2 & ee != 1);

                    break;

                case 6:
                    // очистка консоли
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Добро пожаловать!");
                    familyTree.sortByName();
                    familyTree.printHumans(humans);

                    int uu;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner u = new Scanner(System.in, "Cp866");
                        uu = u.nextInt();

                        switch (uu) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", uu);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException eo) {
                                    eo.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (uu != 2 & uu != 1);

                    break;

                case 7:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    familyTree.sortByAge();
                    familyTree.printHumans(humans);
                    int pp;// переменная для выбора в подменю
                    do {
                        System.out.printf("%n1 - Выполнить новую команду%n2 - Выход%n");
                        Scanner p = new Scanner(System.in, "Cp866");
                        pp = p.nextInt();

                        switch (pp) {
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                            case 2:
                                // очистка консоли
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                familyTree.saveFamilyTree();
                                System.out.println("До свидания!");
                                System.exit(0);

                            default:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.printf("Пункта %d нет в меню%n", pp);
                                try {
                                    Thread.sleep(2000);
                                } catch (InterruptedException eo) {
                                    eo.printStackTrace();
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                break;
                        }

                    } while (pp != 2 & pp != 1);

                    break;
                case 8:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    familyTree.saveFamilyTree();
                    System.out.println("До свидания");
                    System.exit(0);
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.printf("Пункта %d нет в меню%n", choice);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException eo) {
                        eo.printStackTrace();
                    }
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

            }
        } while (choice != 6);
    }

    // чтение файла
    public static List<String> readMenu() {
        List<String> arr = new ArrayList<String>();
        File file = new File("D:\\AndyData\\my_oop\\homeTask\\srс\\menu.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                arr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

}
