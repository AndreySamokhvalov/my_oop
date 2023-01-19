package srс.commands;

import srс.console.Console;

public class Command_6 implements Commands {
    Console console;

    public Command_6(Console console) {
        this.console = console;
    }

    @Override
    public void execute() {
        System.out.println(console.getPresenter().sortFamilyTree("name"));
    }

    @Override
    public String description() {
        return "сортировка членов семьи по имени";
    }
}