package srс.commands;

import srс.console.Console;

public class Command_1 implements Commands{
    Console console;

    public Command_1(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
//        сохраняем FamilyTree
        console.getPresenter().saveFamilyTree();
//        завершаем работу приложения
        System.exit(0);
    }

    @Override
    public String description() {
        return " выход + сохранение в FamilyTree.dat";
    }
}
