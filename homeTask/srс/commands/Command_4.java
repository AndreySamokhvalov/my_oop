package srс.commands;

import srс.Human;
import srс.console.Console;


public class Command_4 implements Commands {
    Console console;

    public Command_4(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
//        получаем имя
        String str = console.getName();
//        находим нового члена FamilyTree
        if (console.getPresenter().searchHuman(str)!=null) {
            System.out.printf("Нашёл\n%s\n", console.getPresenter().searchHuman(str));
        }else System.out.printf("%s нет в FamilyTree!\n", str);
    }

    @Override
    public String description() {
        return "найти члена семьи по имени";
    }
}