package srс.commands;

import srс.console.Console;

public class Command_2 implements Commands{
    Console console;

    public Command_2(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
//        печатаем FamilyTree
        console.getPresenter().printFamilyTree();
    }

    @Override
    public String description() {
        return "показать всех членов дерева";
    }
}